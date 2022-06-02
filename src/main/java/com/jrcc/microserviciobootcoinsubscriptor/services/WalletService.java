package com.jrcc.microserviciobootcoinsubscriptor.services;

import com.jrcc.microserviciobootcoinsubscriptor.models.documents.Currency;
import com.jrcc.microserviciobootcoinsubscriptor.models.documents.Transaction;
import com.jrcc.microserviciobootcoinsubscriptor.models.documents.Wallet;
import com.jrcc.microserviciobootcoinsubscriptor.models.repository.AccountRepository;
import com.jrcc.microserviciobootcoinsubscriptor.models.repository.CurrencyRepository;
import com.jrcc.microserviciobootcoinsubscriptor.models.repository.WalletRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.function.Consumer;

@Slf4j
@Service
public class WalletService {
    private final WalletRepository walletRepository;
    private final AccountRepository accountRepository;

    private final CurrencyRepository currencyRepository;

    public WalletService(WalletRepository walletRepository, AccountRepository accountRepository, CurrencyRepository currencyRepository) {
        this.walletRepository = walletRepository;
        this.accountRepository = accountRepository;
        this.currencyRepository = currencyRepository;
    }

    @Bean
    Consumer<Wallet> saveWallet() {
        return wallet -> {
            wallet.setCreationDate(new Date());
            walletRepository.save(wallet).subscribe();
            log.info("Wallet save:" + wallet);
        };
    }

    @Bean
    Consumer<Transaction> sendCurrency() {
        /*return transaction -> walletRepository.findByCellphoneNumber(transaction.getSource()).map(wallet -> {
            //Disminuye moneda virtual en el monedero BootCoin
            wallet.setBalance(wallet.getBalance() - transaction.getAmount());
            //Incrementa dinero de cuenta
            accountRepository.findById(wallet.getIdCard()).map(account -> {
                var newBalance = account.getBalance() + (transaction.getAmount() * currencyRepository.findById(wallet.getIdCurrency()).map(Currency::getSellingRate).block());
                account.setBalance(newBalance);
                return account;
            }).flatMap(accountRepository::save).subscribe();
            log.info("sendCurrency");
            return wallet;
        }).flatMap(walletRepository::save).subscribe();*/


        return transaction -> walletRepository.findByCellphoneNumber(transaction.getSource()).map(wallet -> {
            //Disminuye moneda virtual en el monedero BootCoin
            wallet.setBalance(wallet.getBalance() - transaction.getAmount());
            //Incrementa dinero de cuenta
            /*accountRepository.findById(wallet.getIdAccount()).map(account -> {
                var newBalance = account.getBalance() + (transaction.getAmount() * currencyRepository.findById(wallet.getIdCurrency()).map(Currency::getSellingRate).block());
                account.setBalance(newBalance);
                return account;
            }).flatMap(accountRepository::save);
            log.info("sendCurrency");*/
            return wallet;
        }).flatMap(walletRepository::save).subscribe();
    }

    @Bean
    Consumer<Transaction> receiveCurrency() {
        return transaction -> walletRepository.findByCellphoneNumber(transaction.getDestination()).map(wallet -> {
            //Incrementa moneda virtual en el monedero BootCoin
            wallet.setBalance(wallet.getBalance() + transaction.getAmount());
            //Disminuye dinero de cuenta
            /*accountRepository.findById(wallet.getIdAccount()).map(account -> {
                var newBalance = account.getBalance() - (transaction.getAmount() * currencyRepository.findById(wallet.getIdCurrency()).map(Currency::getSellingRate).block());
                account.setBalance(newBalance);
                return account;
            }).flatMap(accountRepository::save);*/
            log.info("receiveCurrency");
            return wallet;
        }).flatMap(walletRepository::save).subscribe();
    }
}

package com.jrcc.microserviciobootcoinsubscriptor.services;

import com.jrcc.microserviciobootcoinsubscriptor.models.documents.Transaction;
import com.jrcc.microserviciobootcoinsubscriptor.models.repository.TransactionRepository;
import com.jrcc.microserviciobootcoinsubscriptor.models.repository.WalletRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.function.Consumer;

@Slf4j
@Service
public class TransactionService {
    private final TransactionRepository transactionRepository;

    private final StreamBridge streamBridge;

    public TransactionService(TransactionRepository transactionRepository, StreamBridge streamBridge) {
        this.transactionRepository = transactionRepository;
        this.streamBridge = streamBridge;
    }

    @Bean
    Consumer<Transaction> saveTransaction() {
        return transaction -> {
            transaction.setCreationDate(new Date());
            transactionRepository.save(transaction).subscribe();
            //Publicando transaccion para los wallets
            streamBridge.send("sendCurrency-out-0", transaction);
            streamBridge.send("receiveCurrency-out-0", transaction);
            log.info("Transaction save:" + transaction);
        };
    }
}

package com.jrcc.microserviciobootcoinsubscriptor.services;

import com.jrcc.microserviciobootcoinsubscriptor.models.documents.Currency;
import com.jrcc.microserviciobootcoinsubscriptor.models.repository.CurrencyRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.function.Consumer;

@Slf4j
@Service
public class CurrencyService {
    private final CurrencyRepository currencyRepository;

    public CurrencyService(CurrencyRepository currencyRepository) {
        this.currencyRepository = currencyRepository;
    }

    @Bean
    Consumer<Currency> saveCurrency() {
        return currency -> {
            currency.setCreationDate(new Date());
            currencyRepository.save(currency).subscribe();
            log.info("Currency save:" + currency.getName());
        };
    }
}

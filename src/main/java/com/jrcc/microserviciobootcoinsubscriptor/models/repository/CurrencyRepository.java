package com.jrcc.microserviciobootcoinsubscriptor.models.repository;

import com.jrcc.microserviciobootcoinsubscriptor.models.documents.Currency;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CurrencyRepository extends ReactiveMongoRepository<Currency, String> {
}

package com.jrcc.microserviciobootcoinsubscriptor.models.repository;

import com.jrcc.microserviciobootcoinsubscriptor.models.documents.Transaction;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends ReactiveMongoRepository<Transaction, String> {
}

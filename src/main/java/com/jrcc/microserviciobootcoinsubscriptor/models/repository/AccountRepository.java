package com.jrcc.microserviciobootcoinsubscriptor.models.repository;

import com.jrcc.microserviciobootcoinsubscriptor.models.documents.Account;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends ReactiveMongoRepository<Account, String> {
}

package com.jrcc.microserviciobootcoinsubscriptor.models.repository;

import com.jrcc.microserviciobootcoinsubscriptor.models.documents.Wallet;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface WalletRepository extends ReactiveMongoRepository<Wallet, String> {
    Mono<Wallet> findByCellphoneNumber(String cellphoneNumber);
}

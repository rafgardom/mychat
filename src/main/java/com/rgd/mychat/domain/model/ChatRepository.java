package com.rgd.mychat.domain.model;

import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;

import java.util.UUID;

public interface ChatRepository extends ReactiveCrudRepository<Chat, UUID> {

    @Query("select c from Chat c where (c.creatorUserId = ?1 and c.receiverUserId = ?2) or (c.creatorUserId = ?2 and c.receiverUserId = ?1)")
    Mono<Chat> findByChatByUsers(UUID userId1, UUID userId2);
}

package com.rgd.mychat.domain.model;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import java.util.UUID;

public interface MessageRepository extends ReactiveCrudRepository<Message, UUID> {
}

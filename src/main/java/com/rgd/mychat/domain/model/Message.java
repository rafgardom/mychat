package com.rgd.mychat.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Message {

    @Id
    private UUID id;

    @Column("body")
    private String body;

    @Column("user_id")
    private UUID userId;

    @Column("chat_id")
    private UUID chatId;
}

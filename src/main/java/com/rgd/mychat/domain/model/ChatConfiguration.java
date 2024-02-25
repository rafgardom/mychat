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
public class ChatConfiguration {

    @Id
    private UUID id;

    @Column("user_id")
    private UUID userId;

    //TODO to be completed
}

package com.rgd.mychat.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;

import java.time.LocalDateTime;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Chat {

    @Id
    private UUID id;

    @Column("creator_user_id")
    private UUID creatorUserId;

    @Column("receiver_user_id")
    private UUID receiverUserId;

    @Column("start_date")
    private LocalDateTime startDate;
}

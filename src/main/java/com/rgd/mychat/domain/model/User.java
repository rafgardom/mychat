package com.rgd.mychat.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    private UUID id;

    @Column("name")
    private String name;

    @Column("surname")
    private String surname;

    @Column("description")
    private String description;

    @Column("start_date")
    private LocalDateTime startDate;
}

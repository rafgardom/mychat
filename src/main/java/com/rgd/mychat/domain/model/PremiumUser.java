package com.rgd.mychat.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.relational.core.mapping.Column;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PremiumUser extends User{

    @Column("start_premium")
    private LocalDateTime startPremium;

    @Column("end_premium")
    private LocalDateTime endPremium;
}

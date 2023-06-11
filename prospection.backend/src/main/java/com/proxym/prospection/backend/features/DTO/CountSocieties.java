package com.proxym.prospection.backend.features.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CountSocieties {
    private Long count;
    private String type;
}

package com.aq.soft.avalith.developer.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author aquingaluisa
 * DTO para  transmitir data
 */
@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class DeveloperDTO {
    private String nombres_completos;

    private String link_github;

    private List<String> tecnologias_conocidas;
}

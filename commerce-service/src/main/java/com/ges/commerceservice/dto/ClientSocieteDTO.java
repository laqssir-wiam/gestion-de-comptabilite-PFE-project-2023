package com.ges.commerceservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author WIAM
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ClientSocieteDTO {
    private String firstname;
    private String lastname;
    private String email;
    private String responsabilite;
    private String telephone;
    private String societeId;
    private boolean isActif;
}

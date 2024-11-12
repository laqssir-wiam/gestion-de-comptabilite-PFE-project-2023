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
public class ProduitDTO {
    private String ref;
    private String libelle;
    private int quantite;
    private String clientId;
    private float prix;

}

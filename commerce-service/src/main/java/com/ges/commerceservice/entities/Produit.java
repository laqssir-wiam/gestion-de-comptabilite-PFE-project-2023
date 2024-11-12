package com.ges.commerceservice.entities;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author WIAM
 **/
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(collection = "produit")
public class Produit {
    @Id
    private String id;
    private String ref;
    private String libelle;
    private int quantite;
    private String clientId;
    private float prix;
}

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
public class Operation {
    @Id
    private String id;
    private String operation;
    private Produit produit;
    private int qnt;

}

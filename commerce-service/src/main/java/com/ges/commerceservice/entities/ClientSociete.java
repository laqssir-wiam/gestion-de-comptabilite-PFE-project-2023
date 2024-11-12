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
@Document(collection = "client")
public class ClientSociete {
    @Id
    private String id;
    private String firstname;
    private String lastname;
    private String email;
    private String responsabilite;
    private String telephone;
    private String societeId;
    private boolean isActif;
}

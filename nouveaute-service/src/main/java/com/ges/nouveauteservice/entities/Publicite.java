package com.ges.nouveauteservice.entities;

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
@Document(collection = "publicite")
public class Publicite {
    @Id
    private String id;
    private String user_id;
    private String username;
    private String contenue;
}

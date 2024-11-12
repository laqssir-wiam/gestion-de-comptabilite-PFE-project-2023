package com.ges.nouveauteservice.dto;

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
public class PubliciteDTO {
    private String user_id;
    private String username;
    private String contenue;
}

package com.ges.nouveauteservice.controllers;

import com.ges.nouveauteservice.dto.PubliciteDTO;
import com.ges.nouveauteservice.entities.Publicite;
import com.ges.nouveauteservice.repositories.PubliciteRepository;
import com.ges.nouveauteservice.services.PubliciteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.UUID;

/**
 * @author WIAM
 **/
@Controller
public class PubliciteGraphQLController {
    @Autowired
    private PubliciteService publiciteService;
    @Autowired
    private PubliciteRepository publiciteRepository;
    @QueryMapping
    public List<Publicite> listeDePublicationAll(){
        return publiciteRepository.findAll();
    }
    @QueryMapping
    public List<Publicite> listeDePubs(@Argument String userId){
        return publiciteService.listeDePubs(userId);
    }
    @MutationMapping
    public Publicite ajouterPublicite(@Argument PubliciteDTO publiciteDTO){
        System.out.println("here: "+publiciteDTO.getContenue());
        return publiciteService.ajouterPublicite(publiciteDTO);
    }
    @MutationMapping
    public Publicite supprimerPublicite(@Argument String id){
        return publiciteService.supprimerPublicite(id);
    }
}

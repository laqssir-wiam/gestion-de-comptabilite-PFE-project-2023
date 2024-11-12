package com.ges.nouveauteservice.services;

import com.ges.nouveauteservice.dto.PubliciteDTO;
import com.ges.nouveauteservice.entities.Publicite;
import com.ges.nouveauteservice.repositories.PubliciteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @author WIAM
 **/
@Service
public class PubliciteService {
    @Autowired
    private PubliciteRepository publiciteRepository;
    public Publicite ajouterPublicite(PubliciteDTO publiciteDTO){
        Publicite publicite=Publicite.builder()
                .id(UUID.randomUUID().toString())
                .user_id(publiciteDTO.getUser_id())
                .username(publiciteDTO.getUsername())
                .contenue(publiciteDTO.getContenue())
                .build();
;
        System.out.println("added: "+publiciteRepository.save(publicite));

        return publicite;
    }
    public Publicite supprimerPublicite(String id){
        Publicite publicite=publiciteRepository.findById(id).get();
        publiciteRepository.delete(publicite);
        return publicite;
    }
    public List<Publicite> listeDePubs(String idUser){
        List<Publicite> publicites=publiciteRepository.findAll();
        List<Publicite> publicitesUser=new ArrayList<>();
        for (int i=0;i<publicites.size();i++){
            if(publicites.get(i).getUser_id().equals(idUser)){
                publicitesUser.add(publicites.get(i));
            }
        }
        return publicitesUser;
    }
}

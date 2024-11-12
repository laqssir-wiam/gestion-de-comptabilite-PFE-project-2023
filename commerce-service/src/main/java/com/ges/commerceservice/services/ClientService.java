package com.ges.commerceservice.services;

import com.ges.commerceservice.dto.ClientSocieteDTO;
import com.ges.commerceservice.entities.ClientSociete;
import com.ges.commerceservice.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author WIAM
 **/
@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;
    public List<ClientSociete> allClientOfSociete(String idSociete){
        List<ClientSociete> clients=clientRepository.findAll();
        List<ClientSociete> clientsSociete=new ArrayList<>();
        for (int i=0;i<clients.size();i++){
            if(clients.get(i).getSocieteId().equals(idSociete)){
                clientsSociete.add(clients.get(i));
            }
        }
        return clientsSociete;
    }
    public ClientSociete getClientById(String idClient){
        return clientRepository.findById(idClient).get();
    }
    public ClientSociete addClientSociete(ClientSocieteDTO clientDTO,String idClient){
        ClientSociete client= ClientSociete.builder()
                .id(idClient)
                .societeId(clientDTO.getSocieteId())
                .email(clientDTO.getEmail())
                .firstname(clientDTO.getFirstname())
                .lastname(clientDTO.getLastname())
                .responsabilite(clientDTO.getResponsabilite())
                .telephone(clientDTO.getTelephone())
                .isActif(true)
                .build();
        return clientRepository.save(client);
    }
    public ClientSociete updateClientSociete(ClientSocieteDTO clientDTO, String idClient){
        ClientSociete client=clientRepository.findById(idClient).get();
        client.setSocieteId(clientDTO.getSocieteId()!=null? clientDTO.getSocieteId():client.getSocieteId());
        client.setEmail(clientDTO.getEmail()!=null?clientDTO.getEmail():client.getEmail());
        client.setFirstname(clientDTO.getFirstname()!=null?clientDTO.getFirstname():client.getFirstname());
        client.setLastname(clientDTO.getLastname()!=null?clientDTO.getLastname():client.getLastname());
        client.setResponsabilite(clientDTO.getResponsabilite()!=null?clientDTO.getResponsabilite():client.getResponsabilite());
        client.setTelephone(clientDTO.getTelephone()!=null?clientDTO.getTelephone():client.getTelephone());
        return clientRepository.save(client);
    }
    public ClientSociete updateClientSocieteIsActif(boolean isActif,String idClient){
        ClientSociete client=clientRepository.findById(idClient).get();
        client.setActif(isActif);
        return clientRepository.save(client);
    }
    public ClientSociete deleteClient(String idClient){
        ClientSociete client=clientRepository.findById(idClient).get();
        clientRepository.delete(client);
        return client;
    }


}

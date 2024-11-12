package com.ges.commerceservice.web;

import com.ges.commerceservice.dto.ClientSocieteDTO;
import com.ges.commerceservice.entities.ClientSociete;
import com.ges.commerceservice.repositories.ClientRepository;
import com.ges.commerceservice.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * @author WIAM
 **/
@Controller
public class ClientController {
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private ClientService clientService;
    @QueryMapping
    public List<ClientSociete> allSocieteClients(@Argument String idSociete){
        return clientService.allClientOfSociete(idSociete);
    }
    @QueryMapping
    public ClientSociete getClientById(@Argument String idClient){
        return clientService.getClientById(idClient);
    }
    @MutationMapping
    public ClientSociete addClient(@Argument ClientSocieteDTO clientSocieteDTO,@Argument String idClient){
        return clientService.addClientSociete(clientSocieteDTO,idClient);
    }
    @MutationMapping
    public ClientSociete updateClient(@Argument ClientSocieteDTO clientDTO, @Argument String clientId){
        return clientService.updateClientSociete(clientDTO,clientId);
    }
    @MutationMapping
    public ClientSociete deleteClient(@Argument String clientId){
        return clientService.deleteClient(clientId);
    }
    @MutationMapping
    public ClientSociete updateClientSocieteIsActif(@Argument boolean isActif,@Argument String idClient){
        return clientService.updateClientSocieteIsActif(isActif,idClient);
    }
}

package com.ges.commerceservice.web;

import com.ges.commerceservice.dto.ProduitDTO;
import com.ges.commerceservice.entities.Operation;
import com.ges.commerceservice.entities.Produit;
import com.ges.commerceservice.repositories.OperrationRepository;
import com.ges.commerceservice.repositories.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @author WIAM
 **/
@Controller
public class ProduitController {
    @Autowired
    private ProduitRepository produitRepository;
    @Autowired
    private OperrationRepository operrationRepository;
    @MutationMapping
    public List<Produit> deleteall(){
        List<Produit> produits=produitRepository.findAll();
        List<Operation> operations=operrationRepository.findAll();

        for(int i=0;i<produits.size();i++){
            produitRepository.delete(produits.get(i));
        }
        for(int i=0;i<operations.size();i++){
            operrationRepository.delete(operations.get(i));
        }
        return produitRepository.findAll();
    }
    @QueryMapping
    public List<Produit> allProduit(){
        return produitRepository.findAll();
    }
    @QueryMapping
    public List<Produit> listOfProduitOfClient(@Argument String idClient){
        List<Produit> produits=produitRepository.findAll();
        List<Produit> produitsClient=new ArrayList<>();
        for(int i=0;i<produits.size();i++){
            if(produits.get(i).getClientId()!=null) {
                if(produits.get(i).getClientId().equals(idClient)){
                    produitsClient.add(produits.get(i));
                }
            }
        }
        return produitsClient;
    }
    @QueryMapping
    public List<Operation> listOperationClient(@Argument String idClient){
        List<Operation> operations=operrationRepository.findAll();
        List<Operation> operationsClient=new ArrayList<>();
        for(int i=0;i<operations.size();i++){
            if(operations.get(i).getProduit()!=null){
                if(operations.get(i).getProduit().getClientId().equals(idClient)){
                    operationsClient.add(operations.get(i));
                }
            }
        }
        return operationsClient;
    }
    @MutationMapping
    public Produit ajouterProduit(@Argument ProduitDTO produitDTO){
        Produit produit=Produit.builder()
                .id(UUID.randomUUID().toString())
                .libelle(produitDTO.getLibelle())
                .clientId(produitDTO.getClientId())
                .quantite(produitDTO.getQuantite())
                .ref(produitDTO.getRef())
                .prix(produitDTO.getPrix())
                .build();
        Operation operation=Operation.builder()
                .id(UUID.randomUUID().toString())
                .operation("Achat")
                .produit(produitRepository.save(produit))
                .qnt(produitDTO.getQuantite())
                .build();
        operrationRepository.save(operation);
        return produit;
    }
    @MutationMapping
    public Produit updateQnt(@Argument String idProduit, @Argument int qnt){
        Produit produit=produitRepository.findById(idProduit).get();
        produit.setQuantite(produit.getQuantite()-qnt);
        Produit produitSaved=produitRepository.save(produit);
        Operation operation=Operation.builder()
                .id(UUID.randomUUID().toString())
                .operation("Vente")
                .produit(produitSaved)
                .qnt(qnt)
                .build();
        operrationRepository.save(operation);
        return produitSaved;
    }
    @MutationMapping
    public Operation removeOperation(@Argument String idOperation){
        Operation operation=operrationRepository.findById(idOperation).get();
        operrationRepository.delete(operation);
        return operation;
    }
}

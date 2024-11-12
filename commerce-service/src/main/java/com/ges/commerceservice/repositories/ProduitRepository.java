package com.ges.commerceservice.repositories;

import com.ges.commerceservice.entities.Produit;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * @author WIAM
 **/
@RepositoryRestResource
public interface ProduitRepository extends MongoRepository<Produit,String> {
}

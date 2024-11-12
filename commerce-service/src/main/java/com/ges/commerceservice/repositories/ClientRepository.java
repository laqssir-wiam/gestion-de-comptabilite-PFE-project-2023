package com.ges.commerceservice.repositories;

import com.ges.commerceservice.entities.ClientSociete;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * @author WIAM
 **/
@RepositoryRestResource
public interface ClientRepository extends MongoRepository<ClientSociete,String> {
}

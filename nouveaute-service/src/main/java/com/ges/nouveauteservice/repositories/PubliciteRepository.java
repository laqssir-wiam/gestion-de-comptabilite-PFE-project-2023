package com.ges.nouveauteservice.repositories;

import com.ges.nouveauteservice.entities.Publicite;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * @author WIAM
 **/
@RepositoryRestResource
public interface PubliciteRepository extends MongoRepository<Publicite,String> {
}

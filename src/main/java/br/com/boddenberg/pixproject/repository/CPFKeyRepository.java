package br.com.boddenberg.pixproject.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.boddenberg.pixproject.entity.CPFKey;

public interface CPFKeyRepository extends MongoRepository<CPFKey, String> {

}

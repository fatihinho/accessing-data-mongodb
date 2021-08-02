package com.fcinar.accessingdatamongodb.repository;

import com.fcinar.accessingdatamongodb.model.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ICustomerRepository extends MongoRepository<Customer, String> {
    Customer findByName(String name);

    List<Customer> findBySurname(String surname);
}

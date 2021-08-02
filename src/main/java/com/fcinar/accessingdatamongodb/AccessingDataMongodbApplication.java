package com.fcinar.accessingdatamongodb;

import com.fcinar.accessingdatamongodb.model.Customer;
import com.fcinar.accessingdatamongodb.repository.ICustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AccessingDataMongodbApplication implements CommandLineRunner {
    private final ICustomerRepository customerRepository;

    public AccessingDataMongodbApplication(ICustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(AccessingDataMongodbApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        customerRepository.deleteAll();

        customerRepository.save(new Customer("Fatih", "Çınar"));
        customerRepository.save(new Customer("Faruk", "Çınar"));

        System.out.println("Customer'lar findAll() ile bulundu");
        System.out.println("----------------------------------");
        for (Customer customer : customerRepository.findAll()) {
            System.out.println(customer);
        }
        System.out.println();

        System.out.println("Customer findByName('Fatih') ile bulundu");
        System.out.println("---------------------------------");
        System.out.println(customerRepository.findByName("Fatih"));

        System.out.println("Customer'lar findBySurname('Çınar') ile bulundu");
        System.out.println("----------------------------------------");
        for (Customer customer : customerRepository.findBySurname("Çınar")) {
            System.out.println(customer);
        }
        System.out.println();
    }
}
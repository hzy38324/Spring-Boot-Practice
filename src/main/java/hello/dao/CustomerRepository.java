package hello.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import hello.model.Customer;


public interface CustomerRepository extends CrudRepository<Customer, Long> {
    List<Customer> findByLastName(String lastName);
}

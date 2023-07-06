package net.codejava.customer;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
	
	@Query(value = "SELECT c FROM Customer c WHERE c.name LIKE :keyword || '%'")
	public List<Customer> search(@Param("keyword") String keyword);
}

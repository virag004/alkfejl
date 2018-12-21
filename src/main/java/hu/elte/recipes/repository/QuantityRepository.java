package hu.elte.recipes.repository;

import hu.elte.recipes.model.Quantity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuantityRepository extends CrudRepository<Quantity, Integer> {
}
package hu.elte.recipes.repository;

import hu.elte.recipes.model.Instruction;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InstructionRepository extends CrudRepository<Instruction, Integer> {
}
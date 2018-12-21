package hu.elte.recipes.controller;

import hu.elte.recipes.model.Instruction;
import hu.elte.recipes.repository.InstructionRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/instructions") // !!!!!!!
public class InstructionController {

    @Autowired
    private InstructionRepository instructionRepository;

    @GetMapping("")
    public Iterable<Instruction> getAll() {
        return instructionRepository.findAll();
    }

    // @GetMapping("/{id}")
    // public ResponseEntity<Instruction> getById(@PathVariable Integer id) {
    //     Optional<Instruction> instruction = instructionRepository.findById(id);
    //     if (instruction.isPresent()) {
    //         return ResponseEntity.ok(instruction.get());
    //     } else {
    //         return ResponseEntity.notFound().build();
    //     }
    // }

    @PostMapping
    public ResponseEntity<Instruction> create(@RequestBody Instruction instruction) {
        if (instruction.getRecipeId() != null && instructionRepository.existsById(instruction.getRecipeId())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
        return ResponseEntity.ok(instructionRepository.save(instruction));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Instruction> replace(@PathVariable Integer id, @RequestBody Instruction instruction) {
        Optional<Instruction> oInstruction = instructionRepository.findById(id);
        if (oInstruction.isPresent()) {
            instruction.setRecipeId(oInstruction.get().getRecipeId());
            return ResponseEntity.ok(instructionRepository.save(instruction));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Instruction> modify(@PathVariable Integer id, @RequestBody Instruction instruction) {
        Optional<Instruction> oInstruction = instructionRepository.findById(id);
        if (oInstruction.isPresent()) {
            Instruction modifiableInstruction = oInstruction.get();
            if (instruction.getStep() != null) {
                modifiableInstruction.setStep((instruction.getStep()));
            }
            if (instruction.getDescription() != null) {
                modifiableInstruction.setDescription((instruction.getDescription()));
            }
            return ResponseEntity.ok(instructionRepository.save(modifiableInstruction));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Integer id) {
        Optional<Instruction> oInstruction = instructionRepository.findById(id);
        if (oInstruction.isPresent()) {
            instructionRepository.delete(oInstruction.get());
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
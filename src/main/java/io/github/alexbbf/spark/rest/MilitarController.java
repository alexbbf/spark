package io.github.alexbbf.spark.rest;

import io.github.alexbbf.spark.model.entity.Militar;
import io.github.alexbbf.spark.model.repository.MilitarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/militares")
public class MilitarController {

    @Autowired
    private MilitarRepository repository;

    @GetMapping
    public List<Militar> listarTodos() {
        return repository.findAll();
    }

    public Militar salvar(@RequestBody @Valid Militar militar){
        return  repository.save(militar);
    }

    @GetMapping("{id}")
    public Militar acharPorId(@PathVariable Integer id){
        return repository
                .findById(id)
                .orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Militar não encontrado"));
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar( @PathVariable Integer id){
        repository
                .findById(id)
                .map(militar -> {
                    repository.delete(militar);
                    return Void.TYPE;
                })
                .orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Militar não encontrado"));
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void atualizar( @PathVariable Integer id,
                           @RequestBody @Valid Militar militarAtualizado){
        repository
                .findById(id).map(militar -> {
            militarAtualizado.setId(militar.getId());
            return repository.save(militarAtualizado);

        })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Militar não encontrado"));
    }

}

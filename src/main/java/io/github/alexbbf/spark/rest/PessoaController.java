package io.github.alexbbf.spark.rest;

import io.github.alexbbf.spark.model.entity.Pessoa;
import io.github.alexbbf.spark.model.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/pessoas")
public class PessoaController {

    @Autowired
    private PessoaRepository repository;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Pessoa salvar( @RequestBody Pessoa pessoa){
        return repository.save(pessoa);
    }
}

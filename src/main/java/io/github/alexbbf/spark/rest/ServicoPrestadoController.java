package io.github.alexbbf.spark.rest;

import io.github.alexbbf.spark.model.entity.Pessoa;
import io.github.alexbbf.spark.model.entity.ServicoPrestado;
import io.github.alexbbf.spark.model.repository.PessoaRepository;
import io.github.alexbbf.spark.model.repository.ServicoPrestadoRepository;
import io.github.alexbbf.spark.rest.dto.ServicoPrestadoDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

@RestController
@RequestMapping("/api/servicos-prestados")
@RequiredArgsConstructor
public class ServicoPrestadoController {

    private final PessoaRepository pessoaRepository;
    private final ServicoPrestadoRepository repository;


    @PostMapping
    public ServicoPrestado salvar(@RequestBody ServicoPrestadoDTO dto){
        LocalDate data = LocalDate.parse(dto.getData(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        Integer idPessoa = dto.getIdPessoa();

        Pessoa pessoa =
                pessoaRepository
                        .findById(idPessoa)
                        .orElse(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Pessoa não encontrada"));

        ServicoPrestado servicoPrestado = new ServicoPrestado();
        servicoPrestado.setDescricao(dto.getDescricao());
        servicoPrestado.setData();

    }


}

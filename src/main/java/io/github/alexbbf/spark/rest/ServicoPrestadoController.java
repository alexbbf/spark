package io.github.alexbbf.spark.rest;

import io.github.alexbbf.spark.model.entity.Pessoa;
import io.github.alexbbf.spark.model.entity.ServicoPrestado;
import io.github.alexbbf.spark.model.repository.PessoaRepository;
import io.github.alexbbf.spark.model.repository.ServicoPrestadoRepository;
import io.github.alexbbf.spark.rest.dto.ServicoPrestadoDTO;
import io.github.alexbbf.spark.util.BigDecimalConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/servicos-prestados")
@RequiredArgsConstructor
public class ServicoPrestadoController {

    private final PessoaRepository pessoaRepository;
    private final ServicoPrestadoRepository repository;
    private final BigDecimalConverter bigDecimalConverter;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ServicoPrestado salvar(@RequestBody @Valid ServicoPrestadoDTO dto){
        LocalDate data = LocalDate.parse(dto.getData(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        Integer idPessoa = dto.getIdPessoa();
        Pessoa pessoa =
                pessoaRepository
                        .findById(idPessoa)
                        .orElseThrow(() ->
                                new ResponseStatusException(
                                        HttpStatus.BAD_REQUEST, "Pessoa não encontrada"));

        ServicoPrestado servicoPrestado = new ServicoPrestado();
        servicoPrestado.setDescricao(dto.getDescricao());
        servicoPrestado.setData( data);
        servicoPrestado.setPessoa(pessoa);
        servicoPrestado.setValor(bigDecimalConverter.converter(dto.getPreco()));

        return repository.save(servicoPrestado);

    }

    @GetMapping
    public List<ServicoPrestado> pesquisar(
            @RequestParam(value = "nome", required = false, defaultValue = "") String nome,
            @RequestParam(value = "mes", required = false) Integer mes
    ){
        return repository.findByNomeClienteAndMes("%"+nome+"%", mes);
    }


}

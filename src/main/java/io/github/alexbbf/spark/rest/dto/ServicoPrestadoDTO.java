package io.github.alexbbf.spark.rest.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
public class ServicoPrestadoDTO {

    @NotNull(message = "{campo.descricao.obrigatorio}")
    private String descricao;

    @NotNull(message = "{campo.preco.obrigatorio}")
    private String preco;

    @NotNull(message = "{campo.data.obrigatorio}")
    private String data;

    @NotNull(message = "{campo.pessoa.obrigatorio}")
    private Integer idPessoa;
}

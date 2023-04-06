package br.com.xbinario.v1;


import javax.validation.constraints.NotBlank;
import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.Data;

@Data
@RegisterForReflection
public class RequestDTO {

    @NotBlank (message = "Campo obrigatório")
    private String number;

    @NotBlank (message = "Campo obrigatório")
    private String name;

    @NotBlank (message = "Campo obrigatório")
    private String expirationDate;

    @NotBlank (message = "Campo obrigatório")
    private String cvv;
}

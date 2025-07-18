package br.com.r2nsistemas.gestao_de_clientes_com_chatbot.dto;

import org.springframework.beans.BeanUtils;

import br.com.r2nsistemas.gestao_de_clientes_com_chatbot.entity.ClienteEntity;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ClienteDTO {
	
	private Long id;

	@NotBlank(message = "O nome é obrigatório")
	private String nome;

	@NotBlank(message = "O CPF é obrigatório")
	private String cpf;

	@NotBlank(message = "O e-mail é obrigatório")
	@Email(message = "E-mail inválido")
	private String email;

	@NotBlank(message = "O telefone é obrigatório")
	@Pattern(regexp = "^[0-9]{12}$", message = "O telefone deve conter 12 dígitos numéricos. (Ex:556499999999)")
	private String telefone;

	@NotBlank(message = "O endereço é obrigatório")
	private String endereco;

	@NotBlank(message = "O complemento é obrigatório")
	private String complemento;
	
	@NotBlank(message = "O bairro é obrigatório")
	private String bairro;

	@NotBlank(message = "A cidade é obrigatória")
	private String cidade;

	@NotBlank(message = "O estado é obrigatório")
	private String estado;

	public ClienteDTO(ClienteEntity cliente) {
		BeanUtils.copyProperties(cliente, this);
	}

}
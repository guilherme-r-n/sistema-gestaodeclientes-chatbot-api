package br.com.r2nsistemas.gestao_de_clientes_com_chatbot.dto;

import org.springframework.beans.BeanUtils;

import br.com.r2nsistemas.gestao_de_clientes_com_chatbot.entity.UsuarioEntity;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UsuarioDTO {
	
	private Long id;

	@NotBlank(message = "O nome é obrigatório")
	private String nome;

	@NotBlank(message = "O login é obrigatório")
	private String login;
	
	@NotBlank(message = "A senha é obrigatória")
	@Pattern(regexp = "^[0-9]{8}$", message = "A senha deve conter 8 dígitos numéricos. (Ex:99999999)")
	private String senha;

	@NotBlank(message = "O e-mail é obrigatório")
	@Email(message = "E-mail inválido")
	private String email;
	
	public UsuarioDTO(UsuarioEntity usuario) {
		BeanUtils.copyProperties(usuario, this);
	}

}

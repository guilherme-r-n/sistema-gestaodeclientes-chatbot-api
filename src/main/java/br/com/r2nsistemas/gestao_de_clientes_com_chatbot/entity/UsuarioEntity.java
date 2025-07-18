package br.com.r2nsistemas.gestao_de_clientes_com_chatbot.entity;

import org.springframework.beans.BeanUtils;

import br.com.r2nsistemas.gestao_de_clientes_com_chatbot.dto.UsuarioDTO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "CAD_USUARIOS")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(callSuper=false, of = "id")
public class UsuarioEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String nome;

	@Column(nullable = false, unique = true)
	private String login;

	@Column(nullable = false)
	private String senha;

	@Column(nullable = false)
	private String email;
	
	public UsuarioEntity(UsuarioDTO usuario) {
		BeanUtils.copyProperties(usuario, this);
	}

}

package br.com.r2nsistemas.gestao_de_clientes_com_chatbot.entity;

import org.springframework.beans.BeanUtils;

import br.com.r2nsistemas.gestao_de_clientes_com_chatbot.dto.ClienteDTO;
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
@Table(name = "CAD_CLIENTES")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(callSuper=false, of = "id")
public class ClienteEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String nome;

	@Column(nullable = false, unique = true)
	private String cpf;

	@Column(nullable = false)
	private String email;

	@Column(nullable = false)
	private String telefone;

	@Column(nullable = false)
	private String endereco;

	@Column(nullable = false)
	private String complemento;
	
	@Column(nullable = false)
	private String bairro;

	@Column(nullable = false)
	private String cidade;

	@Column(nullable = false)
	private String estado;

	public ClienteEntity(ClienteDTO cliente) {
		BeanUtils.copyProperties(cliente, this);
	}

}
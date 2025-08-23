package br.com.r2nsistemas.gestao_de_clientes_com_chatbot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.r2nsistemas.gestao_de_clientes_com_chatbot.dto.PerfilUsuarioDTO;
import br.com.r2nsistemas.gestao_de_clientes_com_chatbot.entity.PerfilUsuarioEntity;
import br.com.r2nsistemas.gestao_de_clientes_com_chatbot.repository.PerfilUsuarioRepository;

@Service
public class PerfilUsuarioService {
	
	@Autowired
	private PerfilUsuarioRepository perfilUsuarioRepository;
	
	public void inserir(PerfilUsuarioDTO perfilUsuario) {
		PerfilUsuarioEntity perfilUsuarioEntity = new PerfilUsuarioEntity(perfilUsuario);
		perfilUsuarioRepository.save(perfilUsuarioEntity);
	}

	public List<PerfilUsuarioDTO> listarTodos() {
		List<PerfilUsuarioEntity> perfisUsuarios = perfilUsuarioRepository.findAll();
		return perfisUsuarios.stream().map(PerfilUsuarioDTO::new).toList();
	}

	public PerfilUsuarioDTO atualizar(PerfilUsuarioDTO perfilUsuario) {
		PerfilUsuarioEntity perfilUsuarioEntity = new PerfilUsuarioEntity(perfilUsuario);
		return new PerfilUsuarioDTO(perfilUsuarioRepository.save(perfilUsuarioEntity));
	}

	public void deletar(Long id) {
		PerfilUsuarioEntity perfilUsuario = perfilUsuarioRepository.findById(id).get();
		perfilUsuarioRepository.delete(perfilUsuario);
	}
	
	public PerfilUsuarioDTO buscarPorId(Long id) {
		return new PerfilUsuarioDTO(perfilUsuarioRepository.findById(id).get());
	}

}

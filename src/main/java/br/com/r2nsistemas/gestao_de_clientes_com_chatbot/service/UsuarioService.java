package br.com.r2nsistemas.gestao_de_clientes_com_chatbot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.r2nsistemas.gestao_de_clientes_com_chatbot.dto.UsuarioDTO;
import br.com.r2nsistemas.gestao_de_clientes_com_chatbot.entity.UsuarioEntity;
import br.com.r2nsistemas.gestao_de_clientes_com_chatbot.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public void inserir(UsuarioDTO usuario) {
		UsuarioEntity usuarioEntity = new UsuarioEntity(usuario);
		usuarioRepository.save(usuarioEntity);
	}

	public List<UsuarioDTO> listarTodos() {
		List<UsuarioEntity> usuarios = usuarioRepository.findAll();
		return usuarios.stream().map(UsuarioDTO::new).toList();
	}

	public UsuarioDTO atualizar(UsuarioDTO usuario) {
		UsuarioEntity usuarioEntity = new UsuarioEntity(usuario);
		return new UsuarioDTO(usuarioRepository.save(usuarioEntity));
	}

	public void deletar(Long id) {
		UsuarioEntity usuario = usuarioRepository.findById(id).get();
		usuarioRepository.delete(usuario);
	}
	
	public UsuarioDTO buscarPorId(Long id) {
		return new UsuarioDTO(usuarioRepository.findById(id).get());
	}

	public List<UsuarioDTO> buscarPorNome(String nome) {
		List<UsuarioEntity> usuarios = usuarioRepository.findByNome(nome);
		return usuarios.stream().map(UsuarioDTO::new).toList();
	}
	
	public List<UsuarioDTO> buscarPorEmail(String email) {
		List<UsuarioEntity> usuarios = usuarioRepository.findByEmail(email);
		return usuarios.stream().map(UsuarioDTO::new).toList();
	}

}

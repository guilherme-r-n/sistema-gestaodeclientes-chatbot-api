package br.com.r2nsistemas.gestao_de_clientes_com_chatbot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.r2nsistemas.gestao_de_clientes_com_chatbot.dto.PermissaoPerfilRecursoDTO;
import br.com.r2nsistemas.gestao_de_clientes_com_chatbot.entity.PermissaoPerfilRecursoEntity;
import br.com.r2nsistemas.gestao_de_clientes_com_chatbot.repository.PermissaoPerfilRecursoRepository;

@Service
public class PermissaoPerfilRecursoService {
	
	@Autowired
	private PermissaoPerfilRecursoRepository permissaoPerfilRecursoRepository;
	
	public void inserir(PermissaoPerfilRecursoDTO permissaoPerfilRecurso) {
		PermissaoPerfilRecursoEntity permissaoPerfilRecursoEntity = new PermissaoPerfilRecursoEntity(permissaoPerfilRecurso);
		permissaoPerfilRecursoRepository.save(permissaoPerfilRecursoEntity);
	}

	public List<PermissaoPerfilRecursoDTO> listarTodos() {
		List<PermissaoPerfilRecursoEntity> permissaoPerfilRecursos = permissaoPerfilRecursoRepository.findAll();
		return permissaoPerfilRecursos.stream().map(PermissaoPerfilRecursoDTO::new).toList();
	}

	public PermissaoPerfilRecursoDTO atualizar(PermissaoPerfilRecursoDTO permissaoPerfilRecurso) {
		PermissaoPerfilRecursoEntity permissaoPerfilRecursoEntity = new PermissaoPerfilRecursoEntity(permissaoPerfilRecurso);
		return new PermissaoPerfilRecursoDTO(permissaoPerfilRecursoRepository.save(permissaoPerfilRecursoEntity));
	}

	public void deletar(Long id) {
		PermissaoPerfilRecursoEntity permissaoPerfilRecurso = permissaoPerfilRecursoRepository.findById(id).get();
		permissaoPerfilRecursoRepository.delete(permissaoPerfilRecurso);
	}
	
	public PermissaoPerfilRecursoDTO buscarPorId(Long id) {
		return new PermissaoPerfilRecursoDTO(permissaoPerfilRecursoRepository.findById(id).get());
	}

}

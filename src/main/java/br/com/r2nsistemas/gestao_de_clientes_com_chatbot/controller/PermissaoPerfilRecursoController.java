package br.com.r2nsistemas.gestao_de_clientes_com_chatbot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.r2nsistemas.gestao_de_clientes_com_chatbot.dto.PermissaoPerfilRecursoDTO;
import br.com.r2nsistemas.gestao_de_clientes_com_chatbot.service.PermissaoPerfilRecursoService;

@RestController
@RequestMapping(value = "/permissao-perfil-recurso")
@CrossOrigin
public class PermissaoPerfilRecursoController {
	
	@Autowired
	private PermissaoPerfilRecursoService permissaoPerfilRecursoService;

	@PostMapping
	public ResponseEntity<Void> inserir(@RequestBody PermissaoPerfilRecursoDTO permissaoPerfilRecurso) {
		permissaoPerfilRecursoService.inserir(permissaoPerfilRecurso);
		return ResponseEntity.ok().build();
	}

	@GetMapping
	public ResponseEntity<List<PermissaoPerfilRecursoDTO>> listarTodos() {
		List<PermissaoPerfilRecursoDTO> permissaoPerfilRecursos = permissaoPerfilRecursoService.listarTodos();
		return ResponseEntity.ok(permissaoPerfilRecursos);
	}

	@PutMapping
	public ResponseEntity<PermissaoPerfilRecursoDTO> atualizar(@RequestBody PermissaoPerfilRecursoDTO permissaoPerfilRecurso) {
		permissaoPerfilRecursoService.atualizar(permissaoPerfilRecurso);
		return ResponseEntity.ok().build();
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletar(@PathVariable("id") Long id) {
		permissaoPerfilRecursoService.deletar(id);
		return ResponseEntity.noContent().build();
	}

	@GetMapping("/id/{id}")
	public ResponseEntity<PermissaoPerfilRecursoDTO> buscarPorId(@PathVariable("id") Long id) {
		PermissaoPerfilRecursoDTO permissaoPerfilRecurso = permissaoPerfilRecursoService.buscarPorId(id);
		return ResponseEntity.ok(permissaoPerfilRecurso);
	}

}

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

import br.com.r2nsistemas.gestao_de_clientes_com_chatbot.dto.PerfilUsuarioDTO;
import br.com.r2nsistemas.gestao_de_clientes_com_chatbot.service.PerfilUsuarioService;

@RestController
@RequestMapping(value = "/perfil-usuario")
@CrossOrigin
public class PerfilUsuarioController {
	
	@Autowired
	private PerfilUsuarioService perfilUsuarioService;

	@PostMapping
	public ResponseEntity<Void> inserir(@RequestBody PerfilUsuarioDTO perfilUsuario) {
		perfilUsuarioService.inserir(perfilUsuario);
		return ResponseEntity.ok().build();
	}

	@GetMapping
	public ResponseEntity<List<PerfilUsuarioDTO>> listarTodos() {
		List<PerfilUsuarioDTO> perfisUsuarios = perfilUsuarioService.listarTodos();
		return ResponseEntity.ok(perfisUsuarios);
	}

	@PutMapping
	public ResponseEntity<PerfilUsuarioDTO> atualizar(@RequestBody PerfilUsuarioDTO perfilUsuario) {
		perfilUsuarioService.atualizar(perfilUsuario);
		return ResponseEntity.ok().build();
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletar(@PathVariable("id") Long id) {
		perfilUsuarioService.deletar(id);
		return ResponseEntity.noContent().build();
	}

	@GetMapping("/id/{id}")
	public ResponseEntity<PerfilUsuarioDTO> buscarPorId(@PathVariable("id") Long id) {
		PerfilUsuarioDTO perfilUsuario = perfilUsuarioService.buscarPorId(id);
		return ResponseEntity.ok(perfilUsuario);
	}

}

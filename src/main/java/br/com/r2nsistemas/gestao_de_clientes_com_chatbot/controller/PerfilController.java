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

import br.com.r2nsistemas.gestao_de_clientes_com_chatbot.dto.PerfilDTO;
import br.com.r2nsistemas.gestao_de_clientes_com_chatbot.service.PerfilService;

@RestController
@RequestMapping(value = "/perfil")
@CrossOrigin
public class PerfilController {
	
	@Autowired
	private PerfilService perfilService;

	@PostMapping
	public ResponseEntity<Void> inserir(@RequestBody PerfilDTO perfil) {
		perfilService.inserir(perfil);
		return ResponseEntity.ok().build();
	}

	@GetMapping
	public ResponseEntity<List<PerfilDTO>> listarTodos() {
		List<PerfilDTO> perfis = perfilService.listarTodos();
		return ResponseEntity.ok(perfis);
	}

	@PutMapping
	public ResponseEntity<PerfilDTO> atualizar(@RequestBody PerfilDTO perfil) {
		perfilService.atualizar(perfil);
		return ResponseEntity.ok().build();
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletar(@PathVariable("id") Long id) {
		perfilService.deletar(id);
		return ResponseEntity.noContent().build();
	}

	@GetMapping("/id/{id}")
	public ResponseEntity<PerfilDTO> buscarPorId(@PathVariable("id") Long id) {
		PerfilDTO perfil = perfilService.buscarPorId(id);
		return ResponseEntity.ok(perfil);
	}

}

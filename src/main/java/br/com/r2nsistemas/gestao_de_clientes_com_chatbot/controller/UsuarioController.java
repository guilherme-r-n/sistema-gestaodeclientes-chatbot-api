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

import br.com.r2nsistemas.gestao_de_clientes_com_chatbot.dto.UsuarioDTO;
import br.com.r2nsistemas.gestao_de_clientes_com_chatbot.service.UsuarioService;

@RestController
@RequestMapping(value = "/usuario")
@CrossOrigin
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;

	@PostMapping
	public ResponseEntity<Void> inserir(@RequestBody UsuarioDTO usuario) {
		usuarioService.inserir(usuario);
		return ResponseEntity.ok().build();
	}

	@GetMapping
	public ResponseEntity<List<UsuarioDTO>> listarTodos() {
		List<UsuarioDTO> usuarios = usuarioService.listarTodos();
		return ResponseEntity.ok(usuarios);
	}

	@PutMapping("/{id}")
	public ResponseEntity<UsuarioDTO> atualizar(@PathVariable("id") Long id, @RequestBody UsuarioDTO usuario) {
		usuario.setId(id);
		usuarioService.atualizar(usuario);
		return ResponseEntity.ok().build();
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletar(@PathVariable("id") Long id) {
		usuarioService.deletar(id);
		return ResponseEntity.noContent().build();
	}

	@GetMapping("/id/{id}")
	public ResponseEntity<UsuarioDTO> buscarPorId(@PathVariable("id") Long id) {
		UsuarioDTO usuario = usuarioService.buscarPorId(id);
		return ResponseEntity.ok(usuario);
	}

	@GetMapping("/nome/{nome}")
	public ResponseEntity<List<UsuarioDTO>> buscarPorNome(@PathVariable("nome") String nome) {
		List<UsuarioDTO> usuarios = usuarioService.buscarPorNome(nome);
		return ResponseEntity.ok(usuarios);
	}
	
	@GetMapping("/email/{email}")
	public ResponseEntity<List<UsuarioDTO>> buscarPorEmail(@PathVariable("email") String email) {
		List<UsuarioDTO> usuarios = usuarioService.buscarPorEmail(email);
		return ResponseEntity.ok(usuarios);
	}

}

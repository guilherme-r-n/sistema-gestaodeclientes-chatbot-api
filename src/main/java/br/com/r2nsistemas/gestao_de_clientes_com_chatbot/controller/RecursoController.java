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

import br.com.r2nsistemas.gestao_de_clientes_com_chatbot.dto.RecursoDTO;
import br.com.r2nsistemas.gestao_de_clientes_com_chatbot.service.RecursoService;

@RestController
@RequestMapping(value = "/recurso")
@CrossOrigin
public class RecursoController {
	
	@Autowired
	private RecursoService recursoService;

	@PostMapping
	public ResponseEntity<Void> inserir(@RequestBody RecursoDTO recurso) {
		recursoService.inserir(recurso);
		return ResponseEntity.ok().build();
	}

	@GetMapping
	public ResponseEntity<List<RecursoDTO>> listarTodos() {
		List<RecursoDTO> recursos = recursoService.listarTodos();
		return ResponseEntity.ok(recursos);
	}

	@PutMapping
	public ResponseEntity<RecursoDTO> atualizar(@RequestBody RecursoDTO recurso) {
		recursoService.atualizar(recurso);
		return ResponseEntity.ok().build();
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletar(@PathVariable("id") Long id) {
		recursoService.deletar(id);
		return ResponseEntity.noContent().build();
	}

	@GetMapping("/id/{id}")
	public ResponseEntity<RecursoDTO> buscarPorId(@PathVariable("id") Long id) {
		RecursoDTO recurso = recursoService.buscarPorId(id);
		return ResponseEntity.ok(recurso);
	}

}

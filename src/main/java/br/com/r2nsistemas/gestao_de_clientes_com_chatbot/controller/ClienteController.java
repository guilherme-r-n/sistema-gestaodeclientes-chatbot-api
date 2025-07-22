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

import br.com.r2nsistemas.gestao_de_clientes_com_chatbot.dto.ClienteDTO;
import br.com.r2nsistemas.gestao_de_clientes_com_chatbot.service.ClienteService;

@RestController
@RequestMapping(value = "/cliente")
@CrossOrigin
public class ClienteController {

	@Autowired
	private ClienteService clienteService;

	@PostMapping
	public ResponseEntity<Void> inserir(@RequestBody ClienteDTO cliente) {
		clienteService.inserir(cliente);
		return ResponseEntity.ok().build();
	}

	@GetMapping
	public ResponseEntity<List<ClienteDTO>> listarTodos() {
		List<ClienteDTO> clientes = clienteService.listarTodos();
		return ResponseEntity.ok(clientes);
	}

	@PutMapping("/{id}")
	public ResponseEntity<ClienteDTO> atualizar(@PathVariable("id") Long id, @RequestBody ClienteDTO cliente) {
		cliente.setId(id);
		clienteService.atualizar(cliente);
		return ResponseEntity.ok().build();
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletar(@PathVariable("id") Long id) {
		clienteService.deletar(id);
		return ResponseEntity.noContent().build();
	}

	@GetMapping("/id/{id}")
	public ResponseEntity<ClienteDTO> buscarPorId(@PathVariable("id") Long id) {
		ClienteDTO cliente = clienteService.buscarPorId(id);
		return ResponseEntity.ok(cliente);
	}

	@GetMapping("/nome/{nome}")
	public ResponseEntity<List<ClienteDTO>> buscarPorNome(@PathVariable("nome") String nome) {
		List<ClienteDTO> clientes = clienteService.buscarPorNome(nome);
		return ResponseEntity.ok(clientes);
	}

	@GetMapping("/cpf/{cpf}")
	public ResponseEntity<ClienteDTO> buscarPorCpf(@PathVariable("cpf") String cpf) {
		ClienteDTO cliente = clienteService.buscarPorCpf(cpf);
		return ResponseEntity.ok(cliente);
	}

	@GetMapping("/email/{email}")
	public ResponseEntity<List<ClienteDTO>> buscarPorEmail(@PathVariable("email") String email) {
		List<ClienteDTO> clientes = clienteService.buscarPorEmail(email);
		return ResponseEntity.ok(clientes);
	}

	@GetMapping("/telefone/{telefone}")
	public ResponseEntity<List<ClienteDTO>> buscarPorTelefone(@PathVariable("telefone") String telefone) {
		List<ClienteDTO> clientes = clienteService.buscarPorTelefone(telefone);
		return ResponseEntity.ok(clientes);
	}

	@GetMapping("/endereco/{endereco}")
	public ResponseEntity<List<ClienteDTO>> buscarPorEndereco(@PathVariable("endereco") String endereco) {
		List<ClienteDTO> clientes = clienteService.buscarPorEndereco(endereco);
		return ResponseEntity.ok(clientes);
	}

	@GetMapping("/complemento/{complemento}")
	public ResponseEntity<List<ClienteDTO>> buscarPorComplemento(@PathVariable("complemento") String complemento) {
		List<ClienteDTO> clientes = clienteService.buscarPorComplemento(complemento);
		return ResponseEntity.ok(clientes);
	}

	@GetMapping("/bairro/{bairro}")
	public ResponseEntity<List<ClienteDTO>> buscarPorBairro(@PathVariable("bairro") String bairro) {
		List<ClienteDTO> clientes = clienteService.buscarPorBairro(bairro);
		return ResponseEntity.ok(clientes);
	}

	@GetMapping("/cidade/{cidade}")
	public ResponseEntity<List<ClienteDTO>> buscarPorCidade(@PathVariable("cidade") String cidade) {
		List<ClienteDTO> clientes = clienteService.buscarPorCidade(cidade);
		return ResponseEntity.ok(clientes);
	}

	@GetMapping("/estado/{estado}")
	public ResponseEntity<List<ClienteDTO>> buscarPorEstado(@PathVariable("estado") String estado) {
		List<ClienteDTO> clientes = clienteService.buscarPorEstado(estado);
		return ResponseEntity.ok(clientes);
	}

}
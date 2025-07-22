package br.com.r2nsistemas.gestao_de_clientes_com_chatbot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.r2nsistemas.gestao_de_clientes_com_chatbot.dto.ClienteDTO;
import br.com.r2nsistemas.gestao_de_clientes_com_chatbot.entity.ClienteEntity;
import br.com.r2nsistemas.gestao_de_clientes_com_chatbot.repository.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;

	public void inserir(ClienteDTO cliente) {
		ClienteEntity clienteEntity = new ClienteEntity(cliente);
		clienteRepository.save(clienteEntity);
	}

	public List<ClienteDTO> listarTodos() {
		List<ClienteEntity> clientes = clienteRepository.findAll();
		return clientes.stream().map(ClienteDTO::new).toList();
	}

	public ClienteDTO atualizar(ClienteDTO cliente) {
		ClienteEntity clienteEntity = new ClienteEntity(cliente);
		return new ClienteDTO(clienteRepository.save(clienteEntity));
	}

	public void deletar(Long id) {
		ClienteEntity cliente = clienteRepository.findById(id).get();
		clienteRepository.delete(cliente);
	}
	
	public ClienteDTO buscarPorId(Long id) {
		return new ClienteDTO(clienteRepository.findById(id).get());
	}

	public List<ClienteDTO> buscarPorNome(String nome) {
		List<ClienteEntity> clientes = clienteRepository.findByNome(nome);
		return clientes.stream().map(ClienteDTO::new).toList();
	}
	
	public ClienteDTO buscarPorCpf(String cpf) {
		return new ClienteDTO(clienteRepository.findByCpf(cpf).get());
	}
	
	public List<ClienteDTO> buscarPorEmail(String email) {
		List<ClienteEntity> clientes = clienteRepository.findByEmail(email);
		return clientes.stream().map(ClienteDTO::new).toList();
	}
	
	public List<ClienteDTO> buscarPorTelefone(String telefone) {
		List<ClienteEntity> clientes = clienteRepository.findByTelefone(telefone);
		return clientes.stream().map(ClienteDTO::new).toList();
	}
	
	public List<ClienteDTO> buscarPorEndereco(String endereco) {
		List<ClienteEntity> clientes = clienteRepository.findByEndereco(endereco);
		return clientes.stream().map(ClienteDTO::new).toList();
	}
	
	public List<ClienteDTO> buscarPorComplemento(String complemento) {
		List<ClienteEntity> clientes = clienteRepository.findByComplemento(complemento);
		return clientes.stream().map(ClienteDTO::new).toList();
	}
	
	public List<ClienteDTO> buscarPorBairro(String bairro) {
		List<ClienteEntity> clientes = clienteRepository.findByBairro(bairro);
		return clientes.stream().map(ClienteDTO::new).toList();
	}
	
	public List<ClienteDTO> buscarPorCidade(String cidade) {
		List<ClienteEntity> clientes = clienteRepository.findByCidade(cidade);
		return clientes.stream().map(ClienteDTO::new).toList();
	}
	
	public List<ClienteDTO> buscarPorEstado(String estado) {
		List<ClienteEntity> clientes = clienteRepository.findByEstado(estado);
		return clientes.stream().map(ClienteDTO::new).toList();
	}

}
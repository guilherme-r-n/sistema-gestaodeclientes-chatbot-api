package br.com.r2nsistemas.gestao_de_clientes_com_chatbot.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.r2nsistemas.gestao_de_clientes_com_chatbot.entity.ClienteEntity;

import java.util.List;

public interface ClienteRepository extends JpaRepository<ClienteEntity, Long> {

	@Query(value = "SELECT * FROM cad_clientes c WHERE LOWER(unaccent(c.nome)) LIKE LOWER(unaccent(CONCAT('%', :nome, '%')))", nativeQuery = true)
	List<ClienteEntity> findByNome(@Param("nome") String nome);
	
	Optional<ClienteEntity> findByCpf (String cpf);
	
	@Query(value = "SELECT * FROM cad_clientes c WHERE LOWER(unaccent(c.email)) LIKE LOWER(unaccent(CONCAT('%', :email, '%')))", nativeQuery = true)
	List<ClienteEntity> findByEmail(@Param("email") String email);
	
	@Query(value = "SELECT * FROM cad_clientes c WHERE LOWER(unaccent(c.telefone)) LIKE LOWER(unaccent(CONCAT('%', :telefone, '%')))", nativeQuery = true)
	List<ClienteEntity> findByTelefone(String telefone);
	
	@Query(value = "SELECT * FROM cad_clientes c WHERE LOWER(unaccent(c.endereco)) LIKE LOWER(unaccent(CONCAT('%', :endereco, '%')))", nativeQuery = true)
	List<ClienteEntity> findByEndereco(String endereco);
	
	@Query(value = "SELECT * FROM cad_clientes c WHERE LOWER(unaccent(c.complemento)) LIKE LOWER(unaccent(CONCAT('%', :complemento, '%')))", nativeQuery = true)
	List<ClienteEntity> findByComplemento(String complemento);
	
	@Query(value = "SELECT * FROM cad_clientes c WHERE LOWER(unaccent(c.bairro)) LIKE LOWER(unaccent(CONCAT('%', :bairro, '%')))", nativeQuery = true)
	List<ClienteEntity> findByBairro(String bairro);
	
	@Query(value = "SELECT * FROM cad_clientes c WHERE LOWER(unaccent(c.cidade)) LIKE LOWER(unaccent(CONCAT('%', :cidade, '%')))", nativeQuery = true)
	List<ClienteEntity> findByCidade(String cidade);
	
	@Query(value = "SELECT * FROM cad_clientes c WHERE LOWER(unaccent(c.estado)) LIKE LOWER(unaccent(CONCAT('%', :estado, '%')))", nativeQuery = true)
	List<ClienteEntity> findByEstado(String estado);

}
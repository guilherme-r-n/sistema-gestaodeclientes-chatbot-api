package br.com.r2nsistemas.gestao_de_clientes_com_chatbot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.r2nsistemas.gestao_de_clientes_com_chatbot.entity.UsuarioEntity;

public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Long> {
	
	@Query(value = "SELECT * FROM cad_clientes c WHERE LOWER(unaccent(c.nome)) LIKE LOWER(unaccent(CONCAT('%', :nome, '%')))", nativeQuery = true)
	List<UsuarioEntity> findByNome(@Param("nome") String nome);
	
	@Query(value = "SELECT * FROM cad_clientes c WHERE LOWER(unaccent(c.email)) LIKE LOWER(unaccent(CONCAT('%', :email, '%')))", nativeQuery = true)
	List<UsuarioEntity> findByEmail(@Param("email") String email);

}

package br.com.r2nsistemas.gestao_de_clientes_com_chatbot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.r2nsistemas.gestao_de_clientes_com_chatbot.entity.PerfilEntity;

public interface PerfilRepository extends JpaRepository<PerfilEntity, Long> {

}

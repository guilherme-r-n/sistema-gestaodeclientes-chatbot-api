package br.com.r2nsistemas.gestao_de_clientes_com_chatbot.security.jwt;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class JwtUtils {
	
	@Value("${gestao-de-clientes-com-chatbot.jwtSecret}")
	private String jwtSecret;
	
	@Value("${gestao-de-clientes-com-chatbot.jwtExpiration}")
	private int jwtExpirationMs;
	
	public String generateTokenFromUserDatailsImpl (UserDetailsImpl userData) {
		
	}

}

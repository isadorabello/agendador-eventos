package io.github.isadorabello.agendadoreventos.infrastructure.security;

import io.github.isadorabello.agendadoreventos.business.dto.UsuarioDTO;
import io.github.isadorabello.agendadoreventos.infrastructure.security.client.UsuarioClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl{

    // Repositório para acessar dados de usuário no banco de dados

    @Autowired
    private UsuarioClient client;

    // Implementação do metodo para carregar detalhes do usuário pelo e-mail
    public UserDetails loadUserByUsernameAndToken(String email, String token){
        // Busca o usuário no banco de dados pelo e-mail
        UsuarioDTO dto = client.buscaUsuarioPorEmail(email, token);

        // Cria e retorna um objeto UserDetails com base no usuário encontrado
        return User
                .withUsername(dto.email()) // Define o nome de usuário como o e-mail
                .password(dto.senha()) // Define a senha do usuário
                .build(); // Constrói o objeto UserDetails
    }
}
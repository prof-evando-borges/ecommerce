package br.com.fiap.ecommerce.security;

import br.com.fiap.ecommerce.repositories.ClienteRepository;
import br.com.fiap.ecommerce.repositories.LojistaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final ClienteRepository clienteRepository;
    private final LojistaRepository lojistaRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        // Busca primeiro em Cliente
        var clienteOpt = clienteRepository.findByEmail(email);
        if (clienteOpt.isPresent()) {
            var cliente = clienteOpt.get();
            return new User(
                    cliente.getEmail(),
                    cliente.getSenha(),
                    List.of(new SimpleGrantedAuthority("ROLE_CLIENTE"))
            );
        }

        // Depois em Lojista
        var lojistaOpt = lojistaRepository.findByEmail(email);
        if (lojistaOpt.isPresent()) {
            var lojista = lojistaOpt.get();
            return new User(
                    lojista.getEmail(),
                    lojista.getSenha(),
                    List.of(new SimpleGrantedAuthority("ROLE_LOJISTA"))
            );
        }

        throw new UsernameNotFoundException("Usuário não encontrado com o e-mail: " + email);
    }
}

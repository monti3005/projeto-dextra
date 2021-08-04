package br.com.projeto_dextra.projeto_dextra.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.projeto_dextra.projeto_dextra.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{


}

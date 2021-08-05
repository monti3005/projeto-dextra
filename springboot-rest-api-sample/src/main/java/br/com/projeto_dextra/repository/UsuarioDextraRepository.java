package br.com.projeto_dextra.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.projeto_dextra.model.Usuario;

@Repository
public interface UsuarioDextraRepository extends JpaRepository<Usuario, Long>{


}
package br.com.fiap.TwelveTools.repository;

import br.com.fiap.TwelveTools.model.Ferramenta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FerramentasRepository extends JpaRepository<Ferramenta, Long> {
}

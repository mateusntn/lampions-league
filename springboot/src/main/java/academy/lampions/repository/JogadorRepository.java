package academy.lampions.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import academy.lampions.entity.Jogador;

@Repository
public interface JogadorRepository extends JpaRepository<Jogador, Integer> {}
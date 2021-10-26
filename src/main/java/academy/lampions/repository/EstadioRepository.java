package academy.lampions.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import academy.lampions.entity.Estadio;

@Repository
public interface EstadioRepository extends JpaRepository<Estadio, Integer> {}
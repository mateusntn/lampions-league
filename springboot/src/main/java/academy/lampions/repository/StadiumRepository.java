package academy.lampions.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import academy.lampions.entity.Stadium;

@Repository
public interface StadiumRepository extends JpaRepository<Stadium, Integer> {}
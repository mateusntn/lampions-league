package academy.lampions.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import academy.lampions.entity.Time;

@Repository
public interface TimeRepository extends JpaRepository<Time, Integer> {}
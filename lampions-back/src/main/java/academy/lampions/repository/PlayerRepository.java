package academy.lampions.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import academy.lampions.entity.Player;
import academy.lampions.entity.Team;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Integer> {

  List<Player> findByTeam(Team team);
}
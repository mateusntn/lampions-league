package academy.lampions.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import academy.lampions.entity.Team;
import academy.lampions.repository.TeamRepository;

@Service
public class TeamService {
    @Autowired
    private TeamRepository repository;

    public List<Team> findAll() {
        return repository.findAll();
    }

    public Team findById(Integer id) {
        Optional<Team> team = repository.findById(id);
        return team.orElse(null);
    }

    public Team create(Team team) {
        team.setId(null);
        return repository.save(team);
    }

    public Team update(Integer id, Team newTeam) {
        Team team = findById(id);

        team.setName(newTeam.getName() != null ? newTeam.getName() : team.getName());
        team.setFoundationDate(newTeam.getFoundationDate() != null ? newTeam.getFoundationDate() : team.getFoundationDate());
        team.setTitles(newTeam.getTitles() != null ? newTeam.getTitles() : team.getTitles());
        team.setEmblem(newTeam.getEmblem() != null ? newTeam.getEmblem() : team.getEmblem());
        team.setPoints(newTeam.getPoints() != null ? newTeam.getPoints() : team.getPoints());
        team.setVictories(newTeam.getVictories() != null ? newTeam.getVictories() : team.getVictories());
        team.setDraws(newTeam.getDraws() != null ? newTeam.getDraws() : team.getDraws());
        team.setDefeats(newTeam.getDefeats() != null ? newTeam.getDefeats() : team.getDefeats());

        return repository.save(team);
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }
}

package io.pratik.footballdashboard.repository;

import io.pratik.footballdashboard.model.Match;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;


import java.util.List;

public interface MatchRepository extends CrudRepository<Match, Long> {
    List<Match> getByHomeTeamOrAwayTeamOrderByDateDesc(String teamName1, String teamName2, Pageable pageable);

    default List<Match> findLatestMatchesByTeam(String teamName, int count) {
        return getByHomeTeamOrAwayTeamOrderByDateDesc(teamName, teamName, PageRequest.of(0, count));
    }
}

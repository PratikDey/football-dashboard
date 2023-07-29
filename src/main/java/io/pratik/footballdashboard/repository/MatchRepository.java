package io.pratik.footballdashboard.repository;

import io.pratik.footballdashboard.model.Match;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface MatchRepository extends CrudRepository<Match, Long> {
    List<Match> getByHomeTeamOrAwayTeamOrderByDateDesc(String teamName1, String teamName2, Pageable pageable);

    @Query("select m from Match m where (m.homeTeam = :teamName or m.awayTeam = :teamName) and m.date between :dateStart and :dateEnd order by date desc")
    List<Match> getMatchesByTeamInBetweenDates(@Param("teamName") String teamName, @Param("dateStart") LocalDate dateStart, @Param("dateEnd") LocalDate dateEnd);

    // List<Match> getByHomeTeamAndDateBetweenOrAwayTeamAndDateBetweenOrderByDateDesc(String teamName1, LocalDate date1, LocalDate date2, String teamName2, LocalDate date3, LocalDate date4);
    
    default List<Match> findLatestMatchesByTeam(String teamName, int count) {
        return getByHomeTeamOrAwayTeamOrderByDateDesc(teamName, teamName, PageRequest.of(0, count));
    }
}

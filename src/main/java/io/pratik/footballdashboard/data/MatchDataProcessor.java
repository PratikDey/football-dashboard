package io.pratik.footballdashboard.data;

import java.time.LocalDate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.batch.item.ItemProcessor;

import io.pratik.footballdashboard.model.Match;

public class MatchDataProcessor implements ItemProcessor<MatchInput, Match> {

  private static final Logger log = LoggerFactory.getLogger(PersonItemProcessor.class);

  @Override
  public Match process(final MatchInput matchInput) throws Exception {
    
    Match match = new Match();

    match.setDate(LocalDate.parse(matchInput.getDate()));
    match.setHomeTeam(matchInput.getHome_team());
    match.setAwayTeam(matchInput.getAway_team());
    match.setHomeScore(matchInput.getHome_score());
    match.setAwayScore(matchInput.getAway_score());
    match.setTournament(matchInput.getTournament());
    match.setCity(matchInput.getCity());
    match.setCountry(matchInput.getCountry());
    match.setNeutral(matchInput.getNeutral());

    return match;
  }

}

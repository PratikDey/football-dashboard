//This file defines how we save to our hsql database

package io.pratik.footballdashboard.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Match {
    
    private LocalDate date;
    private String homeTeam;
    private String awayTeam;
    private String homeScore;
    private String awayScore;
    private String tournament;
    private String city;
    private String country;
    private String neutral;
    @Id
    private long id;

    private String matchWinner;

    public String getMatchWinner() {
        return matchWinner;
    }

    public void setMatchWinner(String matchWinner) {
        this.matchWinner = matchWinner;
    }

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public LocalDate getDate() {
        return date;
    }
    public void setDate(LocalDate date) {
        this.date = date;
    }
    public String getHomeTeam() {
        return homeTeam;
    }
    public void setHomeTeam(String homeTeam) {
        this.homeTeam = homeTeam;
    }
    public String getAwayTeam() {
        return awayTeam;
    }
    public void setAwayTeam(String awayTeam) {
        this.awayTeam = awayTeam;
    }
    public String getHomeScore() {
        return homeScore;
    }
    public void setHomeScore(String homeScore) {
        this.homeScore = homeScore;
    }
    public String getAwayScore() {
        return awayScore;
    }
    public void setAwayScore(String awayScore) {
        this.awayScore = awayScore;
    }
    public String getTournament() {
        return tournament;
    }
    public void setTournament(String tournament) {
        this.tournament = tournament;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    }
    public String getNeutral() {
        return neutral;
    }
    public void setNeutral(String neutral) {
        this.neutral = neutral;
    }

    
}

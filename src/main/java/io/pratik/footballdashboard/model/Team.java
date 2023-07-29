package io.pratik.footballdashboard.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String teamName;
    private long totalMatches;

//    private long totalWins;

    @Transient
    private List<Match> matchesList;

    public List<Match> getMatchesList() {
        return matchesList;
    }

    public void setMatchesList(List<Match> matchesList) {
        this.matchesList = matchesList;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public long getTotalMatches() {
        return totalMatches;
    }

    public void setTotalMatches(long totalMatches) {
        this.totalMatches = totalMatches;
    }

//    public long getTotalWins() {
//        return totalWins;
//    }
//
//    public void setTotalWins(long totalWins) {
//        this.totalWins = totalWins;
//    }

    public long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Team{" +
                "teamName='" + teamName + '\'' +
                ", totalMatches=" + totalMatches +
                '}';
    }

    public Team(String teamName, long totalMatches) {
        this.teamName = teamName;
        this.totalMatches = totalMatches;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Team() {

    }
}

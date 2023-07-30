import {React, useEffect, useState} from "react";
import "./TeamPage.scss";
import { useParams, Link } from "react-router-dom";
import { MatchSmallCard } from "../components/MatchSmallCard";
import { MatchDetailCard } from "../components/MatchDetailCard";
import { PieChart } from 'react-minimal-pie-chart';

export const TeamPage = () => {
  const [team, setTeam] = useState({matchesList: []});
  const {teamName} = useParams();
  let totalWins = 0;
  let totalLoss = 0;
  let totalDraws = 0;
  useEffect(
    () => {
      const fetchTeams = async () => {
        const response = await fetch(`${process.env.REACT_APP_API_ROOT_URL}/team/${teamName}`);
        const data = await response.json();
        setTeam(data)
      };
      fetchTeams();
    },
    [teamName]
  );

  if(!team || !team.teamName) {
    return <h1>Team not found</h1>
  }

  team.matchesList.forEach(eachMatch => {
    if(eachMatch.homeScore > eachMatch.awayScore) {
      totalWins += 1;
    } else if(eachMatch.homeScore < eachMatch.awayScore) {
      totalLoss += 1;
    } else {
      totalDraws += 1;
    }
  })

  

  return (
    <div className="TeamPage">
        <div className="team-name-section">
          <h1 className="team-name">{team.teamName}</h1>
        </div>
        <div className="win-loss-section">
          Wins / Losses
            <PieChart
              data={[
                { title: 'Losses', value: totalLoss, color: '#a34d5d' },
                { title: 'Wins', value: totalWins, color: '#4da375' },
                { title: 'Draws', value: totalDraws, color: '#000000'}
              ]}
            />
        </div>
        <div className="match-detail-section">
          <h3>Latest Matches</h3>
          <MatchDetailCard teamName ={team.teamName} match={team.matchesList[0]}/>
        </div>
        {team.matchesList && team.matchesList.slice(1).map(match => (<MatchSmallCard key={match.id} match = {match} teamName ={team.teamName}></MatchSmallCard>))}
        <div className="more-link">
          <Link to={`/teams/${teamName}/matches/${process.env.REACT_APP_DATA_END_YEAR}`}>More</Link>
        </div>
    </div>
  );
}

import {React} from "react";
import { Link } from "react-router-dom";

export const MatchSmallCard = ({match, teamName}) => {
  if(!match) return null;
  const otherTeam = match.awayTeam === teamName ? match.homeTeam : match.awayTeam
  const otherTeamRoute = `/teams/${otherTeam}`
  return (
    <div className="MatchSmallCard">
        <h3><Link to={otherTeamRoute}>vs {otherTeam}</Link></h3>
        <p>on {match.date}</p>
        <p>at {match.city}, {match.country}</p>
    </div>
  );
}
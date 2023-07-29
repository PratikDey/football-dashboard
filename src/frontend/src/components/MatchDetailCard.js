import {React} from "react";
import { Link } from "react-router-dom";

export const MatchDetailCard = ({match, teamName}) => {
    if(!match) return null;

    const otherTeam = match.awayTeam === teamName ? match.homeTeam : match.awayTeam
    const otherTeamRoute = `/teams/${otherTeam}`
    return (
        <div className="MatchDetailCard">
            <h4>Latest Matches</h4>
            <h4>Match Details</h4>
            <h1><Link to={otherTeamRoute}>vs {otherTeam}</Link></h1>
            <h4>on {match.date}</h4>
            <h3>at {match.city}, {match.country}</h3>
            <h4>{match.tournament}</h4>
        </div>
    );
}
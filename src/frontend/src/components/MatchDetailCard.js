import {React} from "react";
import { Link } from "react-router-dom";
import "./MatchDetailCard.scss";

export const MatchDetailCard = ({match, teamName}) => {
    if(!match) return null;

    const otherTeam = match.awayTeam === teamName ? match.homeTeam : match.awayTeam
    const otherTeamRoute = `/teams/${otherTeam}`
    let isMatchwWon = null;
    let classNames = [];
    if(match.homeScore > match.awayScore) {
        isMatchwWon = true;
    } else if(match.homeScore < match.awayScore) {
        isMatchwWon = false;
    } else {
        isMatchwWon = null;
    }

    if(isMatchwWon === true) {
        classNames.push("won-card")
    }
    if(isMatchwWon === false) {
        classNames.push("lost-card")
    }
    if(isMatchwWon === null) {
        classNames.push("draw-card")
    }
    return (
        //isMatchwWon ? 'MatchDetailCard won-card' : 'MatchDetailCard lost-card'
        <div className={"MatchDetailCard " + classNames} >
            <div>
                <span className="vs">
                    vs
                </span> 
                <h1>
                    <Link to={otherTeamRoute}>
                        {otherTeam}
                    </Link>
                </h1>
                <h3 className="match-result">{match.homeScore} - {match.awayScore} {otherTeam}</h3>
            </div>
            <div className="additional-detail">
                <h4>{match.tournament}</h4>
                <h4>{match.date}</h4>
                <h4>at {match.city}, {match.country}</h4>
            </div>
        </div>
    );
}
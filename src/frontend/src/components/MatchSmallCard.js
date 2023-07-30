import {React} from "react";
import { Link } from "react-router-dom";
import "./MatchSmallCard.scss"
export const MatchSmallCard = ({match, teamName}) => {
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
    <div className={"MatchDetailCard " + classNames} >
        <h3><Link to={otherTeamRoute}>vs {otherTeam}</Link></h3>
        <p>on {match.date}</p>
        <p>{match.homeScore} - {match.awayScore}</p>
        <p>at {match.city}, {match.country}</p>
    </div>
  );
}
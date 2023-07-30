import "./App.scss"
import { HomePage } from "./pages/HomePage";
import { MatchPage } from "./pages/MatchPage";
import { TeamPage } from "./pages/TeamPage";
import {
  HashRouter as Router,
  Routes,
  Route,
} from "react-router-dom";

function App() {
  return (
    <div className="App">
      <Router>
        <Routes>
            <Route path="/teams/:teamName/matches/:year" element={<MatchPage />} />
            <Route path="/teams/:teamName" element={<TeamPage />} />
            <Route path="/" element={<HomePage />} />
        </Routes>
      </Router>
    </div>
  );
}

export default App;

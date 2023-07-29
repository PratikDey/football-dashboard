import { MatchPage } from "./pages/MatchPage";
import { TeamPage } from "./pages/TeamPage";
import {
  BrowserRouter,
  Routes,
  Route,
  Link,
  Switch
} from "react-router-dom";

function App() {
  return (
    <div className="App">
      <BrowserRouter>
        <Routes>
          
            <Route path="/teams/:teamName/matches/:year" element={<MatchPage />} />
            <Route path="/teams/:teamName" element={<TeamPage />} />
          
        </Routes>
      </BrowserRouter>
    </div>
  );
}

export default App;

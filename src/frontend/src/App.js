import { TeamPage } from "./pages/TeamPage";
import {
  BrowserRouter,
  Routes,
  Route,
  Link,
} from "react-router-dom";

function App() {
  return (
    <div className="App">
      <BrowserRouter>
        <Routes>
          <Route path="/teams/:teamName" element={<TeamPage />} />
        </Routes>
      </BrowserRouter>
    </div>
  );
}

export default App;

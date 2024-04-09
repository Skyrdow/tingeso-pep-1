import Home from './pages/Home'
import Cars from './pages/Cars'
import Reparations from './pages/Reparations'
import Reports from './pages/Reports'

import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';

function App() {

  
  return (
    <Router>
      <Routes>
        <Route path="/" element={<Home/>} />
        <Route path="/cars" element={<Cars/>} />
        <Route path="/Reparations" element={<Reparations/>} />
        <Route path="/Reports" element={<Reports/>} />
      </Routes>
    </Router>
  );
}


export default App;

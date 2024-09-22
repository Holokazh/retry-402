import { Routes, Route, Outlet } from "react-router-dom";
import Home from './pages/Home';
import './App.css'
import NotFound from "./pages/NotFound";
import EditLevel from "./pages/EditLevel";

function App() {
  return (
    <>
      <Routes>
        <Route path="/" element={<Layout />}>
          <Route index element={<Home />} />
          <Route path="/edit/level/:id" element={<EditLevel />} />
          
          <Route path="*" element={<NotFound />} />
        </Route>
      </Routes>
    </>
  )
}

function Layout() {
  return (
    <div>
      {/* Here you could add a navigation bar or other layout elements */}
      <Outlet /> {/* This will render the child route's element */}
    </div>
  );
}

export default App

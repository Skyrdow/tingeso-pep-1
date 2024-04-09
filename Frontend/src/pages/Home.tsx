import { Link } from "react-router-dom";

const Home = () => {
    return (
        <div className="flex w-full flex-col gap-10 items-center">
            <Link to="/Cars">Autos</Link>
            <Link to="/Reparations">Reparaciones</Link>
            <Link to="/Reports">Reportes</Link>
        </div>
    );
}

export default Home;

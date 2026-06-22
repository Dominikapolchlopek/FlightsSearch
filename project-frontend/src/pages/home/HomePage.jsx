import { useState } from "react"; // Dodano brakujący import
import axios from "axios";         // Dodano brakujący import
import { Header } from "../../components/Header";
import './HomePage.css';

export function HomePage({ isLoginOpen, setIsLoginOpen, userId, setUserId }) {
    const [from, setFrom] = useState('');
    const [fNumber, setFnumber] = useState('');
    const [to, setTo] = useState('');
    const [departure, setDeparture] = useState('');

    const [flights, setFlights] = useState([]);

    const handleSearch = async () => {

        if (from !== '' && to !== '') {
            try {
                const response = await axios.post('http://localhost:8080/api/v1/flights/arrivalanddeparture', {
                    "FromAirportCode": from,
                    "ToAirportCode": to

                });
                console.log("Udało się znaleźć loty", response.data);
                setFlights(response.data);

            } catch (error) {
                console.error("Błąd znajdowania lotów:", error);
            }
        }else if (from !== '') {
            try {
                const response = await axios.post('http://localhost:8080/api/v1/flights/departureairport', {
                    "FromAirportCode": from
                });
                console.log("Udało się znaleźć loty", response.data);
                setFlights(response.data);

            } catch (error) {
                console.error("Błąd znajdowania lotów:", error);
            }
        } else if (to !== '') {
            try {
                const response = await axios.post('http://localhost:8080/api/v1/flights/arrivalairport', {
                    "ToAirportCode": to
                });
                console.log("Udało się znaleźć loty", response.data);
                setFlights(response.data);

            } catch (error) {
                console.error("Błąd znajdowania lotów:", error);
            }
        } else if (departure !== '') {
            try {
                const response = await axios.post('http://localhost:8080/api/v1/flights/departuretime', {
                    "DepartureTime": departure

                });
                console.log("Udało się znaleźć loty", response.data);
                setFlights(response.data);

            } catch (error) {
                console.error("Błąd znajdowania lotów:", error);
            }
        } else if (fNumber !== '') {
            try {
                const response = await axios.post('http://localhost:8080/api/v1/flights/flightnumber', {
                    "FlightNumber": fNumber

                });
                console.log("Udało się znaleźć loty", response.data);
                setFlights(response.data);

            } catch (error) {
                console.error("Błąd znajdowania lotów:", error);
            }
        }

    }

    return (
        <>
            <title>Wyszukiwarka Lotów</title>

            <Header isLoginOpen={isLoginOpen}
                setIsLoginOpen={setIsLoginOpen}
                userId={userId}
                setUserId={setUserId} />

            <div className="home-page">
                <div className="search">
                    <input
                        className="search-bar"
                        type="text"
                        placeholder="From"
                        value={from}
                        onChange={(e) => setFrom(e.target.value)}
                    />
                    <input
                        className="search-bar"
                        type="text"
                        placeholder="To"
                        value={to}
                        onChange={(e) => setTo(e.target.value)}
                    />
                    <input
                        className="search-bar"
                        type="text"
                        placeholder="Departure"
                        value={departure}
                        onChange={(e) => setDeparture(e.target.value)}
                    />
                    <input
                        className="search-bar"
                        type="text"
                        placeholder="Number"
                        onChange={(e) => setFnumber(e.target.value)}
                    />
                    <button className="search-button" onClick={handleSearch}>
                        Search
                    </button>
                </div>

                <div className="flight-container">
                    {flights.length === 0 ? (
                        <p className="no-flights-text">Brak wyników wyszukiwania. Wpisz dane i kliknij Search.</p>
                    ) : (
                        flights.map((flight) => (
                            <div key={flight.Id} className="flight-card">
                                <div className="flight-header">
                                    <span className="flight-number">{flight.FlightNumber}</span>
                                    <span className="flight-terminal">Terminal {flight.Terminal} | Gate {flight.Gate}</span>
                                </div>
                                <div className="flight-route">
                                    <div className="route-block">
                                        <h3>{flight.FromAirportCode}</h3>
                                        <p>Odlot: {flight.DepartureTime}</p>
                                    </div>
                                    <div className="route-arrow">➔</div>
                                    <div className="route-block">
                                        <h3>{flight.ToAirportCode}</h3>
                                        <p>Przylot: {flight.ArrivalTime}</p>
                                    </div>
                                </div>
                            </div>
                        ))
                    )}
                </div>
            </div>
        </>
    )
}
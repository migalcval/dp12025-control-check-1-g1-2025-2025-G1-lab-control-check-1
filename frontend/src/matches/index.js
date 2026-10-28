import React, { useEffect, useState } from "react";
import { Table } from "reactstrap";

export default function MatchesListing() {
    //el roden tiene que ser “Name”, “Start”, “Finish”, “White”, “Black”, y “Winner”
    //Si el conjunto de partidas devuelto por la API es un array vacío, el componente debe mostrar un  título de nivel 1 (h1), con el texto “NO MATCHES”, en lugar de la tabla
    const [matches, setMatches] = useState([]);

    useEffect(() => {
        fetch("api/v1/matches")
            .then((response) => response.json())
            .then((data) => setMatches(data));
    }, []);

    if (matches.length === 0) {
        return <h1>NO MATCHES</h1>;
    }

    return (
        <Table>
            <thead>
                <tr>
                    <th>Name</th>
                    <th>Start</th>
                    <th>Finish</th>
                    <th>White</th>
                    <th>Black</th>
                    <th>Winner</th>
                </tr>
            </thead>
            <tbody>
                {matches.map(match => (
                    <tr key={match.id}>
                        <td>{match.name}</td>
                        <td>{match.start}</td>
                        <td>{match.finish}</td>
                        <td>{match.whitePlayer.username}</td>
                        <td>{match.blackPlayer.username}</td>
                        <td>{match.winner?.username}</td>
                    </tr>
                ))}
            </tbody>
        </Table>
    );
};

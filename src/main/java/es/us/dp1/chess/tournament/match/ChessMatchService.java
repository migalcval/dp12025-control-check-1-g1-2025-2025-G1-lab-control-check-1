package es.us.dp1.chess.tournament.match;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.us.dp1.chess.tournament.exceptions.UnfeasibleMatchException;
import es.us.dp1.chess.tournament.user.User;

@Service
public class ChessMatchService {

    MatchRepository repo;    

    @Autowired
    public ChessMatchService(MatchRepository repo) {
        this.repo = repo;        
    }

    



    @Transactional(readOnly = true)
    public Optional<ChessMatch> getMatchById(Integer id) {
        return repo.findById(id);
    }

    @Transactional (rollbackFor = UnfeasibleMatchException.class)
    public ChessMatch save(ChessMatch m) {
    //validar la fehca y los players
    if (m.getWhitePlayer() == null || m.getBlackPlayer() == null) {
        throw new UnfeasibleMatchException("Los jugadores no pueden ser nulos.");
    }
    if (m.getWinner() != null && !m.getWinner().equals(m.getWhitePlayer()) && !m.getWinner().equals(m.getBlackPlayer())) {
        throw new UnfeasibleMatchException("El ganador debe ser uno de los jugadores de la partida o nulo.");
    }
    if (m.getStart() != null && m.getName() != null && m.getStart().isAfter(m.getFinish())) {
        throw new UnfeasibleMatchException("El instante de inicio debe ser anterior al instante de fin.");
    }
        return repo.save(m);
    }

    @Transactional(readOnly = true)
    public List<ChessMatch> getMatches() {
        return repo.findAll();
    }    

}

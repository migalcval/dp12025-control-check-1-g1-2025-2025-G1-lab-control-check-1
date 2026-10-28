package es.us.dp1.chess.tournament.match;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PieceRepository extends CrudRepository<Piece, Integer> {

    @Query("SELECT p FROM Piece p WHERE p.color = :color AND p.type.name = :typeName")
    List<Piece> findByColorAndTypeName(@Param("color") PieceColor color, @Param("typeName") String typeName);

    List<Piece> findAll();

    Optional<Piece> findById(Integer i);

    Piece save(Piece piece);
    
}

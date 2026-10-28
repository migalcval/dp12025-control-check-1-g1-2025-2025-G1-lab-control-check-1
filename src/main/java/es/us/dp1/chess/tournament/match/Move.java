package es.us.dp1.chess.tournament.match;

import es.us.dp1.chess.tournament.model.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Entity 
@Getter
@Setter
public class Move extends BaseEntity {

    @NotNull 
    @Min(1)
    Integer turn;

    @NotNull 
    @Min (1)
    @Max (8)
    Integer originX;

    @NotNull 
    @Min (1)
    @Max (8)
    Integer originY;

    @NotNull 
    @Min (1)
    @Max (8)
    Integer destinationX;

    @NotNull 
    @Min (1)
    @Max (8)
    Integer destinationY;

    @ManyToOne
    @NotNull
    ChessMatch match;

    @ManyToOne
    @NotNull 
    Piece piece;

    @OneToOne
    Piece capture;
}

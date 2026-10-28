package es.us.dp1.chess.tournament.match;


import java.time.LocalDateTime;
import java.util.List;

import es.us.dp1.chess.tournament.model.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Entity 
@Getter
@Setter
public class Tournament extends BaseEntity {

    @NotNull 
    @NotBlank 
    @Size (min = 3, max = 50)
    String name;

    @NotNull 
    @NotBlank 
    @Size (min = 3, max = 50)
    String location;

    @NotNull 
    LocalDateTime startDate;

    @NotNull 
    LocalDateTime endDate;

    @NotNull 
    @Min(2)
    Integer maxParticipants;

    @OneToMany
    List<ChessMatch> matches;
}

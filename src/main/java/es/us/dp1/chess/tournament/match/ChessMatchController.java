package es.us.dp1.chess.tournament.match;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.us.dp1.chess.tournament.user.UserService;


@RestController 
@RequestMapping("/api/v1/matches") 
public class ChessMatchController {

    UserService userService;
    ChessMatchService matchService;

    public ChessMatchController(ChessMatchService service,UserService userService){
        this.matchService=service;
        this.userService=userService;    
    }

    @GetMapping
    public ResponseEntity<List<ChessMatch>> getAllMatches() {
        List<ChessMatch> matches = matchService.getMatches();
        return ResponseEntity.ok(matches);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ChessMatch> getMatchById(@PathVariable("id") Integer id) {
        return matchService.getMatchById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

}
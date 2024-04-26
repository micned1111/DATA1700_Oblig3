package com.example.data1700_oblig3;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
public class FilmController {
    @Autowired
    private FilmRepository rep;

    // Post ------------------------------------------------------------------------------------------------------------


    // GET -------------------------------------------------------------------------------------------------------------
    @GetMapping("/hentFilmer")
    public List<Film> hentFilmer(HttpServletResponse response) throws IOException {
        List<Film> filmListe = rep.hentFilmer();
        if (filmListe == null) {
            response.sendError(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Feil i databasen - prøv igjen senere");
        }
        return filmListe;
    }

    // DELETE ----------------------------------------------------------------------------------------------------------


    // PUT -------------------------------------------------------------------------------------------------------------
}

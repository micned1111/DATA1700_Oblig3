package com.example.data1700_oblig3;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
public class KinobillettController {
    @Autowired
    KinobillettRepository rep;

    // Post ------------------------------------------------------------------------------------------------------------
    @PostMapping("lagreBillett")
    public void lagreBillett (Kinobillett kinobillett, HttpServletResponse response) throws IOException {
        if(!rep.lagreBillett(kinobillett)) {
            response.sendError(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Feil i databasen - prøv igjen senere");
        }
    }

    // GET -------------------------------------------------------------------------------------------------------------
    @GetMapping("hentAlleBilletter")
    public List<Kinobillett> hentAlleBilletter(HttpServletResponse response) throws IOException {
        List<Kinobillett> kinobillettListe = rep.hentAlleBilletter();
        if(kinobillettListe == null) {
            response.sendError(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Feil i databasen - prøv igjen senere");
        }
        return kinobillettListe;
    }

    @GetMapping("/hentEnBillett")
    public Kinobillett hentEnBillett(@RequestParam Integer nr, HttpServletResponse response) throws IOException {
        Kinobillett kinobillett = rep.hentEnBillett(nr);
        if(kinobillett == null) {
            response.sendError(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Feil i databasen - prøv igjen senere");
        }
        return kinobillett;
    }


    // DELETE ----------------------------------------------------------------------------------------------------------
    @DeleteMapping("/slettAlleBilletter")
    public void slettAlleBilletter(HttpServletResponse response) throws IOException {
        if(!rep.slettAlleBilletter()) {
            response.sendError(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Feil i databasen - prøv igjen senere");
        }
    }

    @DeleteMapping("/slettEnBillett")
    public void slettEnBillett(@RequestParam Integer nr, HttpServletResponse response) throws IOException {
        if(!rep.slettEnBillett(nr)) {
            response.sendError(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Feil i databasen - prøv igjen senere");
        }
    }

    // PUT -------------------------------------------------------------------------------------------------------------
    @PutMapping("/endreBillett")
    public void endreBillett(@RequestBody Kinobillett kinobillett, HttpServletResponse response) throws IOException {
        if(!rep.endreBillett(kinobillett)) {
            response.sendError(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Feil i databasen - prøv igjen senere");
        }
    }
}

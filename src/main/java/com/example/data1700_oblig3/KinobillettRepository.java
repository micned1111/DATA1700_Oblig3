package com.example.data1700_oblig3;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class KinobillettRepository {
    @Autowired
    private JdbcTemplate db;

    private final Logger logger = LoggerFactory.getLogger(KinobillettRepository.class);

    // Post ------------------------------------------------------------------------------------------------------------
    public boolean lagreBillett (Kinobillett kinobillett) {
        String sql = "INSERT INTO Kinobillett(film,antall,fornavn,etternavn,telefonNr,epost) VALUES(?,?,?,?,?,?)";
        try {
            db.update(sql, kinobillett.getFilm(), kinobillett.getAntall(), kinobillett.getFornavn(),
                    kinobillett.getEtternavn(), kinobillett.getTelefonNr(), kinobillett.getEpost());
            return true;
        }
        catch (Exception e) {
            logger.error("Feil i lagreBillett: " + e);
            return false;
        }
    }

    // GET -------------------------------------------------------------------------------------------------------------
    public List<Kinobillett> hentAlleBilletter() {
        String sql = "SELECT * FROM Kinobillett";
        try {
            return db.query(sql, new BeanPropertyRowMapper<>(Kinobillett.class));
        }
        catch (Exception e) {
            logger.error("Feil i hentAlleBilletter: " + e);
            return null;
        }
    }

    public Kinobillett hentEnBillett( Integer nr) {
        String sql = "SELECT * FROM Kinobillett WHERE nr=?";
        try {
            return db.queryForObject(sql, new Object[]{nr}, new BeanPropertyRowMapper<>(Kinobillett.class));
        }
        catch (Exception e) {
            logger.error("Feil i hentEnBillett: " + e);
            return null;
        }
    }


    // DELETE ----------------------------------------------------------------------------------------------------------
    public boolean slettAlleBilletter() {
        String sql = "DELETE FROM Kinobillett";
        try {
            db.update(sql);
            return true;
        }
        catch (Exception e) {
            logger.error("Feil i slettAlleBilletter: " + e);
            return false;
        }
    }

    public boolean slettEnBillett(Integer nr) {
        String sql = "DELETE FROM Kinobillett WHERE nr=?";
        try {
            db.update(sql, nr);
            return true;
        }
        catch (Exception e) {
            logger.error("Feil i slettEnBillett: " + e);
            return false;
        }
    }


    // PUT -------------------------------------------------------------------------------------------------------------
    public boolean endreBillett(Kinobillett kinobillett) {
        String sql = "UPDATE Kinobillett SET film=?,antall=?,fornavn=?,etternavn=?,telefonNr=?,epost=? WHERE nr=?";
        try {
            db.update(sql, kinobillett.getFilm(), kinobillett.getAntall(), kinobillett.getFornavn(),
                    kinobillett.getEtternavn(), kinobillett.getTelefonNr(), kinobillett.getEpost(), kinobillett.getNr());
            return true;
        }
        catch (Exception e) {
            logger.error("Feil i endreBillett: " + e);
            return false;
        }
    }
}

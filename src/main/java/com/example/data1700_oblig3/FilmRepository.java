package com.example.data1700_oblig3;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class FilmRepository {
    @Autowired
    private JdbcTemplate db;

    private final Logger logger = LoggerFactory.getLogger(FilmRepository.class);

    // Post ------------------------------------------------------------------------------------------------------------


    // GET -------------------------------------------------------------------------------------------------------------
    public List<Film> hentFilmer() {
        String sql = "SELECT * FROM Film";
        try {
            return db.query(sql, new BeanPropertyRowMapper<>(Film.class));
        }
        catch (Exception e) {
            logger.error("Feil i hentFilmer: " + e);
            return null;
        }
    }


    // DELETE ----------------------------------------------------------------------------------------------------------


    // PUT -------------------------------------------------------------------------------------------------------------
}

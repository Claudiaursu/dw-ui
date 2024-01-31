package proiectOpera.dao;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import proiectOpera.model.Melodii;

@Repository
@Transactional
public class MelodiiDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Melodii> list() {
        String sql = "SELECT * FROM MELODII ";

        List<Melodii> listaMelodii = jdbcTemplate.query(sql,
                BeanPropertyRowMapper.newInstance(Melodii.class));

        return listaMelodii;
    }

    public void save(Melodii melodie) {
        SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
        insertActor.withTableName("Melodii").usingColumns("id_melodie","titlu", "autor", "durata", "gen", "id_act");
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(melodie);
        insertActor.execute(param);
    }

    public Melodii get(int id_melodie) {
        String sql = "SELECT * FROM MELODII WHERE id_melodie = ?";
        Object[] args = {id_melodie};
        Melodii melodie = jdbcTemplate.queryForObject(sql, args,
                BeanPropertyRowMapper.newInstance(Melodii.class));
        return melodie;
    }

    public void update(Melodii melodie) {
        String sql = "UPDATE MELODII SET id_melodie=:id_melodie, titlu=:titlu, autor=:autor, durata=:durata,gen=:gen,id_act=:id_act WHERE id_melodie=:id_melodie";
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(melodie);

        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);
        template.update(sql, param);
    }

    public void delete(int id_melodie) {
        String sql = "DELETE FROM MELODII WHERE id_melodie = ?";
        jdbcTemplate.update(sql,id_melodie);
    }
}


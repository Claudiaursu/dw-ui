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
import proiectOpera.model.Instrumente;

@Repository
@Transactional
public class InstrumenteDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Instrumente> list() {
        String sql = "SELECT * FROM INSTRUMENTE";

        List<Instrumente> listaInstrumente = jdbcTemplate.query(sql,
                BeanPropertyRowMapper.newInstance(Instrumente.class));

        return listaInstrumente;
    }

    public void save(Instrumente instrument) {
        SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
        insertActor.withTableName("Instrumente").usingColumns("denumire", "greutate", "tip");
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(instrument);
        insertActor.execute(param);
    }

    public Instrumente get(int id_instrument) {
        String sql = "SELECT * FROM INSTRUMENTE WHERE id_instrument = ?";
        Object[] args = {id_instrument};
        Instrumente instrument = jdbcTemplate.queryForObject(sql, args,
                BeanPropertyRowMapper.newInstance(Instrumente.class));
        return instrument;
    }

    public void update(Instrumente instrument) {
        String sql = "UPDATE INSTRUMENTE SET id_instrument=:id_instrument, denumire=:denumire, greutate=:greutate,tip=:tip WHERE id_instrument=:id_instrument";
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(instrument);

        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);
        template.update(sql, param);
    }

    public void delete(int id_instrument) {
        String sql = "DELETE FROM INSTRUMENTE WHERE id_instrument= ?";
        jdbcTemplate.update(sql,id_instrument);
    }
}


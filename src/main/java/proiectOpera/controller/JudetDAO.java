package proiectOpera.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import proiectOpera.model.Judet;

import java.util.List;

@Repository
@Transactional
public class JudetDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Judet> list() {
        String sql = "SELECT * FROM JUDET";

        List<Judet> listJudete = jdbcTemplate.query(sql,
                BeanPropertyRowMapper.newInstance(Judet.class));

        return listJudete;
    }

    public void save(Judet judet) {
        SimpleJdbcInsert insertJudet = new SimpleJdbcInsert(jdbcTemplate);
        insertJudet.withTableName("judet").usingColumns("denumire", "id_tara");
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(judet);
        insertJudet.execute(param);
    }

    public Judet get(int id_judet) {
        String sql = "SELECT * FROM JUDET WHERE id_judet = ?";
        Object[] args = {id_judet};
        return jdbcTemplate.queryForObject(sql, args,
                BeanPropertyRowMapper.newInstance(Judet.class));
    }

    public void update(Judet judet) {
        String sql = "UPDATE JUDET SET denumire=:denumire, id_tara=:id_tara WHERE id_judet=:id_judet";
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(judet);

        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);
        template.update(sql, param);
    }

    public void delete(int id_judet) {
        String sql = "DELETE FROM JUDET WHERE id_judet = ?";
        jdbcTemplate.update(sql, id_judet);
    }
}

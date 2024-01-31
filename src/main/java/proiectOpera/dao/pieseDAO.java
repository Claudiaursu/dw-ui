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
import proiectOpera.model.Piese;

@Repository
@Transactional
public class pieseDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Piese> list() {
        String sql = "SELECT * FROM PIESA";

        List<Piese> listPiese = jdbcTemplate.query(sql,
                BeanPropertyRowMapper.newInstance(Piese.class));

        return listPiese;
    }

    public void save(Piese piese_opera) {
        SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
        insertActor.withTableName("piesa").usingColumns( "titlu_piesa","gen_piesa", "descriere");
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(piese_opera);
        insertActor.execute(param);
    }

    public Piese get(String id_piesa) {
        String sql = "SELECT * FROM PIESA WHERE id_piesa = ?";
        Object[] args = {id_piesa};
        Piese piesa_opera = jdbcTemplate.queryForObject(sql, args,
                BeanPropertyRowMapper.newInstance(Piese.class));
        return piesa_opera;
    }

    public void update(Piese piesa) {
        String sql = "UPDATE PIESA SET titlu_piesa=:titlu_piesa, gen_piesa=:gen_piesa,  descriere=:descriere WHERE id_piesa=:id_piesa";
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(piesa);

        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);
        template.update(sql, param);
    }

    public void delete(Integer titlu_piesa) {
        String sql = "DELETE FROM PIESA WHERE id_piesa = ?";
        jdbcTemplate.update(sql,titlu_piesa);
    }
}


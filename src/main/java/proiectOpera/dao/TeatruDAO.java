package proiectOpera.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import proiectOpera.model.Teatru;

import java.util.List;

@Repository
@Transactional
public class TeatruDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Teatru> list() {
        String sql = "SELECT * FROM TEATRU";

        List<Teatru> listTeatre = jdbcTemplate.query(sql,
                BeanPropertyRowMapper.newInstance(Teatru.class));

        return listTeatre;
    }

    public void save(Teatru teatru) {
        SimpleJdbcInsert insertTeatru = new SimpleJdbcInsert(jdbcTemplate);
        insertTeatru.withTableName("teatru").usingColumns("denumire", "adresa", "id_localitate");
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(teatru);
        insertTeatru.execute(param);
    }

    public Teatru get(int id_teatru) {
        String sql = "SELECT * FROM TEATRU WHERE id_teatru = ?";
        Object[] args = {id_teatru};
        return jdbcTemplate.queryForObject(sql, args,
                BeanPropertyRowMapper.newInstance(Teatru.class));
    }

    public void update(Teatru teatru) {
        String sql = "UPDATE TEATRU SET denumire=:denumire, adresa=:adresa, id_localitate=:id_localitate WHERE id_teatru=:id_teatru";
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(teatru);

        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);
        template.update(sql, param);
    }

    public void delete(int id_teatru) {
        String sql = "DELETE FROM TEATRU WHERE id_teatru = ?";
        jdbcTemplate.update(sql, id_teatru);
    }
}

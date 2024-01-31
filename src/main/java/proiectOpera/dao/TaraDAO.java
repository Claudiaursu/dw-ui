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
import proiectOpera.model.Tara;

@Repository
@Transactional
public class TaraDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Tara> list() {
        String sql = "SELECT * FROM TARA";

        List<Tara> listTari = jdbcTemplate.query(sql,
                BeanPropertyRowMapper.newInstance(Tara.class));

        return listTari;
    }

    public void save(Tara tara) {
        SimpleJdbcInsert insertTara = new SimpleJdbcInsert(jdbcTemplate);
        insertTara.withTableName("tara").usingColumns("denumire");
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(tara);
        insertTara.execute(param);
    }

    public Tara get(int id) {
        String sql = "SELECT * FROM TARA WHERE id_tara = ?";
        Object[] args = {id};
        Tara tara = jdbcTemplate.queryForObject(sql, args,
                BeanPropertyRowMapper.newInstance(Tara.class));
        return tara;
    }

    public void update(Tara tara) {
        String sql = "UPDATE TARA SET denumire=:denumire WHERE id_tara=:id_tara";
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(tara);

        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);
        template.update(sql, param);
    }

    public void delete(int id) {
        String sql = "DELETE FROM TARA WHERE id_tara = ?";
        jdbcTemplate.update(sql, id);
    }
}

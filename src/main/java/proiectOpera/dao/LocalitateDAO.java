package proiectOpera.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import proiectOpera.model.Localitate;

import java.util.List;

@Repository
@Transactional
public class LocalitateDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Localitate> list() {
        String sql = "SELECT * FROM LOCALITATE";

        List<Localitate> listLocalitati = jdbcTemplate.query(sql,
                BeanPropertyRowMapper.newInstance(Localitate.class));

        return listLocalitati;
    }

    public void save(Localitate localitate) {
        SimpleJdbcInsert insertLocalitate = new SimpleJdbcInsert(jdbcTemplate);
        insertLocalitate.withTableName("localitate").usingColumns("denumire", "id_judet");
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(localitate);
        insertLocalitate.execute(param);
    }

    public Localitate get(int id_localitate) {
        String sql = "SELECT * FROM LOCALITATE WHERE id_localitate = ?";
        Object[] args = {id_localitate};
        return jdbcTemplate.queryForObject(sql, args,
                BeanPropertyRowMapper.newInstance(Localitate.class));
    }

    public void update(Localitate localitate) {
        String sql = "UPDATE LOCALITATE SET denumire=:denumire, id_judet=:id_judet WHERE id_localitate=:id_localitate";
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(localitate);

        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);
        template.update(sql, param);
    }

    public void delete(int id_localitate) {
        String sql = "DELETE FROM LOCALITATE WHERE id_localitate = ?";
        jdbcTemplate.update(sql, id_localitate);
    }
}

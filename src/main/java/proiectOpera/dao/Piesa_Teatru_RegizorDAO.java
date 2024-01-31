package proiectOpera.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import proiectOpera.model.Piesa_Teatru_Regizor;

import java.util.List;

@Repository
@Transactional
public class Piesa_Teatru_RegizorDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Piesa_Teatru_Regizor> list() {
        String sql = "SELECT * FROM PIESA_TEATRU_REGIZOR";

        List<Piesa_Teatru_Regizor> listPiesaTeatruRegizor = jdbcTemplate.query(sql,
                BeanPropertyRowMapper.newInstance(Piesa_Teatru_Regizor.class));

        return listPiesaTeatruRegizor;
    }

    public void save(Piesa_Teatru_Regizor piesa_teatru_regizor) {
        SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
        insertActor.withTableName("piesa_teatru_regizor")
                .usingColumns("id_piesa", "id_teatru", "id_regizor");

        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(piesa_teatru_regizor);
        insertActor.execute(param);
    }

    public Piesa_Teatru_Regizor get(Integer id) {
        String sql = "SELECT * FROM PIESA_TEATRU_REGIZOR WHERE id_piesa_teatru_regizor = ?";
        Object[] args = {id};
        return jdbcTemplate.queryForObject(sql, args, BeanPropertyRowMapper.newInstance(Piesa_Teatru_Regizor.class));
    }

    public void update(Piesa_Teatru_Regizor piesa_teatru_regizor) {
        String sql = "UPDATE PIESA_TEATRU_REGIZOR SET id_piesa=:id_piesa, id_teatru=:id_teatru, id_regizor=:id_regizor WHERE id_piesa_teatru_regizor=:id_piesa_teatru_regizor";
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(piesa_teatru_regizor);

        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);
        template.update(sql, param);
    }

    public void delete(Integer id) {
        String sql = "DELETE FROM PIESA_TEATRU_REGIZOR WHERE id_piesa_teatru_regizor = ?";
        jdbcTemplate.update(sql, id);
    }
}

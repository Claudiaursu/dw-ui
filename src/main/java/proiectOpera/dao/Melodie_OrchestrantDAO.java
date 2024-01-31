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
import proiectOpera.model.Melodie_Orchestrant;

@Repository
@Transactional
public class Melodie_OrchestrantDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Melodie_Orchestrant> list() {
        String sql = "SELECT * FROM MELODIE_ORCHESTRANT";

        List<Melodie_Orchestrant> listaMuzicanti = jdbcTemplate.query(sql,
                BeanPropertyRowMapper.newInstance(Melodie_Orchestrant.class));

        return listaMuzicanti;
    }

    public void save(Melodie_Orchestrant mel_om) {
        SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
        insertActor.withTableName("Melodie_Orchestrant").usingColumns("id_melodie","id_orchestrant");
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(mel_om);
        insertActor.execute(param);
    }

    public Melodie_Orchestrant get(int id_melodie, int id_orchestrant) {
        String sql = "SELECT * FROM MELODIE_ORCHESTRANT WHERE id_melodie = ? and id_orchestrant=?";
        Object[] args = {id_melodie, id_orchestrant};
        Melodie_Orchestrant mel_om = jdbcTemplate.queryForObject(sql, args,
                BeanPropertyRowMapper.newInstance(Melodie_Orchestrant.class));
        return mel_om;
    }

    public void update(Melodie_Orchestrant mel_om) {
        String sql = "UPDATE MELODIE_ORCHESTRANT SET id_melodie=:id_melodie, id_orchestrant=:id_orchestrant WHERE id_melodie=:id_melodie and id_orchestrant=:id_orchestrant";
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(mel_om);

        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);
        template.update(sql, param);
    }

    public void delete(int id_melodie, int id_orchestrant) {
        String sql = "DELETE FROM MELODIE_ORCHESTRANT WHERE id_melodie= ? and id_orchestrant=?";
        jdbcTemplate.update(sql,id_melodie, id_orchestrant);
    }
}


package proiectOpera.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import proiectOpera.model.Act_Orchestrant;

import java.util.List;

@Repository
@Transactional
public class ActOrchestrantDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Act_Orchestrant> list() {
        String sql = "SELECT * FROM ACT_ORCHESTRANT";

        List<Act_Orchestrant> listActOrchestrants = jdbcTemplate.query(sql,
                BeanPropertyRowMapper.newInstance(Act_Orchestrant.class));

        return listActOrchestrants;
    }

    public void save(Act_Orchestrant actOrchestrant) {
        SimpleJdbcInsert insertActOrchestrant = new SimpleJdbcInsert(jdbcTemplate);
        insertActOrchestrant.withTableName("act_orchestrant").usingColumns("id_act", "id_orchestrant");
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(actOrchestrant);
        insertActOrchestrant.execute(param);
    }

    public Act_Orchestrant get(int id_act) {
        String sql = "SELECT * FROM ACT_ORCHESTRANT WHERE id_act = ?";
        Object[] args = {id_act};
        return jdbcTemplate.queryForObject(sql, args,
                BeanPropertyRowMapper.newInstance(Act_Orchestrant.class));
    }

    public void update(Act_Orchestrant actOrchestrant) {
        String sql = "UPDATE ACT_ORCHESTRANT SET id_orchestrant=:id_orchestrant WHERE id_act=:id_act";
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(actOrchestrant);

        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);
        template.update(sql, param);
    }

    public void delete(int id_act) {
        String sql = "DELETE FROM ACT_ORCHESTRANT WHERE id_act = ?";
        jdbcTemplate.update(sql, id_act);
    }
}

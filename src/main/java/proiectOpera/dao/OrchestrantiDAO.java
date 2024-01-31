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
import proiectOpera.model.Orchestranti;

@Repository
@Transactional
public class OrchestrantiDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Orchestranti> list() {
        String sql = "SELECT * FROM ORCHESTRANTI";

        List<Orchestranti> listaOrchestra = jdbcTemplate.query(sql,
                BeanPropertyRowMapper.newInstance(Orchestranti.class));

        return listaOrchestra;
    }

    public void save(Orchestranti orchestrant) {
        SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
        insertActor.withTableName("Orchestranti").usingColumns("nume", "prenume", "data_nasterii", "data_angajarii","id_instrument");
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(orchestrant);
        insertActor.execute(param);
    }

    public Orchestranti get(int id_orchestrant) {
        String sql = "SELECT * FROM ORCHESTRANTI WHERE id_orchestrant = ?";
        Object[] args = {id_orchestrant};
        Orchestranti orchestrant = jdbcTemplate.queryForObject(sql, args,
                BeanPropertyRowMapper.newInstance(Orchestranti.class));
        return orchestrant;
    }

    public void update(Orchestranti orchestrant) {
        String sql = "UPDATE ORCHESTRANTI SET id_orchestrant=:id_orchestrant, nume=:nume, prenume=:prenume, data_nasterii=:data_nasterii,data_angajarii=:data_angajarii, id_instrument=:id_instrument WHERE id_orchestrant=:id_orchestrant";
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(orchestrant);

        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);
        template.update(sql, param);
    }

    public void delete(int id_orchestrant) {
        String sql = "DELETE FROM ORCHESTRANTI WHERE id_orchestrant= ?";
        jdbcTemplate.update(sql,id_orchestrant);
    }
}


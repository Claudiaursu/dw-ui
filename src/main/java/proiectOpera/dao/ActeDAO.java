package proiectOpera.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import proiectOpera.model.Acte;

import java.util.List;

@Repository
@Transactional
public class ActeDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Acte> list() {
        String sql = "SELECT * FROM ACTE";

        List<Acte> listActe = jdbcTemplate.query(sql,
                BeanPropertyRowMapper.newInstance(Acte.class));

        return listActe;
    }

    public void save(Acte act) {
        SimpleJdbcInsert insertActe = new SimpleJdbcInsert(jdbcTemplate);
        insertActe.withTableName("acte").usingColumns("durata", "id_piesa_teatru_regizor");
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(act);
        insertActe.execute(param);
    }

    public Acte get(Integer idAct) {
        String sql = "SELECT * FROM ACTE WHERE id_act = ?";
        Object[] args = {idAct};
        return jdbcTemplate.queryForObject(sql, args,
                BeanPropertyRowMapper.newInstance(Acte.class));
    }

    public void update(Acte act) {
        String sql = "UPDATE ACTE SET durata=:durata, id_piesa_teatru_regizor=:id_piesa_teatru_regizor WHERE id_act=:id_act";
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(act);

        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);
        template.update(sql, param);
    }

    public void delete(Integer idAct) {
        String sql = "DELETE FROM ACTE WHERE id_act = ?";
        jdbcTemplate.update(sql, idAct);
    }
}

package proiectOpera.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import proiectOpera.model.Actori;

@Repository
@Transactional
public class ActoriDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Actori> list() {
        String sql = "SELECT * FROM ACTOR";

        List<Actori> listActors = jdbcTemplate.query(sql,
                BeanPropertyRowMapper.newInstance(Actori.class));

        return listActors;
    }

    public void save(Actori actor) {
        SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
        insertActor.withTableName("actor").usingColumns("nume", "prenume", "data_nasterii", "data_angajarii", "sex");
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(actor);
        insertActor.execute(param);
    }

    public Actori get(int id) {
        String sql = "SELECT * FROM ACTOR WHERE id_actor = ?";
        Object[] args = {id};
        Actori actor = jdbcTemplate.queryForObject(sql, args,
                BeanPropertyRowMapper.newInstance(Actori.class));
        Date dataAngajarii = actor.getData_angajarii();
        Date dataNasterii = actor.getData_nasterii();

        SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd");

        String dataAngajariiFormatted = outputFormat.format(dataAngajarii);
        String dataNasteriiFormatted = outputFormat.format(dataNasterii);

        try {
            Date dataAngajariiFinal = outputFormat.parse(dataAngajariiFormatted);
            actor.setData_angajarii(dataAngajariiFinal);

            Date dataNasteriiFinal = outputFormat.parse(dataNasteriiFormatted);
            actor.setData_nasterii(dataNasteriiFinal);
        } catch (ParseException e) {
            return actor;
            //throw new RuntimeException(e);
        }

        return actor;
    }

    public void update(Actori actor) {
        String sql = "UPDATE ACTOR SET nume=:nume, prenume=:prenume, data_nasterii=:data_nasterii, " +
                "data_angajarii=:data_angajarii, tip_actor=:tip_actor WHERE id_actor=:id_actor";
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(actor);

        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);
        template.update(sql, param);
    }

    public void delete(int id) {
        String sql = "DELETE FROM ACTOR WHERE id_actor = ?";
        jdbcTemplate.update(sql, id);
    }
}

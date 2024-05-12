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
import proiectOpera.model.Regizori;

@Repository
@Transactional
public class RegizoriDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Regizori> list() {
        String sql = "SELECT * FROM REGIZOR";

        List<Regizori> listRegizori = jdbcTemplate.query(sql,
                BeanPropertyRowMapper.newInstance(Regizori.class));

        return listRegizori;
    }

    public void save(Regizori regizor) {
        SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
        insertActor.withTableName("Regizor").usingColumns("nume","prenume", "data_nasterii", "data_angajarii");
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(regizor);
        insertActor.execute(param);
    }

    public Regizori get(int id_regizor) {
        String sql = "SELECT * FROM REGIZOR WHERE id_regizor = ?";
        Object[] args = {id_regizor};
        Regizori regizor = jdbcTemplate.queryForObject(sql, args,
                BeanPropertyRowMapper.newInstance(Regizori.class));

        // Format the date fields
        Date dataNasterii = regizor.getData_nasterii();
        SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd");
        String dataNasteriiFormatted = outputFormat.format(dataNasterii);

        try {
            Date dataNasteriiFinal = outputFormat.parse(dataNasteriiFormatted);
            regizor.setData_nasterii(dataNasteriiFinal);
        } catch (ParseException e) {
            return regizor;
            //throw new RuntimeException(e);
        }

        return regizor;
    }


    public void update(Regizori regizor) {
        String sql = "UPDATE REGIZOR SET nume=:nume, prenume=:prenume, data_nasterii=:data_nasterii,data_angajarii=:data_angajarii WHERE id_regizor=:id_regizor";
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(regizor);

        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);
        template.update(sql, param);
    }

    public void delete(int id_regizor) {
        String sql = "DELETE FROM REGIZOR WHERE id_regizor = ?";
        jdbcTemplate.update(sql,id_regizor);
    }
}


package proiectOpera.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import proiectOpera.model.Regizori;
import proiectOpera.model.Reprezentatie;
import java.util.List;

@Repository
@Transactional
public class ReprezentatieDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Reprezentatie> list() {
        String sql = "SELECT * FROM REPREZENTATIE";

        return jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Reprezentatie.class));
    }

    public void save(Reprezentatie reprezentatie) {
        SimpleJdbcInsert insertReprezentatie = new SimpleJdbcInsert(jdbcTemplate);
        insertReprezentatie.withTableName("REPREZENTATIE").usingColumns("id_piesa_teatru_regizor", "data_ora_reprezentatie", "nr_locuri");
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(reprezentatie);
        insertReprezentatie.execute(param);
    }

    public Reprezentatie get(int id_reprezentatie) {
        String sql = "SELECT * FROM REPREZENTATIE WHERE ID_REPREZENTATIE = ?";
        Object[] args = {id_reprezentatie};
        return jdbcTemplate.queryForObject(sql, args, BeanPropertyRowMapper.newInstance(Reprezentatie.class));
    }
//
//    public void update(Reprezentatie reprezentatie) {
//        String sql = "UPDATE REPREZENTATIE SET ID_PIESA_TEATRU_REGIZOR = ?, DATA_ORA_REPREZENTATIE = ?, NR_LOCURI = ? WHERE ID_REPREZENTATIE = ?";
//        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(reprezentatie);
//
//        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);
//        template.update(sql, param);
//    }

    public void update(Reprezentatie reprezentatie) {
        String sql = "UPDATE REPREZENTATIE SET ID_PIESA_TEATRU_REGIZOR = :id_piesa_teatru_regizor, DATA_ORA_REPREZENTATIE = :data_ora_reprezentatie, NR_LOCURI = :nr_locuri WHERE ID_REPREZENTATIE = :id_reprezentatie";
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(reprezentatie);

        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);
        template.update(sql, param);
    }


    public void delete(int id_reprezentatie) {
        String sql = "DELETE FROM REPREZENTATIE WHERE ID_REPREZENTATIE = ?";
        jdbcTemplate.update(sql, id_reprezentatie);
    }
}

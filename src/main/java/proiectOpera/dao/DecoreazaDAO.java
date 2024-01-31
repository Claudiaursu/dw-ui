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
import proiectOpera.model.Decoreaza;

@Repository
@Transactional
public class DecoreazaDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Decoreaza> list() {
        String sql = "SELECT * FROM DECOREAZA";

        List<Decoreaza> listaDecor = jdbcTemplate.query(sql,
                BeanPropertyRowMapper.newInstance(Decoreaza.class));

        return listaDecor;
    }

    public void save(Decoreaza decor) {
        SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
        insertActor.withTableName("Decoreaza").usingColumns("id_act","id_recuzita");
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(decor);
        insertActor.execute(param);
    }

    public Decoreaza get(int id_act, int id_recuzita) {
        String sql = "SELECT * FROM DECOREAZA WHERE id_act = ? and id_recuzita=?";
        Object[] args = {id_act, id_recuzita};
        Decoreaza decor = jdbcTemplate.queryForObject(sql, args,
                BeanPropertyRowMapper.newInstance(Decoreaza.class));
        return decor;
    }

    public void update(Decoreaza decor) {
        String sql = "UPDATE DECOREAZA SET id_act=:id_act, id_recuzita=:id_recuzita WHERE id_act=:id_act and id_recuzita=:id_recuzita";
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(decor);

        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);
        template.update(sql, param);
    }

    public void delete(int id_act, int id_recuzita) {
        String sql = "DELETE FROM DECOREAZA WHERE id_act= ? and id_recuzita=?";
        jdbcTemplate.update(sql,id_act, id_recuzita);
    }
}


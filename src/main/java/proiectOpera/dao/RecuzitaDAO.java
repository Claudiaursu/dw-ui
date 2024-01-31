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
import proiectOpera.model.Recuzita;

@Repository
@Transactional
public class RecuzitaDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Recuzita> list() {
        String sql = "SELECT * FROM RECUZITA";

        List<Recuzita> listaRecuzita = jdbcTemplate.query(sql,
                BeanPropertyRowMapper.newInstance(Recuzita.class));

        return listaRecuzita;
    }

    public void save(Recuzita recuzita) {
        SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
        insertActor.withTableName("Recuzita").usingColumns("denumire", "culoare", "greutate", "inaltime");
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(recuzita);
        insertActor.execute(param);
    }

    public Recuzita get(int id_recuzita) {
        String sql = "SELECT * FROM RECUZITA WHERE id_recuzita = ?";
        Object[] args = {id_recuzita};
        Recuzita recuzita = jdbcTemplate.queryForObject(sql, args,
                BeanPropertyRowMapper.newInstance(Recuzita.class));
        return recuzita;
    }

    public void update(Recuzita recuzita) {
        String sql = "UPDATE RECUZITA SET id_recuzita=:id_recuzita, denumire=:denumire, culoare=:culoare, greutate=:greutate,inaltime=:inaltime WHERE id_recuzita=:id_recuzita";
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(recuzita);

        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);
        template.update(sql, param);
    }

    public void delete(int id_recuzita) {
        String sql = "DELETE FROM RECUZITA WHERE id_recuzita= ?";
        jdbcTemplate.update(sql,id_recuzita);
    }
}


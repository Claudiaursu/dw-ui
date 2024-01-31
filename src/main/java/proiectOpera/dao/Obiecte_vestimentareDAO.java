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
import proiectOpera.model.Obiecte_vestimentare;

@Repository
@Transactional
public class Obiecte_vestimentareDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Obiecte_vestimentare> list() {
        String sql = "SELECT * FROM OBIECTE_VESTIMENTARE";

        List<Obiecte_vestimentare> listaHaine = jdbcTemplate.query(sql,
                BeanPropertyRowMapper.newInstance(Obiecte_vestimentare.class));

        return listaHaine;
    }

    public void save(Obiecte_vestimentare haina) {
        SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
        insertActor.withTableName("Obiecte_vestimentare").usingColumns("denumire", "culoare", "material", "marime");
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(haina);
        insertActor.execute(param);
    }

    public Obiecte_vestimentare get(int id_obiect_vestimentar) {
        String sql = "SELECT * FROM OBIECTE_VESTIMENTARE WHERE id_obiect_vestimentar = ?";
        Object[] args = {id_obiect_vestimentar};
        Obiecte_vestimentare haina = jdbcTemplate.queryForObject(sql, args,
                BeanPropertyRowMapper.newInstance(Obiecte_vestimentare.class));
        return haina;
    }

    public void update(Obiecte_vestimentare haina) {
        String sql = "UPDATE OBIECTE_VESTIMENTARE SET id_obiect_vestimentar=:id_obiect_vestimentar, denumire=:denumire, culoare=:culoare, material=:material,marime=:marime WHERE id_obiect_vestimentar=:id_obiect_vestimentar";
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(haina);

        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);
        template.update(sql, param);
    }

    public void delete(int id_obiect_vestimentar) {
        String sql = "DELETE FROM OBIECTE_VESTIMENTARE WHERE  id_obiect_vestimentar= ?";
        jdbcTemplate.update(sql, id_obiect_vestimentar);
    }
}


package proiectOpera.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import proiectOpera.model.Aparitie;

import java.util.List;

@Repository
@Transactional
public class AparitieDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Aparitie> list() {
        String sql = "SELECT * FROM APARITIE";

        List<Aparitie> listAparitie = jdbcTemplate.query(sql,
                BeanPropertyRowMapper.newInstance(Aparitie.class));

        return listAparitie;
    }

    public void save(Aparitie aparitie) {
        SimpleJdbcInsert insertAparitie = new SimpleJdbcInsert(jdbcTemplate);
        insertAparitie.withTableName("APARITIE").usingColumns("id_obiect_vestimentar", "id_actor", "id_reprezentatie");
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(aparitie);
        insertAparitie.execute(param);
    }

    public Aparitie get(int id_aparitie) {
        String sql = "SELECT * FROM APARITIE WHERE id_aparitie = ?";
        Object[] args = {id_aparitie};
        Aparitie aparitie = jdbcTemplate.queryForObject(sql, args,
                BeanPropertyRowMapper.newInstance(Aparitie.class));
        return aparitie;
    }

    public void update(Aparitie aparitie) {
        String sql = "UPDATE APARITIE SET id_obiect_vestimentar = :id_obiect_vestimentar, id_actor = :id_actor, id_reprezentatie = :id_reprezentatie WHERE id_aparitie = :id_aparitie";
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(aparitie);

        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);
        template.update(sql, param);
    }

    public void delete(int id_aparitie) {
        String sql = "DELETE FROM APARITIE WHERE id_aparitie = ?";
        jdbcTemplate.update(sql, id_aparitie);
    }
}

package proiectOpera.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import proiectOpera.model.Categorie;

import java.util.List;

@Repository
@Transactional
public class CategorieDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Categorie> list() {
        String sql = "SELECT * FROM CATEGORIE";

        List<Categorie> listCategorie = jdbcTemplate.query(sql,
                BeanPropertyRowMapper.newInstance(Categorie.class));

        return listCategorie;
    }

    public void save(Categorie categorie) {
        SimpleJdbcInsert insertCategorie = new SimpleJdbcInsert(jdbcTemplate);
        insertCategorie.withTableName("categorie").usingColumns("tip_spectator", "pret");

        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(categorie);
        insertCategorie.execute(param);
    }

    public Categorie get(Integer id) {
        String sql = "SELECT * FROM CATEGORIE WHERE id_categorie = ?";
        Object[] args = {id};
        return jdbcTemplate.queryForObject(sql, args, BeanPropertyRowMapper.newInstance(Categorie.class));
    }

    public void update(Categorie categorie) {
        String sql = "UPDATE CATEGORIE SET tip_spectator=:tip_spectator, pret=:pret WHERE id_categorie=:id_categorie";
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(categorie);

        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);
        template.update(sql, param);
    }

    public void delete(Integer id) {
        String sql = "DELETE FROM CATEGORIE WHERE id_categorie = ?";
        jdbcTemplate.update(sql, id);
    }
}

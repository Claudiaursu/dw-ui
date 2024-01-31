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
import proiectOpera.model.Bilet;

@Repository
@Transactional
public class BiletDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Bilet> list() {
        String sql = "SELECT * FROM BILET";

        List<Bilet> listBilete = jdbcTemplate.query(sql,
                BeanPropertyRowMapper.newInstance(Bilet.class));

        return listBilete;
    }

    public void save(Bilet bilet) {
        SimpleJdbcInsert insertBilet = new SimpleJdbcInsert(jdbcTemplate);
        insertBilet.withTableName("bilet").usingColumns("id_reprezentatie", "id_categorie", "loc", "data_achizitie");
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(bilet);
        insertBilet.execute(param);
    }

    public Bilet get(int id) {
        String sql = "SELECT * FROM BILET WHERE id_bilet = ?";
        Object[] args = {id};
        Bilet bilet = jdbcTemplate.queryForObject(sql, args,
                BeanPropertyRowMapper.newInstance(Bilet.class));

        SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd");
        String dataAchizitieFormatted = outputFormat.format(bilet.getData_achizitie());

        try {
            Date dataAchizitieFinal = outputFormat.parse(dataAchizitieFormatted);
            bilet.setData_achizitie(dataAchizitieFinal);
        } catch (ParseException e) {
            return bilet;
        }

        return bilet;
    }

    public void update(Bilet bilet) {
        String sql = "UPDATE BILET SET id_reprezentatie=:id_reprezentatie, id_categorie=:id_categorie, " +
                "loc=:loc, data_achizitie=:data_achizitie WHERE id_bilet=:id_bilet";
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(bilet);

        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);
        template.update(sql, param);
    }

    public void delete(int id) {
        String sql = "DELETE FROM BILET WHERE id_bilet = ?";
        jdbcTemplate.update(sql, id);
    }
}

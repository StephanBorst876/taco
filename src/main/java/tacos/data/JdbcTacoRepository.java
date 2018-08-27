package tacos.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import tacos.domain.Taco;

@Repository
public class JdbcTacoRepository implements TacoRepository {

    private JdbcTemplate jdbc;

    public JdbcTacoRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    @Override
    public Taco save(Taco taco) {

        long id = saveDesignInfo(taco);
        taco.setId(id);
        for (String ingredient : taco.getIngredients()) {
            saveIngredientToDesign(ingredient, id);
        }
        return taco;
    }

    private long saveDesignInfo(Taco taco) {
//        taco.setCreatedAt(new Date());
//        PreparedStatementCreator psc = new PreparedStatementCreatorFactory(
//                "insert into Taco (name, createdAt) values (?,?)",
//                Types.VARCHAR, Types.TIMESTAMP
//        ).newPreparedStatementCreator(Arrays.asList(
//                taco.getName(),
//                new Timestamp(taco.getCreatedAt().getTime())));
//        KeyHolder keyHolder = new GeneratedKeyHolder();
//        jdbc.update(psc, keyHolder);
//        return keyHolder.getKey().intValue();

        KeyHolder holder = new GeneratedKeyHolder();
        jdbc.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection cnctn) throws SQLException {
                PreparedStatement ps = cnctn.prepareStatement("insert into Taco (name, createdAt) values (?,?)",
                        Statement.RETURN_GENERATED_KEYS);
                ps.setString(1, taco.getName());
                
                Calendar calendar = Calendar.getInstance();
                java.util.Date now = calendar.getTime();
                java.sql.Timestamp currentTimestamp = new java.sql.Timestamp(now.getTime());

                ps.setTimestamp(2, currentTimestamp );
                return ps;
            }

        }, holder);

        int newId = holder.getKey().intValue();
        return newId;

    }

    private void saveIngredientToDesign(String ingredientId, long tacoId) {
        jdbc.update("insert into Taco_Ingredients (tacoId, ingredientId) " + "values (?,?)", tacoId, ingredientId);
    }

}

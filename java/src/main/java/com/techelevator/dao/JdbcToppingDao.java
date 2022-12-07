package com.techelevator.dao;

import com.techelevator.model.Toppings;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class JdbcToppingDao implements ToppingDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcToppingDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    /**
     * Pulls a toppings object associated with the input ToppingId int
     * @param toppingId the serial id of the topping, as an int, matching the topping_id in the database
     * @return topping object
     */
    @Override
    public Toppings getToppingById(int toppingId) {
        String sql = "SELECT * FROM topping WHERE topping_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, toppingId);
        if (results.next()) {
            return mapRowToToppings(results);
        } else {
            return null;
        }
    }

    /**
     * creates a new toppings object in the SQL database with an auto-generated serial ID and default available=true
     *
     * @param name topping name, string
     * @param price topping price, double
     * @param isPremium if topping is premium, boolean
     * @return
     */
    @Override
    public Toppings createTopping(String name, double price, boolean isPremium) {
        String insertToppingSql = "INSERT into topping (name, price, isPremium, isAvailable) VALUES (?, ?, ?, ?) RETURNING topping_id";
        Integer newToppingId;
        newToppingId = jdbcTemplate.queryForObject(insertToppingSql, Integer.class, name, price, isPremium, true);
        if ( newToppingId != null) {
           return getToppingById(newToppingId);
        }
        return null;
    }


    /**
     * Maps an SQLrowset query result to a Topping object. Must map all properties.
     * @param rowSet result of SQL query as a row set object
     * @return topping object
     */
    private Toppings mapRowToToppings(SqlRowSet rowSet) {
        Toppings toppings = new Toppings();
        toppings.setName(rowSet.getString("name"));
        toppings.setToppingId(rowSet.getInt("topping_id"));
        toppings.setPrice(BigDecimal.valueOf(rowSet.getDouble("price")));
        toppings.setPremium(rowSet.getBoolean("isPremium"));
        toppings.setAvailable(rowSet.getBoolean("isAvailable"));

        return toppings;
    }

}

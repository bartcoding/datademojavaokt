package be.intecbrussel.spring.datademo.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public class BeerDaoImpl implements BeerDao{
    private final static String getBeerByIdQuery = "SELECT Name, Alcohol, Price, Stock FROM beers WHERE Id = ?";
    private final static String updateBeerQuery = "UPDATE Beers SET Stock = ? WHERE Id = ?";


    private JdbcTemplate template;

    @Autowired
    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }

    @Override
    public String getBeerById(int id) {
        Map<String, Object> result = template.queryForMap(getBeerByIdQuery, id);

        return "Name: " + result.get("Name")  +
                "\nAlcohol: " + result.get("Alcohol") +
                "\nPrice: " + result.get("Price") +
                "\nStock: " + result.get("Stock");
    }

    @Override
    public void setStock(int id, int stock) {
            template.update(updateBeerQuery, stock, id);
    }
}

package be.intecbrussel.spring.datademo.repository;

public interface BeerDao {
    String getBeerById(int id);
    void setStock(int id, int stock);
}

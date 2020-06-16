package be.intecbrussel.spring.datademo.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "beers")
public class Beer implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private int id;
    @ManyToOne
    @JoinColumn(name ="CategoryId")
    private Category category;
    @ManyToOne
    @JoinColumn(name ="BrewerId")
    private Brewer brewer;
    @Column(name="Name")
    private String name;
    @Column(name="Price")
    private float price;
    @Column(name="Stock")
    private int stock;
    @Column(name="Alcohol")
    private float alcohol;
    @Column(name="Version")
    private int version;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Brewer getBrewer() {
        return brewer;
    }

    public void setBrewer(Brewer brewer) {
        this.brewer = brewer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public float getAlcohol() {
        return alcohol;
    }

    public void setAlcohol(float alcohol) {
        this.alcohol = alcohol;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return "Beer{" +
                "id=" + id +
                ", category=" + category +
                ", brewer=" + brewer +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", stock=" + stock +
                ", alcohol=" + alcohol +
                ", version=" + version +
                '}';
    }
}

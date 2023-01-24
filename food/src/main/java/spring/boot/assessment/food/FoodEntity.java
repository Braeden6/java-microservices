package spring.boot.assessment.food;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "food")
public class FoodEntity {

    @Id
    private int id;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private int price;

    public FoodEntity() {
    }

    public FoodEntity(int id, String description, int price) {
        this.id = id;
        this.description = description;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "FoodEntity{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", price=" + price +
                '}';
    }
    
}

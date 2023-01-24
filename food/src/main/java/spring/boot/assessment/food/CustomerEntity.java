package spring.boot.assessment.food;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "customer")
public class CustomerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "customer_name")
    private String customerName;

    @ManyToMany(
        fetch=FetchType.LAZY,
        cascade = CascadeType.ALL
    )
    @JoinTable(
        name="customer_food",
        joinColumns = @JoinColumn(name = "customer_id"),
        inverseJoinColumns = @JoinColumn(name = "food_id")
    )
    private List<FoodEntity> food;

    public CustomerEntity() {
    }

    public CustomerEntity(int id, String customerName) {
        this.id = id;
        this.customerName = customerName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public List<FoodEntity> getFood() {
        return food;
    }

    public void setFood(List<FoodEntity> workOrders) {
        this.food = workOrders;
    }

    @Override
    public String toString() {
        return "CustomerEntity [customerName=" + customerName + ", id=" + id + ", food=" + food + "]";
    }

    
}

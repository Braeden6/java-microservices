package spring.boot.assessment.customer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;


@Repository
public class CustomerDAOImpl implements CustomerDAO {

        @Autowired
        private EntityManager entityManager;
    
        public List<CustomerEntity> findAll() {
                TypedQuery<CustomerEntity> theQuery = entityManager.createQuery("from CustomerEntity", CustomerEntity.class);
                List<CustomerEntity> food = theQuery.getResultList();
                return food;
        }

        public CustomerEntity findByFromAndTo(String from, String to) {
                TypedQuery<CustomerEntity> theQuery = entityManager.createQuery("from FoodEntity where from=:from and to=:to", CustomerEntity.class);
                theQuery.setParameter("from", from);
                theQuery.setParameter("to", to);
                CustomerEntity food = theQuery.getSingleResult();
                return food;
        }
    
        public CustomerEntity findById(int theId) {
                return null;
        }
    
        public void save(CustomerEntity theFood) {

        }
    
        public void deleteById(int theId) {

        }

        @Override
        public List<FoodEntity> findTopFood(int amount) {
            // get count of food from customer entity
            return null;
        }
        
}
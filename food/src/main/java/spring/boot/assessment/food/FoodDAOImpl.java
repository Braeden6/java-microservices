package spring.boot.assessment.food;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;


@Repository
public class FoodDAOImpl implements FoodDAO {

        @Autowired
        private EntityManager entityManager;
    
        public List<FoodEntity> findAll() {
                TypedQuery<FoodEntity> theQuery = entityManager.createQuery("from FoodEntity", FoodEntity.class);
                List<FoodEntity> food = theQuery.getResultList();
                return food;
        }

        public FoodEntity findByFromAndTo(String from, String to) {
                TypedQuery<FoodEntity> theQuery = entityManager.createQuery("from FoodEntity where from=:from and to=:to", FoodEntity.class);
                theQuery.setParameter("from", from);
                theQuery.setParameter("to", to);
                FoodEntity food = theQuery.getSingleResult();
                return food;
        }

        public List<FoodEntity> belowPrice(int price) {
                TypedQuery<FoodEntity> theQuery = entityManager.createQuery("from FoodEntity where price<:price", FoodEntity.class);
                theQuery.setParameter("price", price);
                List<FoodEntity> food = theQuery.getResultList();
                return food;
    }


    
        public FoodEntity findById(int theId) {
                return null;
        }
    
        public void save(FoodEntity theFood) {

        }
    
        public void deleteById(int theId) {

        }
        
}

/*

    @Override
    public Employee findById(int theId) {
        Employee theEmployee = entityManager.find(Employee.class, theId);
        return theEmployee;
    }

    @Override
    public void save(Employee theEmployee) {
        Employee dbEmployee =  entityManager.merge(theEmployee);
        theEmployee.setId(dbEmployee.getId());
    }

    @Override
    public void deleteById(int theId) {
        Query theQuery = entityManager.createQuery("delete from Employee where id=:employeeId");
        theQuery.setParameter("employeeId", theId);
        theQuery.executeUpdate();
    }
}

 */

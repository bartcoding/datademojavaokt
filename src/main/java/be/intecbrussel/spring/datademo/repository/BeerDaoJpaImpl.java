package be.intecbrussel.spring.datademo.repository;

import be.intecbrussel.spring.datademo.entities.Beer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;


@Repository
@Primary
public class BeerDaoJpaImpl implements BeerDao{

    private EntityManagerFactory entityManagerFactory;

    @PersistenceContext
    public void setEntityManagerFactory(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    @Override
    public String getBeerById(int id) {
        Beer beer =null;
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        try{

            entityTransaction.begin();
            beer = entityManager.find(Beer.class,id);
            entityTransaction.commit();
        }
        catch (Exception e){
            entityTransaction.rollback();
            e.printStackTrace();
        }
        finally {
            if(entityManager != null){
            entityManager.close();
            }
        }
        return beer.toString();


    }

    @Override
    @Transactional
    public void setStock(int id, int stock) {

    }
}

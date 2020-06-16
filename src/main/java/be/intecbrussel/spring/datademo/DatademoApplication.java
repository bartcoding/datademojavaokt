package be.intecbrussel.spring.datademo;

import be.intecbrussel.spring.datademo.repository.BeerDao;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class DatademoApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context =
                SpringApplication.run(DatademoApplication.class, args);
        BeerDao beerDao = context.getBean("beerDaoJpaImpl",BeerDao.class);

        String result = beerDao.getBeerById(468);
        System.out.println(result);

    }

}

package it.ibs.tourismsquare;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import it.ibs.tourismsquare.model.dao.EventCategory;
import it.ibs.tourismsquare.repository.EventCategoryRepository;



@SpringBootApplication
public class TourismSquareApplication {
	    
	public static void main(String[] args) {
		SpringApplication.run(TourismSquareApplication.class, args);
	}
	
	@Bean
    public CommandLineRunner mappingDemo(EventCategoryRepository eventCategoryR) {
        return args -> {
            eventCategoryR.save(new EventCategory("Cinema"));
            eventCategoryR.save(new EventCategory("Teatro"));
            eventCategoryR.save(new EventCategory("Concerti"));
            eventCategoryR.save(new EventCategory("Sagre"));
            eventCategoryR.save(new EventCategory("Mostre"));
            eventCategoryR.save(new EventCategory("Musei"));
            eventCategoryR.save(new EventCategory("Spettacoli"));
            eventCategoryR.save(new EventCategory("Sport"));
            eventCategoryR.save(new EventCategory("Fiere"));
            eventCategoryR.save(new EventCategory("Gastronomia"));
            eventCategoryR.save(new EventCategory("Escursioni"));
            eventCategoryR.save(new EventCategory("Moda"));
            eventCategoryR.save(new EventCategory("Mercatini"));
       };
    }

}

package us.team7pro.EventTicketsApp;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import us.team7pro.EventTicketsApp.Models.Event;
import us.team7pro.EventTicketsApp.Models.Transaction;
import us.team7pro.EventTicketsApp.Models.User;
import us.team7pro.EventTicketsApp.Repositories.EventRepository;
import us.team7pro.EventTicketsApp.Repositories.TransactionRepository;
import us.team7pro.EventTicketsApp.Repositories.UserRepository;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


@SpringBootApplication
public class EventTicketsAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(EventTicketsAppApplication.class, args);
	}

	@Bean
	ApplicationRunner init(EventRepository eventRepository, UserRepository userRepository, TransactionRepository transactionRepository) {
		return args -> {
			//Dummy Event data feeding
			List<Event> events = new LinkedList<>();
			events.add(new Event("Kygo  Music", "Concert", "12-10-2018", "New York", "Kygo is a Electronic Dance Music DJ", 19.99f, "img/bg-1.jpg"));
			events.add(new Event("Ultra Music Festival" ,"Festival", "11-1-2018", "Miami", "Top 10 Dj's playing", 27.49f, "img/bg-3.jpg"));
			events.add(new Event("Marshmello" ,"Concert", "10-18-2018", "Chicago", "Marshmello plays Techno", 13.99f, "img/bg-4.jpg"));
			events.add(new Event("VH1 Supersonic" ,"Festival", "10-18-2018", "California", "Sponsered by Sreekar Dhaduvai", 15.99f, "img/bg-5.jpg"));
			for (Event e: events) {
				eventRepository.save(e);
			}
			eventRepository.findAll().forEach(System.out::println);

			// Dummy User data feeding
			List<User> users = new LinkedList<>();
			ArrayList<Integer> transactions = new ArrayList<>();
			transactions.add(1);
			users.add(new User("User", "test1", "password1", "test1@gmail.com", transactions));
			users.add(new User("Admin", "test2", "password2", "test2@gmail.com", transactions));
			users.add(new User("Organizer", "test3", "password3", "test3@gmail.com", transactions));
			for (User u: users) {
				userRepository.save(u);
			}
			userRepository.findAll().forEach(System.out::println);

			// Dummy Transaction data feeding
			List<Transaction> realTransactions = new LinkedList<>();
			realTransactions.add(new Transaction(1, "test1", 1, "Kygo Music"));
			realTransactions.add(new Transaction(1, "test1", 3, "Marshmello"));
			realTransactions.add(new Transaction(2, "test2", 2, "Ultra Music Festival"));
			realTransactions.add(new Transaction(3, "test3", 2, "Ultra Music Festival"));
			for (Transaction t: realTransactions) {
				transactionRepository.save(t);
			}
			transactionRepository.findAll().forEach(System.out::println);
		};
	}
}

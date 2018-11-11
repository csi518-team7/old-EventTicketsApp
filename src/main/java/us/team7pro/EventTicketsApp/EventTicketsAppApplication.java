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
			events.add(new Event("Kygo  Music", "Concert", "Dec", "10", "New York", "Kygo is a Electronic Dance Music DJ", 19.99f, "bg-1"));
			events.add(new Event("Ultra Music Festival" ,"Festival", "Nov","1", "Miami", "Top 10 Dj's playing", 27.49f, "bg-3"));
			events.add(new Event("Marshmello" ,"Concert", "Oct", "18", "Chicago", "Marshmello plays Techno", 13.99f, "bg-2"));
			events.add(new Event("VH1 Supersonic" ,"Festival", "Oct", "18", "California", "Sponsered by Sreekar Dhaduvai", 15.99f, "bg-5"));
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

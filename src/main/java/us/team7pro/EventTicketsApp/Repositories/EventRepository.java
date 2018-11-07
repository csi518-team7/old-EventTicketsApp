package us.team7pro.EventTicketsApp.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import us.team7pro.EventTicketsApp.Models.Event;

public interface EventRepository extends JpaRepository<Event, Integer> {
}

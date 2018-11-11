package us.team7pro.EventTicketsApp.Services;

import org.springframework.stereotype.Service;
import us.team7pro.EventTicketsApp.Models.Event;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * This class is just for testing
 */
@Service
public class EventServiceStubImpl implements EventService {
    private List<Event> events = new LinkedList<>();

    public EventServiceStubImpl() {
//        events.add(new Event(1, "Event Dummy 1", "Concerts", "Albany"));
//        events.add(new Event(2, "Event Dummy 2", "Sports", "Canada"));
//        events.add(new Event(3, "Event Dummy 3", "Festival", "Troy"));
//        events.add(new Event(6, "Event Dummy 6", "Concerts", "New Jersey"));
//        events.add(new Event(5, "Event Dummy 5", "Theater", "Queens"));
//        events.add(new Event(4, "Event Dummy 4", "Concerts", "Long Island"));
    }


    @Override
    public List<Event> findAll() {
        return this.events;
    }

    @Override
    public List<Event> findLatest4() {
        return this.events.stream()
                .sorted((a,b)->b.getEventCategory().compareTo(a.getEventCategory()))
                .limit(4).collect(Collectors.toList());
    }

    @Override
    public List<Event> findLatest5() {
        return this.events.stream()
                .sorted((a,b)->b.getEventCategory().compareTo(a.getEventCategory()))
                .limit(5).collect(Collectors.toList());
    }

    @Override
    public List<Event> findLatest(int num){
        return this.findLatest5();
    }

    @Override
    public Event findByEventID(int eventID) {
        return this.events.stream().filter(e-> Objects.equals(e.getEventID(), eventID))
                .findFirst().orElse(null);
    }

    @Override
    public Event create(Event event) {
        events.add(event);
        return event;
    }

    @Override
    public Event edit(Event event) {
        for (int i = 0; i < this.events.size(); i++) {
            if (Objects.equals(this.events.get(i).getEventID(), event.getEventID())) {
                this.events.set(i, event);
                return event;
            }
        }
        throw new RuntimeException("Post not found: " + event.getEventID());
    }

    @Override
    public void deleteById(int id) {
        for (int i = 0; i < this.events.size(); i++) {
            if (Objects.equals(this.events.get(i).getEventID(), id)) {
                this.events.remove(i);
                return;
            }
        }
        throw new RuntimeException("Post not found: " + id);
    }
}
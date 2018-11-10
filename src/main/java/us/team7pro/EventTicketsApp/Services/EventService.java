package us.team7pro.EventTicketsApp.Services;

import us.team7pro.EventTicketsApp.Models.Event;

import java.util.List;

public interface EventService {
    List<Event> findAll();
    List<Event> findLatest4();
    List<Event> findLatest5();
    List<Event> findLatest(int numEvents);
    Event findByEventID(int eventID);
    Event create(Event event);
    Event edit(Event event);
    void deleteById(int id);
}

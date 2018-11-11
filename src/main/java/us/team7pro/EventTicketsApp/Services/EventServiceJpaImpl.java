package us.team7pro.EventTicketsApp.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import us.team7pro.EventTicketsApp.Models.Event;
import us.team7pro.EventTicketsApp.Repositories.EventRepository;
import org.springframework.context.annotation.Primary;
import java.util.*;

@Service
@Primary
public class EventServiceJpaImpl implements EventService{
    @Autowired
    private EventRepository eventRepo;

    @Override    
    public List<Event> findAll(){
        return this.eventRepo.findAll();
    }

    @Override 
    public List<Event> findLatest(int num){
        List<Event> allEvents = this.eventRepo.findAll();
        Collections.sort(allEvents, new Comparator<Event>(){
            @Override
            public int compare(Event e1, Event e2){
                return e2.getDay().compareTo(e1.getDay());
            }
        });
        for(int i=allEvents.size()-1; i>=num; i--){
            allEvents.remove(i);
        }
        return allEvents;                
    }
    @Override
    public List<Event> findLatest4(){
        return findLatest(4);
    }

    @Override
    public Event findByEventID(int eventID){
        return this.eventRepo.findByEventID(eventID);
    }
    @Override
    public Event create(Event event){
        return this.eventRepo.save(event);
    }
    @Override
    public Event edit(Event event){
        return this.eventRepo.save(event);
    }
    @Override
    public void deleteById(int id){
        Event evt = this.findByEventID(id);
        this.eventRepo.delete(evt);
    }
}



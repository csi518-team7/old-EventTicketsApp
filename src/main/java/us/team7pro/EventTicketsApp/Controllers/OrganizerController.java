package us.team7pro.EventTicketsApp.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import us.team7pro.EventTicketsApp.Models.Event;
import us.team7pro.EventTicketsApp.Services.EventService;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import us.team7pro.EventTicketsApp.Repositories.*;
@Controller
public class OrganizerController {
    @Autowired
    private EventService eventService;
    // @Autowired
    // private EventRepository eventRepository;

    @GetMapping("/organizer")
    public String eventForm(Model model) {
        model.addAttribute("newEvent", new Event());
        return "organizerdashboard";
    }

    @PostMapping("/organizer")
    public String eventSubmit(@ModelAttribute Event newEvent) {
        System.out.println(newEvent.getEventCategory());
        // eventRepository.save(newEvent);
        return "EventSubmitResult";
    }

    // @RequestMapping("/createEvent")
    // public String test(Model model) {

    //     return "eventRegistration";
    // }
}

package us.team7pro.EventTicketsApp.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import us.team7pro.EventTicketsApp.Models.Event;
import us.team7pro.EventTicketsApp.Services.EventService;

import java.util.List;

@Controller
public class ComingEventsController {
    @Autowired
    private EventService eventService;

    @GetMapping("/upcoming")
    public String upcoming(Model model) {
        List<Event> upcomingList = eventService.findLatest4();
        model.addAttribute("upcomingList", upcomingList);
        return "upcoming";
    }
}

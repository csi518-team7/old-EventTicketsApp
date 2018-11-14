package us.team7pro.EventTicketsApp.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;

import us.team7pro.EventTicketsApp.Models.*;
import us.team7pro.EventTicketsApp.Models.Transaction;
import us.team7pro.EventTicketsApp.Repositories.UserRepository;
import us.team7pro.EventTicketsApp.Repositories.EventRepository;
import us.team7pro.EventTicketsApp.Repositories.TransactionRepository;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {
    @Autowired
    UserRepository userRepository;

    @Autowired
    EventRepository eventRepository;

    @Autowired
    TransactionRepository transactionRepository;

    @GetMapping("/organizerdashboard")
    public String organizerdashboard() {
        return "organizerdashboard";
    }

    @GetMapping("/admindashboard")
    public String admindashboard() {
        return "admindashboard";
    }

    @GetMapping("/userdashboard")
    public String userdashboard(Model model) {
        List<Event> events = new ArrayList<Event>();;
        List<Transaction> userTransactions = transactionRepository.findByUserID(0);
        for (Transaction transaction : userTransactions) {
            events.add(eventRepository.findByEventID(transaction.getEventID()));
        }
        model.addAttribute("transactions", userTransactions);
        model.addAttribute("events", events);
        return "userdashboard";
    }

    // @RequestMapping("/purchaseTicket")
    // public String purchaseTicket(@RequestParam int eventID, @RequestParam int userID) {
    //     if (transactionRepository.findByUserIDAndEventID(userID, eventID) == null) {
    //         User usr = userRepository.findByUserID(userID);
    //         Event evt = eventRepository.findByEventID(eventID);
    //         Transaction t = new Transaction(usr.getUserID(), usr.getUserName(), evt.getEventID(), evt.getEventName());
    //         transactionRepository.save(t);
    //     }
    //     return "redirect:/./userdashboard";
    // }

    @RequestMapping("/cancelTicket")
    public String cancelTicket(@RequestParam int eventID, @RequestParam int userID) {
        Transaction t = transactionRepository.findByUserIDAndEventID(userID, eventID);
        if (t != null) {
            transactionRepository.delete(t);
        }
        return "redirect:/./userdashboard";
    }
}

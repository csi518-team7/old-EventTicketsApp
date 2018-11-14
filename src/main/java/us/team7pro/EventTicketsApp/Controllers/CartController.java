package us.team7pro.EventTicketsApp.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import us.team7pro.EventTicketsApp.Services.TransactionService;

@Controller
public class CartController {
    @Autowired
    private TransactionService transactionService;

    @PostMapping("/addToCart")
    public String postCart(@RequestParam int userID, @RequestParam int eventID, @RequestParam int numberOfTickets) {
        // 1. Handle data from buyTickets page
        //int userid = 0;
        //int eventid = 0;
        // 2. Save it into repo
        transactionService.addToCart(userID, eventID);
        // 3. redirect to cart page
        return "redirect:/./cart";
    }

    @GetMapping("/cart")
    public String getCart() {
        return "cart";
    }
}

package us.team7pro.EventTicketsApp.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import us.team7pro.EventTicketsApp.Services.TransactionService;
import us.team7pro.EventTicketsApp.Services.UserService;

@Controller
public class CartController {
    @Autowired
    private TransactionService transactionService;

    @PostMapping("/purchaseTicket")
    public String postCart() {
        // 1. Handle data from buyTickets page
        int userid = 0;
        int eventid = 0;
        // 2. Save it into repo
        transactionService.addToCart(userid, eventid);
        // 3. redirect to cart page
        return "cart";
    }

    @GetMapping("/cart")
    public String getCart() {
        return "cart";
    }
}

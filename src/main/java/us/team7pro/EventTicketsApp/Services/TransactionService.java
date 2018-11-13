package us.team7pro.EventTicketsApp.Services;

import us.team7pro.EventTicketsApp.Models.Transaction;

import java.util.List;

public interface TransactionService {
    List<Transaction> findByUserID(int userID);
    Transaction findByUserIDAndEventID(int userID, int eventID);
    void addToCart(int userID, int eventID);
}
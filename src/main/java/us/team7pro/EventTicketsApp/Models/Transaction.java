package us.team7pro.EventTicketsApp.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int transactionID;
    private int userID;
    private String userName;
    private int EventID;
    private String eventName;

    public Transaction() {
    }

    public Transaction(int userID, String userName, int eventID, String eventName) {
        this.userID = userID;
        this.userName = userName;
        EventID = eventID;
        this.eventName = eventName;
    }

    public int getTransactionID() {
        return transactionID;
    }

    public void setTransactionID(int transactionID) {
        this.transactionID = transactionID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getEventID() {
        return EventID;
    }

    public void setEventID(int eventID) {
        EventID = eventID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "transactionID=" + transactionID +
                ", userID=" + userID +
                ", userName='" + userName + '\'' +
                ", EventID=" + EventID +
                ", eventName='" + eventName + '\'' +
                '}';
    }
}

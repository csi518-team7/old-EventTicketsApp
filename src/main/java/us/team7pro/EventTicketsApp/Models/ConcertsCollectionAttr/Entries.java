package us.team7pro.EventTicketsApp.Models.ConcertsCollectionAttr;

public class Entries {
    private String ConcertTitle;
    private String Artist;
    private String Location;
    private String Date;
    private String Time;

    public Entries() {
    }

    public String getConcertTitle() {
        return ConcertTitle;
    }

    public void setConcertTitle(String concertTitle) {
        ConcertTitle = concertTitle;
    }

    public String getArtist() {
        return Artist;
    }

    public void setArtist(String artist) {
        Artist = artist;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String time) {
        Time = time;
    }

    @Override
    public String toString() {
        return "Entries{" +
                "ConcertTitle='" + ConcertTitle + '\'' +
                ", Artist='" + Artist + '\'' +
                ", Location='" + Location + '\'' +
                ", Date='" + Date + '\'' +
                ", Time='" + Time + '\'' +
                '}';
    }
}

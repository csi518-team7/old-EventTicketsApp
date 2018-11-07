package us.team7pro.EventTicketsApp.Models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import us.team7pro.EventTicketsApp.Models.ConcertsCollectionAttr.Entries;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ConcertsCollection {
    private Entries entries;

    public ConcertsCollection() {
    }

    public Entries getEntries() {
        return entries;
    }

    public void setEntries(Entries entries) {
        this.entries = entries;
    }

    @Override
    public String toString() {
        return "ConcertsCollection{" +
                "entries=" + entries +
                '}';
    }
}

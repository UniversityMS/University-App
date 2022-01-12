package lv.unversityManagementSystem.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "events")
public class Event implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "event_id", nullable = false, updatable = false)
    private long id;

    @Column(name = "date")
    private String date;

    @Column(name = "name")
    private String eventName;

    @Column(name = "description")
    private String eventDescription;



    public Event() {
    }

    public Event(long id, String date, String eventName, String eventDescription) {
        this.id = id;
        this.date = date;
        this.eventName = eventName;
        this.eventDescription = eventDescription;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getEventDescription() {
        return eventDescription;
    }

    public void setEventDescription(String eventDescription) {
        this.eventDescription = eventDescription;
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", date='" + date + '\'' +
                ", eventName='" + eventName + '\'' +
                ", eventDescription='" + eventDescription + '\'' +
                '}';
    }
}

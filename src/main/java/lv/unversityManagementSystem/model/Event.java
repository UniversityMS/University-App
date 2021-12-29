package lv.unversityManagementSystem.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "events")
public class Event implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    //@Column(name = "id", nullable = false, updatable = false)
    private long id;

    @Column(name = "event_date")
    private String eventDate;

    @Column(name = "event_name")
    private String eventName;

    @Column(name = "description")
    private String eventDescription;



    public Event() {
    }

    public Event(long id, String eventDate, String eventName, String eventDescription) {
        this.id = id;
        this.eventDate = eventDate;
        this.eventName = eventName;
        this.eventDescription = eventDescription;
    }

    public long getEventId() {
        return id;
    }

    public void setEventId(long id) {
        this.id = id;
    }

    public String getEventDate() {
        return eventDate;
    }

    public void setEventDate(String eventDate) {
        this.eventDate = eventDate;
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
                ", eventDate='" + eventDate + '\'' +
                ", eventName='" + eventName + '\'' +
                ", eventDescription='" + eventDescription + '\'' +
                '}';
    }
}

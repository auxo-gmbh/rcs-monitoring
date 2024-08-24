package master.thesis.monitoring.model.message;

import master.thesis.monitoring.model.enums.EventType;

public class Event {

    private EventType eventType;

    public Event() {
    }

    public EventType getEventType() {
        return eventType;
    }

    public void setEventType(EventType eventType) {
        this.eventType = eventType;
    }
}

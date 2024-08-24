package master.thesis.monitoring.model.entity;


import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.HashSet;
import java.util.List;

@Node
public class Device {
    @Id
    @GeneratedValue
    private Long id;

    private Integer port;

    private Long sentAt;

    private List<String> taskTypes;

    private boolean latest;

    @Relationship(type = "CONNECTED_TO", direction = Relationship.Direction.OUTGOING)
    private HashSet<Link> connectedTo;

    @Relationship(type = "SENT_TO", direction = Relationship.Direction.OUTGOING)
    private HashSet<Message> sentTo;

    public Device() {}

    public Device(Integer port, Long sentAt, List<String> taskTypes, boolean latest) {
        this.port = port;
        this.sentAt = sentAt;
        this.taskTypes = taskTypes;
        this.latest = latest;
        this.connectedTo = new HashSet<>();
        this.sentTo = new HashSet<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public Long getSentAt() {
        return sentAt;
    }

    public void setSentAt(Long sentAt) {
        this.sentAt = sentAt;
    }

    public List<String> getTaskTypes() {
        return taskTypes;
    }

    public void setTaskTypes(List<String> taskTypes) {
        this.taskTypes = taskTypes;
    }

    public boolean isLatest() {
        return latest;
    }

    public void setLatest(boolean latest) {
        this.latest = latest;
    }

    public HashSet<Link> getConnectedTo() {
        return connectedTo;
    }

    public void setConnectedTo(HashSet<Link> connectedTo) {
        this.connectedTo = connectedTo;
    }

    public HashSet<Message> getSentTo() {
        return sentTo;
    }

    public void setSentTo(HashSet<Message> sentTo) {
        this.sentTo = sentTo;
    }

    @Override
    public String toString() {
        return "Device{" +
                "id=" + id +
                ", port=" + port +
                ", sentAt=" + sentAt +
                ", taskTypes=" + taskTypes +
                ", latest=" + latest +
                '}';
    }
}

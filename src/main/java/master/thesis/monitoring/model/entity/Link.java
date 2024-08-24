package master.thesis.monitoring.model.entity;

import org.springframework.data.neo4j.core.schema.RelationshipId;
import org.springframework.data.neo4j.core.schema.RelationshipProperties;
import org.springframework.data.neo4j.core.schema.TargetNode;

@RelationshipProperties
public class Link {
    @RelationshipId
    private Long id;

    private Long openedConnectionAt;

    private Long closedConnectionAt;

    @TargetNode
    private Device targetDevice;

    private Boolean fromSelfActualization;

    public Link() {
    }

    public Link(Long openedConnectionAt, Device targetDevice) {
        this.openedConnectionAt = openedConnectionAt;
        this.targetDevice = targetDevice;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOpenedConnectionAt() {
        return openedConnectionAt;
    }

    public void setOpenedConnectionAt(Long openedConnectionAt) {
        this.openedConnectionAt = openedConnectionAt;
    }

    public Long getClosedConnectionAt() {
        return closedConnectionAt;
    }

    public void setClosedConnectionAt(Long closedConnectionAt) {
        this.closedConnectionAt = closedConnectionAt;
    }

    public Device getTargetDevice() {
        return targetDevice;
    }

    public void setTargetDevice(Device targetDevice) {
        this.targetDevice = targetDevice;
    }

    public Boolean getFromSelfActualization() {
        return fromSelfActualization;
    }

    public void setFromSelfActualization(Boolean fromSelfActualization) {
        this.fromSelfActualization = fromSelfActualization;
    }

    @Override
    public String toString() {
        return "Link{" +
                "id=" + id +
                ", openedConnectionAt=" + openedConnectionAt +
                ", closedConnectionAt=" + closedConnectionAt +
                ", targetDevice=" + targetDevice.getPort() +
                ", fromSelfActualization=" + fromSelfActualization +
                '}';
    }
}

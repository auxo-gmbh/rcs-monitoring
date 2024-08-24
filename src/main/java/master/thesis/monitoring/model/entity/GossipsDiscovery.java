package master.thesis.monitoring.model.entity;

import master.thesis.monitoring.model.message.GossipDiscoveryResponseEvent;
import org.springframework.data.neo4j.core.schema.*;

import java.util.List;

@Node
public class GossipsDiscovery {

    @Id
    @GeneratedValue
    private Long id;

    @Relationship(type = "DECIDED_ON", direction = Relationship.Direction.INCOMING)
    private Device device;

    private String requestId;


    @Relationship(type = "HAS_POSSIBILITIES", direction = Relationship.Direction.OUTGOING)
    private List<GossipsDiscoveryResponse> responses;

    private Long sentAt;

    public GossipsDiscovery(Device device, String requestId, List<GossipsDiscoveryResponse> responses, Long sentAt) {
        this.device = device;
        this.requestId = requestId;
        this.responses = responses;
        this.sentAt = sentAt;
    }

    public GossipsDiscovery() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Device getDevice() {
        return device;
    }

    public void setDevice(Device device) {
        this.device = device;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public List<GossipsDiscoveryResponse> getResponses() {
        return responses;
    }

    public void setResponses(List<GossipsDiscoveryResponse> responses) {
        this.responses = responses;
    }

    public Long getSentAt() {
        return sentAt;
    }

    public void setSentAt(Long sentAt) {
        this.sentAt = sentAt;
    }

    @Override
    public String toString() {
        return "GossipsDiscovery{" +
                "id=" + id +
                ", device=" + device.getPort() +
                ", requestId='" + requestId + '\'' +
                ", responses=" + responses +
                ", sentAt=" + sentAt +
                '}';
    }
}

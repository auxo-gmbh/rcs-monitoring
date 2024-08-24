package master.thesis.monitoring.model.message;

import java.util.List;

public class GossipsDiscoveryEvent extends Event {


    private String requestId;
    private List<GossipDiscoveryResponseEvent> responses;
    private Long sentAt;
    private Integer sourcePort;

    public GossipsDiscoveryEvent() {
    }

    public GossipsDiscoveryEvent(String requestId, List<GossipDiscoveryResponseEvent> responses, Long sentAt, Integer sourcePort) {
        this.requestId = requestId;
        this.responses = responses;
        this.sentAt = sentAt;
        this.sourcePort = sourcePort;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public List<GossipDiscoveryResponseEvent> getResponses() {
        return responses;
    }

    public void setResponses(List<GossipDiscoveryResponseEvent> responses) {
        this.responses = responses;
    }

    public Long getSentAt() {
        return sentAt;
    }

    public void setSentAt(Long sentAt) {
        this.sentAt = sentAt;
    }

    public Integer getSourcePort() {
        return sourcePort;
    }

    public void setSourcePort(Integer sourcePort) {
        this.sourcePort = sourcePort;
    }
}

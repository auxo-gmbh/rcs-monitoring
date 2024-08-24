package master.thesis.monitoring.model.message;

public class LinkEvent extends Event {

    private Integer sourcePort;

    private Integer targetPort;

    private Long openedConnectionAt;

    private Long closedConnectionAt;

    private Boolean fromSelfActualization;

    public LinkEvent() {
    }

    public LinkEvent(Integer sourcePort, Integer targetPort, Long openedConnectionAt, Long closedConnectionAt, Boolean fromSelfActualization) {
        this.sourcePort = sourcePort;
        this.targetPort = targetPort;
        this.openedConnectionAt = openedConnectionAt;
        this.closedConnectionAt = closedConnectionAt;
        this.fromSelfActualization = fromSelfActualization;
    }

    public Integer getSourcePort() {
        return sourcePort;
    }

    public void setSourcePort(Integer sourcePort) {
        this.sourcePort = sourcePort;
    }

    public Integer getTargetPort() {
        return targetPort;
    }

    public void setTargetPort(Integer targetPort) {
        this.targetPort = targetPort;
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

    public Boolean getFromSelfActualization() {
        return fromSelfActualization;
    }

    public void setFromSelfActualization(Boolean fromSelfActualization) {
        this.fromSelfActualization = fromSelfActualization;
    }
}

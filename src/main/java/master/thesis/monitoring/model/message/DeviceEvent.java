package master.thesis.monitoring.model.message;

import java.util.List;

public class DeviceEvent extends Event{

    private Integer sourcePort;

    private Long sentAt;

    private List<String> taskTypes;

    public DeviceEvent() {
    }

    public DeviceEvent(Integer sourcePort, Long sentAt, List<String> taskTypes) {
        this.sourcePort = sourcePort;
        this.sentAt = sentAt;
        this.taskTypes = taskTypes;
    }

    public Integer getSourcePort() {
        return sourcePort;
    }

    public void setSourcePort(Integer sourcePort) {
        this.sourcePort = sourcePort;
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
}

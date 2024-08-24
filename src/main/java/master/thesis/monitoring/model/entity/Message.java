package master.thesis.monitoring.model.entity;

import master.thesis.monitoring.model.enums.DetailsType;
import master.thesis.monitoring.model.message.MessagingEvent;
import org.springframework.data.neo4j.core.schema.CompositeProperty;
import org.springframework.data.neo4j.core.schema.RelationshipId;
import org.springframework.data.neo4j.core.schema.RelationshipProperties;
import org.springframework.data.neo4j.core.schema.TargetNode;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RelationshipProperties
public class Message {

    @RelationshipId
    private Long id;

    private String requestId;

    private Long sentAt;

    private String taskType;

    private List<Integer> path;

    private DetailsType details;

    private String pheromonesEdges;

    private Double qualityPheromones;

    private Double functionTime;

    @TargetNode
    private Device targetDevice;

    public Message() {
    }

    public Message(MessagingEvent messagingEvent, Device targetDevice) {
        this.requestId = messagingEvent.getRequestId();
        this.sentAt = messagingEvent.getSentAt();
        this.taskType = messagingEvent.getTaskType();
        this.path = messagingEvent.getPath();
        this.details = messagingEvent.getDetails();
        this.pheromonesEdges = mapToString(messagingEvent.getPheromonesEdges());
        this.qualityPheromones = messagingEvent.getQualityPheromones();
        this.functionTime = messagingEvent.getFunctionTime();
        this.targetDevice = targetDevice;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public Long getSentAt() {
        return sentAt;
    }

    public void setSentAt(Long sentAt) {
        this.sentAt = sentAt;
    }

    public String getTaskType() {
        return taskType;
    }

    public void setTaskType(String taskType) {
        this.taskType = taskType;
    }

    public List<Integer> getPath() {
        return path;
    }

    public void setPath(List<Integer> path) {
        this.path = path;
    }

    public DetailsType getDetails() {
        return details;
    }

    public void setDetails(DetailsType details) {
        this.details = details;
    }

    public Device getTargetDevice() {
        return targetDevice;
    }

    public void setTargetDevice(Device targetDevice) {
        this.targetDevice = targetDevice;
    }

    public String getPheromonesEdges() {
        return pheromonesEdges;
    }

    public void setPheromonesEdges(String pheromonesEdges) {
        this.pheromonesEdges = pheromonesEdges;
    }

    public Double getQualityPheromones() {
        return qualityPheromones;
    }

    public void setQualityPheromones(Double qualityPheromones) {
        this.qualityPheromones = qualityPheromones;
    }

    public void setFunctionTime(Double functionTime) {
        this.functionTime = functionTime;
    }

    public Double getFunctionTime() {
        return functionTime;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", requestId='" + requestId + '\'' +
                ", sentAt=" + sentAt +
                ", taskType='" + taskType + '\'' +
                ", path=" + path +
                ", details=" + details +
                ", pheromonesEdges=" + pheromonesEdges +
                ", qualityPheromones=" + qualityPheromones +
                ", functionTime=" + functionTime +
                ", targetDevice=" + targetDevice.getPort() +
                '}';
    }

    public static String mapToString(Map<String, Double> map) {
        if (map == null) {
            return null;
        }
        return map.keySet().stream()
                .map(key -> key + "=" + map.get(key))
                .collect(Collectors.joining(", ", "{", "}"));
    }
}

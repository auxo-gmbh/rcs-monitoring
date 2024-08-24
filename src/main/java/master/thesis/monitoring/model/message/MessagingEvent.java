package master.thesis.monitoring.model.message;

import master.thesis.monitoring.model.enums.DetailsType;

import java.util.List;
import java.util.Map;

public class MessagingEvent extends Event {

    private String requestId;

    private Long sentAt;

    private String taskType;

    private List<Integer> path;

    private DetailsType details;

    private Integer sourcePort;

    private Integer targetPort;

    private Map<String, Double> pheromonesEdges;

    private Double qualityPheromones;

    private Double functionTime;

    public MessagingEvent() {
    }

    public MessagingEvent(String requestId, Long sentAt, String taskType, List<Integer> path, DetailsType details, Integer sourcePort, Integer targetPort, Map<String, Double> pheromonesEdges, Double qualityPheromones, Double functionTime) {
        this.requestId = requestId;
        this.sentAt = sentAt;
        this.taskType = taskType;
        this.path = path;
        this.details = details;
        this.sourcePort = sourcePort;
        this.targetPort = targetPort;
        this.pheromonesEdges = pheromonesEdges;
        this.qualityPheromones = qualityPheromones;
        this.functionTime = functionTime;
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

    public Map<String, Double> getPheromonesEdges() {
        return pheromonesEdges;
    }

    public void setPheromonesEdges(Map<String, Double> pheromonesEdges) {
        this.pheromonesEdges = pheromonesEdges;
    }

    public Double getQualityPheromones() {
        return qualityPheromones;
    }

    public void setQualityPheromones(Double qualityPheromones) {
        this.qualityPheromones = qualityPheromones;
    }

    public Double getFunctionTime() {
        return functionTime;
    }

    public void setFunctionTime(Double functionTime) {
        this.functionTime = functionTime;
    }

    @Override
    public String toString() {
        return "MessagingEvent{" +
                "requestId='" + requestId + '\'' +
                ", sentAt=" + sentAt +
                ", taskType='" + taskType + '\'' +
                ", path=" + path +
                ", details=" + details +
                ", sourcePort=" + sourcePort +
                ", targetPort=" + targetPort +
                ", pheromonesEdges=" + pheromonesEdges +
                ", qualityPheromones=" + qualityPheromones +
                ", functionTime=" + functionTime +
                '}';
    }

}

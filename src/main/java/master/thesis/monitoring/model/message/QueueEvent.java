package master.thesis.monitoring.model.message;

public class QueueEvent extends Event {

    private Integer sourcePort;
    private Long sentAt;
    private Integer queueSize;
    private Integer minQueueOccupation;
    private Integer maxQueueOccupation;
    private Double averageQueueOccupation;
    private Double standardDeviationQueueOccupation;
    private Double varianceQueueOccupation;

    public QueueEvent() {
    }

    public QueueEvent(
            Integer sourcePort,
            Long sentAt,
            Integer queueSize,
            Integer minQueueOccupation,
            Integer maxQueueOccupation,
            Double averageQueueOccupation,
            Double standardDeviationQueueOccupation,
            Double varianceQueueOccupation
    ) {
        this.sourcePort = sourcePort;
        this.sentAt = sentAt;
        this.queueSize = queueSize;
        this.minQueueOccupation = minQueueOccupation;
        this.maxQueueOccupation = maxQueueOccupation;
        this.averageQueueOccupation = averageQueueOccupation;
        this.standardDeviationQueueOccupation = standardDeviationQueueOccupation;
        this.varianceQueueOccupation = varianceQueueOccupation;
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

    public Integer getQueueSize() {
        return queueSize;
    }

    public void setQueueSize(Integer queueSize) {
        this.queueSize = queueSize;
    }

    public Integer getMinQueueOccupation() {
        return minQueueOccupation;
    }

    public void setMinQueueOccupation(Integer minQueueOccupation) {
        this.minQueueOccupation = minQueueOccupation;
    }

    public Integer getMaxQueueOccupation() {
        return maxQueueOccupation;
    }

    public void setMaxQueueOccupation(Integer maxQueueOccupation) {
        this.maxQueueOccupation = maxQueueOccupation;
    }

    public Double getAverageQueueOccupation() {
        return averageQueueOccupation;
    }

    public void setAverageQueueOccupation(Double averageQueueOccupation) {
        this.averageQueueOccupation = averageQueueOccupation;
    }

    public Double getStandardDeviationQueueOccupation() {
        return standardDeviationQueueOccupation;
    }

    public void setStandardDeviationQueueOccupation(Double standardDeviationQueueOccupation) {
        this.standardDeviationQueueOccupation = standardDeviationQueueOccupation;
    }

    public Double getVarianceQueueOccupation() {
        return varianceQueueOccupation;
    }

    public void setVarianceQueueOccupation(Double varianceQueueOccupation) {
        this.varianceQueueOccupation = varianceQueueOccupation;
    }

    @Override
    public String toString() {
        return "QueueEvent{" +
                "sourcePort=" + sourcePort +
                ", sentAt=" + sentAt +
                ", queueSize=" + queueSize +
                ", minQueueOccupation=" + minQueueOccupation +
                ", maxQueueOccupation=" + maxQueueOccupation +
                ", averageQueueOccupation=" + averageQueueOccupation +
                ", standardDeviationQueueOccupation=" + standardDeviationQueueOccupation +
                ", varianceQueueOccupation=" + varianceQueueOccupation +
                '}';
    }
}

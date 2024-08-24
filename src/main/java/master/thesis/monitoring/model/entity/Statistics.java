package master.thesis.monitoring.model.entity;

import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

@Node
public class Statistics {

    @Id
    @GeneratedValue
    private Long id;

    @Relationship(type = "HAS_STATISTICS", direction = Relationship.Direction.INCOMING)
    private Device device;

    private Long sentAt;

    private Integer queueSize;

    private Integer minQueueOccupation;

    private Integer maxQueueOccupation;

    private Double averageQueueOccupation;

    private Double standardDeviationQueueOccupation;

    private Double varianceQueueOccupation;

    public Statistics() {
    }

    public Statistics(
            Device device,
            Long sentAt,
            Integer queueSize,
            Integer minQueueOccupation,
            Integer maxQueueOccupation,
            Double averageQueueOccupation,
            Double standardDeviationQueueOccupation,
            Double varianceQueueOccupation
    ) {
        this.device = device;
        this.sentAt = sentAt;
        this.queueSize = queueSize;
        this.minQueueOccupation = minQueueOccupation;
        this.maxQueueOccupation = maxQueueOccupation;
        this.averageQueueOccupation = averageQueueOccupation;
        this.standardDeviationQueueOccupation = standardDeviationQueueOccupation;
        this.varianceQueueOccupation = varianceQueueOccupation;
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
        return "Statistics{" +
                "id=" + id +
                ", device=" + device.getPort() +
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

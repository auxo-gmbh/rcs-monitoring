package master.thesis.monitoring.model.message;

import java.util.List;

public class GossipDiscoveryResponseEvent {


    private List<Integer> path;
    private Double averageQueueRatio;
    private Double averageResourcesRatio;

    public GossipDiscoveryResponseEvent() {
    }

    public GossipDiscoveryResponseEvent(List<Integer> path, Double averageQueueRatio, Double averageResourcesRatio) {
        this.path = path;
        this.averageQueueRatio = averageQueueRatio;
        this.averageResourcesRatio = averageResourcesRatio;
    }

    public List<Integer> getPath() {
        return path;
    }

    public void setPath(List<Integer> path) {
        this.path = path;
    }

    public Double getAverageQueueRatio() {
        return averageQueueRatio;
    }

    public void setAverageQueueRatio(Double averageQueueRatio) {
        this.averageQueueRatio = averageQueueRatio;
    }

    public Double getAverageResourcesRatio() {
        return averageResourcesRatio;
    }

    public void setAverageResourcesRatio(Double averageResourcesRatio) {
        this.averageResourcesRatio = averageResourcesRatio;
    }

    @Override
    public String toString() {
        return "GossipDiscoveryResponseEvent{" +
                "path=" + path +
                ", averageQueueRatio=" + averageQueueRatio +
                ", averageResourcesRatio=" + averageResourcesRatio +
                '}';
    }
}

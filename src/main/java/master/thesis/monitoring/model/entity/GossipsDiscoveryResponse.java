package master.thesis.monitoring.model.entity;

import master.thesis.monitoring.model.message.GossipDiscoveryResponseEvent;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;

import java.util.List;

@Node
public class GossipsDiscoveryResponse {

    @Id
    @GeneratedValue
    private Long id;

    private List<Integer> path;
    private Double averageQueueRatio;
    private Double averageResourcesRatio;

    public GossipsDiscoveryResponse() {
    }

    public GossipsDiscoveryResponse(List<Integer> path, Double averageQueueRatio, Double averageResourcesRatio) {
        this.path = path;
        this.averageQueueRatio = averageQueueRatio;
        this.averageResourcesRatio = averageResourcesRatio;
    }

    public GossipsDiscoveryResponse(GossipDiscoveryResponseEvent gossipDiscoveryResponseEvent) {
        this.path = gossipDiscoveryResponseEvent.getPath();
        this.averageQueueRatio = gossipDiscoveryResponseEvent.getAverageQueueRatio();
        this.averageResourcesRatio = gossipDiscoveryResponseEvent.getAverageResourcesRatio();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

package master.thesis.monitoring.service;

import org.springframework.data.neo4j.core.Neo4jClient;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class IndexService {

    private final Neo4jClient neo4jClient;

    public IndexService(Neo4jClient neo4jClient) {
        this.neo4jClient = neo4jClient;
    }

    @PostConstruct
    private void init() {
        createDeviceIndexOnPortAndLatest();
        createGossipsDiscoveryIndexOnRequestId();
    }

    private void createDeviceIndexOnPortAndLatest() {
        var cypher = "CREATE INDEX device_index IF NOT EXISTS " +
                "FOR (n:Device) " +
                "ON (n.port, n.latest)";
        neo4jClient.query(cypher).run();
    }

    private void createGossipsDiscoveryIndexOnRequestId() {
        var cypher = "CREATE INDEX gd_index IF NOT EXISTS " +
                "FOR (gd:GossipsDiscovery) " +
                "ON (gd.requestId)";
        neo4jClient.query(cypher).run();
    }
}

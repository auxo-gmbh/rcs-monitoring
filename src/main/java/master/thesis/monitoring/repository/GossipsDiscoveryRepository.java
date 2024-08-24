package master.thesis.monitoring.repository;

import master.thesis.monitoring.model.entity.GossipsDiscovery;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GossipsDiscoveryRepository extends Neo4jRepository<GossipsDiscovery, Long> {

    @Query( "MATCH (n:Device{port:$port,latest:TRUE}) " +
            "CREATE (n)-[r:DECIDED_ON]->(gd:GossipsDiscovery {requestId:$requestId, sentAt:$sentAt}) "
    )
    void saveGossipsDiscoveryEvent(
            Integer port,
            String requestId,
            Long sentAt
    );

    @Query( "MATCH (gd:GossipsDiscovery{requestId:$requestId}) " +
            "CREATE (gd)-[r:HAS_POSSIBILITIES]->(gdr:GossipsDiscoveryResponse {path:$path, averageQueueRatio:$averageQueueRatio, averageResourcesRatio:$averageResourcesRatio}) "
    )
    void saveGossipsDiscoveryResponseEvent(
            String requestId,
            List<Integer> path,
            Double averageQueueRatio,
            Double averageResourcesRatio
    );
}

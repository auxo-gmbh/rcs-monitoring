package master.thesis.monitoring.repository;

import master.thesis.monitoring.model.entity.Statistics;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface StatisticsRepository extends Neo4jRepository<Statistics, Long> {

    @Query("MATCH (n:Device{port:$port,latest:TRUE}) " +
            "CREATE (n)-[r:HAS_STATISTICS]->(s:Statistics {" +
            "sentAt:$sentAt, " +
            "queueSize:$queueSize, " +
            "minQueueOccupation:$minQueueOccupation, " +
            "maxQueueOccupation:$maxQueueOccupation, " +
            "averageQueueOccupation:$averageQueueOccupation, " +
            "standardDeviationQueueOccupation:$standardDeviationQueueOccupation, " +
            "varianceQueueOccupation:$varianceQueueOccupation " +
            "})"
    )
    void saveStatistics(
            Integer port,
            Long sentAt,
            Integer queueSize,
            Integer minQueueOccupation,
            Integer maxQueueOccupation,
            Double averageQueueOccupation,
            Double standardDeviationQueueOccupation,
            Double varianceQueueOccupation
    );

}

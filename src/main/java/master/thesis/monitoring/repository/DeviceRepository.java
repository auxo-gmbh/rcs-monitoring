package master.thesis.monitoring.repository;

import master.thesis.monitoring.model.entity.Device;
import master.thesis.monitoring.model.enums.DetailsType;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeviceRepository extends Neo4jRepository<Device, Long> {

    @Query(
            "MATCH (source:Device {port:$sourcePort, latest:TRUE}) " +
            "WITH source " +
            "MATCH (target:Device {port:$targetPort, latest:TRUE}) " +
            "WITH source,target " +
            "CREATE (source)-[r:CONNECTED_TO {openedConnectionAt:$openedConnectionAt}]->(target)"
    )
    void saveLinkBetweenDevices(Integer sourcePort, Integer targetPort, Long openedConnectionAt);

    @Query(
            "MATCH (source:Device{port:$sourcePort})-[r:CONNECTED_TO]->(target:Device{port:$targetPort}) " +
                    "WHERE r.closedConnectionAt IS NULL " +
                    "SET r.closedConnectionAt=$closedConnectionAt, r.fromSelfActualization=$fromSelfActualization"
    )
    void archiveLinkBetweenDevices(
            Integer sourcePort,
            Integer targetPort,
            Long closedConnectionAt,
            boolean fromSelfActualization
    );

    @Query(
            "MATCH (source:Device{port:$sourcePort, latest:TRUE})-[r:CONNECTED_TO]->(target:Device{port:$targetPort, latest:TRUE}) " +
            "CREATE (source)-[s:SENT_TO {" +
                    "requestId:$requestId, "+
                    "sentAt:$sentAt, " +
                    "taskType:$taskType, " +
                    "path:$path, " +
                    "details:$details, " +
                    "pheromonesEdges:$pheromonesEdges, " +
                    "qualityPheromones:$qualityPheromones, " +
                    "functionTime:$functionTime " +
                    "}]->(target)"
    )
    void saveMessageBetweenDevices(
            Integer sourcePort,
            Integer targetPort,
            String requestId,
            Long sentAt,
            String taskType,
            List<Integer> path,
            DetailsType details,
            String pheromonesEdges,
            Double qualityPheromones,
            Double functionTime
    );

    @Query(
            "MATCH (n:Device{port:$port,latest:TRUE}) " +
            "SET n.latest=FALSE"
    )
    void archiveDevice(Integer port);
}

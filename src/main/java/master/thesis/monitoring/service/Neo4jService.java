package master.thesis.monitoring.service;

import master.thesis.monitoring.model.entity.Device;
import master.thesis.monitoring.model.entity.Message;
import master.thesis.monitoring.model.message.*;
import master.thesis.monitoring.repository.DeviceRepository;
import master.thesis.monitoring.repository.GossipsDiscoveryRepository;
import master.thesis.monitoring.repository.StatisticsRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class Neo4jService {

    Logger logger = LoggerFactory.getLogger(Neo4jService.class);

    private final DeviceRepository deviceRepository;
    private final StatisticsRepository statisticsRepository;

    private final GossipsDiscoveryRepository gossipsDiscoveryRepository;

    public Neo4jService(
            DeviceRepository deviceRepository,
            StatisticsRepository statisticsRepository,
            GossipsDiscoveryRepository gossipsDiscoveryRepository
    ) {
        this.deviceRepository = deviceRepository;
        this.statisticsRepository = statisticsRepository;
        this.gossipsDiscoveryRepository = gossipsDiscoveryRepository;
    }


    public void saveDevice(DeviceEvent deviceEvent) {
        var sourcePort = deviceEvent.getSourcePort();
        var sentAt = deviceEvent.getSentAt();
        var taskType = deviceEvent.getTaskTypes();

        deviceRepository.archiveDevice(sourcePort);

        var device = new Device(sourcePort, sentAt, taskType, true);
        var savedDevice = deviceRepository.save(device);
        logger.info("Saved {}", savedDevice);
    }

    public void saveLinkToPort(LinkEvent linkEvent) {
        var sourcePort = linkEvent.getSourcePort();
        var targetPort = linkEvent.getTargetPort();

        deviceRepository.saveLinkBetweenDevices(
                sourcePort,
                targetPort,
                linkEvent.getOpenedConnectionAt()
        );
        logger.info("Saved link {} <-> {}", sourcePort, targetPort);
    }

    public void archiveLinkToPort(LinkEvent linkEvent) {
        var sourcePort = linkEvent.getSourcePort();
        var targetPort = linkEvent.getTargetPort();
        var closedConnection = linkEvent.getClosedConnectionAt();
        var fromSelfActualization = linkEvent.getFromSelfActualization();
        var selfActualizationLogging = fromSelfActualization ? " by self-actualization" : "";

        deviceRepository.archiveLinkBetweenDevices(sourcePort, targetPort, closedConnection, fromSelfActualization);
        logger.info("Archived links{} {} <-> {}", selfActualizationLogging, sourcePort, targetPort);
        deviceRepository.archiveLinkBetweenDevices(targetPort, sourcePort, closedConnection, fromSelfActualization);
        logger.info("Archived links{} {} <-> {}", selfActualizationLogging, targetPort, sourcePort);
    }

    public void saveMessage(MessagingEvent messagingEvent) {
        deviceRepository.saveMessageBetweenDevices(
                messagingEvent.getSourcePort(),
                messagingEvent.getTargetPort(),
                messagingEvent.getRequestId(),
                messagingEvent.getSentAt(),
                messagingEvent.getTaskType(),
                messagingEvent.getPath(),
                messagingEvent.getDetails(),
                Message.mapToString(messagingEvent.getPheromonesEdges()),
                messagingEvent.getQualityPheromones(),
                messagingEvent.getFunctionTime()
        );
        logger.info("Added {}", messagingEvent);
    }

    public void saveQueueStatistics(QueueEvent queueEvent) {
        statisticsRepository.saveStatistics(
                queueEvent.getSourcePort(),
                queueEvent.getSentAt(),
                queueEvent.getQueueSize(),
                queueEvent.getMinQueueOccupation(),
                queueEvent.getMaxQueueOccupation(),
                queueEvent.getAverageQueueOccupation(),
                queueEvent.getStandardDeviationQueueOccupation(),
                queueEvent.getVarianceQueueOccupation()
        );
        logger.info("Saved {}", queueEvent);
    }

    public void saveGossipsDiscoveryEvent(GossipsDiscoveryEvent gossipsDiscoveryEvent) {
        var requestId = gossipsDiscoveryEvent.getRequestId();
        gossipsDiscoveryRepository.saveGossipsDiscoveryEvent(
                gossipsDiscoveryEvent.getSourcePort(),
                gossipsDiscoveryEvent.getRequestId(),
                gossipsDiscoveryEvent.getSentAt()
        );
        gossipsDiscoveryEvent
                .getResponses()
                .forEach(response ->
                        gossipsDiscoveryRepository.saveGossipsDiscoveryResponseEvent(
                                requestId,
                                response.getPath(),
                                response.getAverageQueueRatio(),
                                response.getAverageResourcesRatio()
                        ));
        logger.info("Saved {}", gossipsDiscoveryEvent);
    }
}

package master.thesis.monitoring.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import master.thesis.monitoring.model.message.*;
import master.thesis.monitoring.service.Neo4jService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class MonitoringApi {

    Logger logger = LoggerFactory.getLogger(Neo4jService.class);

    private final Neo4jService neo4jService;
    private final ObjectMapper objectMapper;

    public MonitoringApi(Neo4jService neo4jService) {
        this.neo4jService = neo4jService;
        this.objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    @RabbitListener(queues = "monitoring-queue")
    public void receive(String eventMessage) throws JsonProcessingException {

        var event = objectMapper.readValue(eventMessage, Event.class);
        switch (event.getEventType()) {
            case DEVICE_EVENT:
                saveDevice(eventMessage);
                break;
            case ADD_LINK_EVENT:
                saveLinkToPort(eventMessage);
                break;
            case ARCHIVE_LINK_EVENT:
                archiveLinkToPort(eventMessage);
                break;
            case MESSAGING_EVENT:
                saveMessage(eventMessage);
                break;
            case QUEUE_EVENT:
                saveQueueStatistics(eventMessage);
                break;
            case GOSSIPS_DISCOVERY_EVENT:
                saveGossipsDiscovery(eventMessage);
                break;
        }
    }

    private void saveDevice(String event) throws JsonProcessingException {
        var deviceEvent = objectMapper.readValue(event, DeviceEvent.class);
        neo4jService.saveDevice(deviceEvent);
    }

    private void saveLinkToPort(String event) throws JsonProcessingException {
        var linkEvent = objectMapper.readValue(event, LinkEvent.class);
        neo4jService.saveLinkToPort(linkEvent);
    }

    private void archiveLinkToPort(String event) throws JsonProcessingException {
        var linkEvent = objectMapper.readValue(event, LinkEvent.class);
        neo4jService.archiveLinkToPort(linkEvent);
    }

    private void saveMessage(String event) throws JsonProcessingException {
        var messagingEvent = objectMapper.readValue(event, MessagingEvent.class);
        neo4jService.saveMessage(messagingEvent);
    }

    private void saveQueueStatistics(String event) throws JsonProcessingException {
        var queueEvent = objectMapper.readValue(event, QueueEvent.class);
        neo4jService.saveQueueStatistics(queueEvent);
    }

    private void saveGossipsDiscovery(String event) throws JsonProcessingException {
        var gossipsDiscoveryEvent = objectMapper.readValue(event, GossipsDiscoveryEvent.class);
        neo4jService.saveGossipsDiscoveryEvent(gossipsDiscoveryEvent);
    }
}

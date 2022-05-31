package br.com.example.kafka.producer.service;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class KafkaProducerService {

  @Autowired
  private KafkaTemplate<String, String> kafkaTemplate;

  @Value("${spring.kafka.producer.topic}")
  private String kafkaTopic;

  public void send(String message) {
    log.info("Sending message Json Serializer : {}", message);
    kafkaTemplate.send(kafkaTopic, message);
  }
}

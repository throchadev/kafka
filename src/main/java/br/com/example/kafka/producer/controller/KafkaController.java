package br.com.example.kafka.producer.controller;

import br.com.example.kafka.producer.service.KafkaProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/producer-kafka/")
public class KafkaController {

  @Autowired
  KafkaProducerService kafkaProducer;

  @PostMapping("/send")
  public String sendMessage(@RequestBody String message){
    kafkaProducer.send(message);
    return "Message sent successfully!!";
  }
}

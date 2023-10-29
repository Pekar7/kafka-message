package com.example.kafkamicro;

import com.example.kafkamicro.service.KafkaMessageListener;
import com.example.kafkamicro.service.KafkaMessageProducer;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@SecurityRequirement(name = "javainuseapi")
public class KafkaController {

    private final KafkaMessageProducer kafkaMessageProducer;
    private final KafkaMessageListener kafkaMessageConsumer;

    @Autowired
    public KafkaController(KafkaMessageProducer kafkaMessageProducer, KafkaMessageListener kafkaMessageConsumer) {
        this.kafkaMessageProducer = kafkaMessageProducer;
        this.kafkaMessageConsumer = kafkaMessageConsumer;
    }

    @GetMapping("/data")
    public ResponseEntity<String> getSecureData() {
        return ResponseEntity.ok("This is secure data");
    }
}

package com.example.SpringKafka.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.SpringKafka.Service.KafkaPublisher;

@RestController
@RequestMapping("/producer-app")
public class KafkaController {

	@Autowired
	private KafkaPublisher publisher;

	@GetMapping("/publish/{p_message}")
	public ResponseEntity publishMessage( @PathVariable final String p_message ){
		try {
			publisher.sendMessageToTopics( p_message );
			return ResponseEntity.status( HttpStatus.OK ).build();
		} catch ( final Exception p_exception ){
			return ResponseEntity.status( HttpStatus.INTERNAL_SERVER_ERROR ).body( "Message"+p_exception.getMessage() );
		}
	}

}

package com.example.SpringKafka.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {
	 Logger log =LoggerFactory.getLogger( KafkaConsumer.class );

	@KafkaListener( topics = "SpringKafka-topic", groupId = "console-consumer-70832" )
	public void consumerListner( final String p_message){
		log.info( "Consumer Message {}",p_message );
	 }
}

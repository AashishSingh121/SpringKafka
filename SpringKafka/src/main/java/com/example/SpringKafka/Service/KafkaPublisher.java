package com.example.SpringKafka.Service;

import java.util.concurrent.CompletableFuture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

@Service
public class KafkaPublisher {

	@Autowired
	private KafkaTemplate<String,Object> template;

	public void sendMessageToTopics( final String message){
		final CompletableFuture<SendResult<String, Object>> l_future = template.send( "SpringKafka-topic", message );
		l_future.whenComplete( (result,ex)->{
			if(ex ==null){
				System.out.println("Sent message=["+ message + "] with offset=["
				+ result.getRecordMetadata().offset() + "]");
			}
			else {
				System.out.println("Unable to send message =[" + message+ "] due to: "+
								   ex.getMessage());
			}
		});
	}
}

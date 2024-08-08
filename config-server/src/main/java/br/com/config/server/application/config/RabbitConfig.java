package br.com.config.server.application.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.StdDateFormat;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

//@EnableRabbit
@Configuration
public class RabbitConfig {

	@Value("rabbitmq.queue.name")
	private String queueName;
	
	@Value("rabbitmq.exchange.name")
	private String exchangeName;
	
	@Value("rabbitmq.binding.key")
	private String bindingKey;
	
//	@Bean
//    Queue queue() {
//        return new Queue(queueName, false);
//    }
//
//    @Bean
//    TopicExchange exchange() {
//        return new TopicExchange(exchangeName);
//    }
//
//    @Bean
//    Binding binding(Queue queue, TopicExchange exchange) {
//        return BindingBuilder.bind(queue).to(exchange).with("config-server-routing-key");
//    }
	
	@Bean
	RabbitTemplate rabbitTemplateConfig(ConnectionFactory connectionFactory, Jackson2JsonMessageConverter converter) {
		RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
		rabbitTemplate.setMessageConverter(converter);
		return rabbitTemplate;
		
	}
	
	@Bean
    Jackson2JsonMessageConverter jsonMessageConverterConfig(ObjectMapper objectMapper) {
        return new Jackson2JsonMessageConverter(objectMapper);
    }
    
	@Bean
    ObjectMapper objectMapperConfig() {
		return Jackson2ObjectMapperBuilder.json()
				.modules(new JavaTimeModule())
				.dateFormat(new StdDateFormat())
				.build();
    	
    }
	
}

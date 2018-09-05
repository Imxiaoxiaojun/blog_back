package com.sm.blog.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: zhuyajun02@maoyan.com
 * Date: 2018-09-05
 * Time: 上午11:07
 */
@Configuration
public class RabbitConfig {
    public static final String EXCHANGE_NAME = "test";
    public static final String EXCHANGE_NAME2 = "test2";
    public static final String TOPIC_EXCHANGE = "topicExchange";
    @Bean
    public Queue test(){
        return new Queue(EXCHANGE_NAME);
    }
    @Bean
    public Queue test2(){
        return new Queue(EXCHANGE_NAME2);
    }
    @Bean
    public TopicExchange exchange(){
        return new TopicExchange(TOPIC_EXCHANGE);
    }
    @Bean
    Binding bindTest(Queue test, TopicExchange exchange){
        return BindingBuilder.bind(test).to(exchange).with(EXCHANGE_NAME);
    }
    @Bean
    Binding bindTest2(Queue test2, TopicExchange exchange){
        return BindingBuilder.bind(test2).to(exchange).with(EXCHANGE_NAME2 + ".#");
    }
}

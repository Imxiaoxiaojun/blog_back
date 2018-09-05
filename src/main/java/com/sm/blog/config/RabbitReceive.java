package com.sm.blog.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.utils.SerializationUtils;
import org.springframework.stereotype.Component;


/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: zhuyajun02@maoyan.com
 * Date: 2018-09-05
 * Time: 上午11:31
 */
@Component
public class RabbitReceive {
    private static Logger logger = LoggerFactory.getLogger(RabbitReceive.class);

    @RabbitListener(queues = "test")
    public void test(Message message) {
        logger.info("test:" + getMessageBody(message));
    }

    @RabbitListener(queues = "test2")
    public void test2(Message message) {
        logger.info("test2:" + getMessageBody(message));
    }

    private String getMessageBody(Message message) {
        String content = "";
        try {
            byte[] body = message.getBody();
            MessageProperties messageProperties = message.getMessageProperties();

            if (body != null) {
                String contentType = messageProperties != null ? messageProperties.getContentType() : null;
                if ("application/x-java-serialized-object".equals(contentType)) {
                    content = SerializationUtils.deserialize(body).toString();
                }

                if ("text/plain".equals(contentType) || "application/json".equals(contentType) || "text/x-json".equals(contentType) || "application/xml".equals(contentType)) {
                    content = new String(body, "utf-8");
                }
            }
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        return content;
    }

}

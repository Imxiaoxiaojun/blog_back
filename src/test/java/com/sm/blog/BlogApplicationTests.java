package com.sm.blog;

import com.sm.blog.model.Tag;
import com.sm.blog.service.ITagService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BlogApplicationTests {
	@Autowired
	private RabbitTemplate rabbitTemplate;
	@Autowired
	private ITagService tagService;
	@Test
	public void contextLoads() {
		Tag tag = tagService.selectById(55L);
		rabbitTemplate.convertAndSend("topicExchange","test2",tag);
	}

}

package com.appro.google.protobufjava;

import com.appro.google.protobufjava.generated.SpaceStation;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.assertTrue;


@DirtiesContext
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = ProtobufJavaApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ProtobufJavaApplicationTests {

	private static final String SpaceStation_url = "http://localhost:8080/courses/1";

	@Autowired
	private RestTemplate restTemplate;

	@LocalServerPort
	private int port;

	@Test
	public void whenUsingRestTemplate_thenSucceed() {
		ResponseEntity<SpaceStation> course = restTemplate.getForEntity(SpaceStation_url, SpaceStation.class);
		assertResponse(course.toString());
	}

	private void assertResponse(String response) {
		assertTrue(response.contains("id"));
		assertTrue(response.contains("captain name"));
	}
}

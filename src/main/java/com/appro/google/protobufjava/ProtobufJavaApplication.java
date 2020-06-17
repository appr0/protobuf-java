package com.appro.google.protobufjava;

import com.appro.google.protobufjava.generated.Captain;
import com.appro.google.protobufjava.generated.SpaceShip;
import com.appro.google.protobufjava.generated.SpaceStation;
import com.appro.google.protobufjava.repos.SpaceStationRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.protobuf.ProtobufHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class ProtobufJavaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProtobufJavaApplication.class, args);
	}

	@Bean
	ProtobufHttpMessageConverter protobufHttpMessageConverter() {
		return new ProtobufHttpMessageConverter();
	}

	@Bean
	RestTemplate restTemplate(ProtobufHttpMessageConverter hmc) {
		return new RestTemplate(Arrays.asList(hmc));
	}
	@Bean
	public SpaceStationRepository  createTestStations() {
		Map<Integer, SpaceStation> spaceStations = new HashMap<>();
		SpaceStation spaceStation1 = SpaceStation.newBuilder()
				.addSpaceships(ship("Hawk"))
				.addSpaceships(ship("Seagul"))
				.setCaptain(createCaptain("Appro")).build();
		SpaceStation spaceStation2 = SpaceStation.newBuilder()
				.addSpaceships(ship("Radiant"))
				.addSpaceships(ship("Dire"))
				.setCaptain(createCaptain("Michiaki"))
				.build();
		spaceStations.put(1, spaceStation1);
		spaceStations.put(2, spaceStation2);
		return new SpaceStationRepository(spaceStations);
	}

	Captain createCaptain(String name) {
		Captain.Builder builder = Captain.newBuilder();
		Captain captain = builder
				.setName(name)
				.setRace(Captain.RaceType.SMALL_ROUND)
				.build();
		return captain;
	}

	SpaceShip ship(String name){
		return SpaceShip.newBuilder()
				.setName(name)
				.setCrew(10)
				.setCargo("Robot parts").build();
	}
	// Other declarations
}

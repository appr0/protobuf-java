package com.appro.google.protobufjava.controller;

import com.appro.google.protobufjava.generated.AddressBookProtos;
import com.appro.google.protobufjava.generated.SpaceStation;
import com.appro.google.protobufjava.repos.SpaceStationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

@RestController
public class SpaceStationController {

        @Autowired
        SpaceStationRepository spaceRepo;

        @Autowired
        RestTemplate restTemplate;

        private static final String COURSE1_URL = "http://localhost:8080/stations/1";

        @RequestMapping("/stations/{id}")
        SpaceStation customer(@PathVariable Integer id) {
            return spaceRepo.getStation(id);
        }

        @RequestMapping("test")
        void test(){
                ResponseEntity<SpaceStation> course = restTemplate.getForEntity(COURSE1_URL, SpaceStation.class);
        }

        @RequestMapping("/addressBooks")
        AddressBookProtos.AddressBook getBooks() throws FileNotFoundException,IOException{
                AddressBookProtos.AddressBook addressBook =
                        AddressBookProtos.AddressBook.parseFrom(new FileInputStream("a.txt"));
                return addressBook;
        }
}

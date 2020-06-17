package com.appro.google.protobufjava.repos;

import com.appro.google.protobufjava.generated.SpaceStation;

import java.util.Map;

public class SpaceStationRepository {
    Map<Integer, SpaceStation> spaceStations;

    public SpaceStationRepository(Map<Integer, SpaceStation> spaceStations) {
        this.spaceStations = spaceStations;
    }

    public Map<Integer, SpaceStation> getSpaceStations() {
        return spaceStations;
    }

    public void setSpaceStations(Map<Integer, SpaceStation> spaceStations) {
        this.spaceStations = spaceStations;
    }

    public SpaceStation getStation(Integer id){
        return spaceStations.get(id);
    }
}

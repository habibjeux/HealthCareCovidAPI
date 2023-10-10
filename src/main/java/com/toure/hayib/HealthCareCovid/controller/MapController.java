package com.toure.hayib.HealthCareCovid.controller;

import com.toure.hayib.HealthCareCovid.model.Map;
import com.toure.hayib.HealthCareCovid.service.MapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class MapController {
    @Autowired
    private MapService mapService;

    @PostMapping("map")
    public ResponseEntity<Object> createMap(@RequestBody Map map) {
        if(mapService.mapExists(map))
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Map already exists.");
        return ResponseEntity.status(HttpStatus.CREATED).body(mapService.createMap(map));
    }

    @GetMapping("maps")
    public List<Map> getAllMaps() {
        return mapService.getAllMaps();
    }
    @GetMapping("map/{id}")
    public Optional<Map> getMapById(@PathVariable Long id) {
        return mapService.getMapById(id);
    }
    @PutMapping("map/{id}")
    public ResponseEntity<Object> updateMap(@PathVariable Long id, @RequestBody Map newMap) {
        if(mapService.mapExists(newMap))
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Map already exists.");
        return ResponseEntity.status(HttpStatus.OK).body(mapService.updateMap(id, newMap));
    }
    @DeleteMapping("maps")
    public String deleteAllMaps() {
        mapService.deleteAllMaps();
        return "All maps have been deleted successfully.";
    }

    @DeleteMapping("map/{id}")
    public void deleteMapById(@PathVariable Long id) {
        mapService.deleteMapById(id);
    }
}

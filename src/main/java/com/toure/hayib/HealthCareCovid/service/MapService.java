package com.toure.hayib.HealthCareCovid.service;

import com.toure.hayib.HealthCareCovid.model.Map;
import com.toure.hayib.HealthCareCovid.repository.MapRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class MapService {
    @Autowired
    private MapRepository mapRepository;

    public boolean mapExists(Map map) {
        Iterable<Map> existingMaps = mapRepository.findAll();
        for (Map existingMap : existingMaps) {
            if (existingMap.getLongitude().equals(map.getLongitude())
                    && existingMap.getLatitude().equals(map.getLatitude()))
                return true;
        }
        return false;
    }

    public Map createMap(Map map) {
        return mapRepository.save(map);
    }

    public List<Map> getAllMaps() {
        List<Map> maps = new ArrayList<>();
        mapRepository.findAll().forEach(maps::add);
        return maps;
    }

    public Optional<Map> getMapById(Long id) {
        return mapRepository.findById(id);
    }

    public Map updateMap(Long id, Map newMap) {
        Optional<Map> map = mapRepository.findById(id);
        if(map.isPresent()) {
            Map existingMap = map.get();
            existingMap.setLatitude(newMap.getLatitude());
            existingMap.setLongitude(newMap.getLongitude());
            return mapRepository.save(existingMap);
        }
        return null;
    }

    public void deleteAllMaps() {
        mapRepository.deleteAll();
    }

    public void deleteMapById(Long id) {
        mapRepository.deleteById(id);
    }
}

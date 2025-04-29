package com.house.house.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.house.house.entity.House;
import com.house.house.repo.HouseRepo;

@Service
public class HouseService {
    
    private HouseRepo houseRepo;

    @Autowired
    public HouseService(HouseRepo houseRepo){
        this.houseRepo = houseRepo;
    }

    public List<House> getAllHouses(){
        return houseRepo.findAll();
    }

    public House saveHouse(House house){
        return houseRepo.save(house);
    }
    
    public House updateHouse(Integer id, House house) {
        Optional<House> existingHouse = houseRepo.findById(id);
        
        if (existingHouse.isPresent()) {
            House houseToUpdate = existingHouse.get();
            
            // Update only non-null fields
            if (house.getCity() != null) {
                houseToUpdate.setCity(house.getCity());
            }
            if (house.getStreet() != null) {
                houseToUpdate.setStreet(house.getStreet());
            }
            if (house.getType() != null) {
                houseToUpdate.setType(house.getType());
            }
            
            return houseRepo.save(houseToUpdate);
        }
        
        return null;
    }
    
    public boolean deleteHouse(Integer id) {
        if (houseRepo.existsById(id)) {
            houseRepo.deleteById(id);
            return true;
        }
        return false;
    }
}

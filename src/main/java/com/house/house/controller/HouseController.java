package  com.house.house.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import  com.house.house.entity.House;
import  com.house.house.service.HouseService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api")
public class HouseController {

    private HouseService houseService;

    @Autowired
    public HouseController(HouseService houseService){
        this.houseService = houseService;
    }

    @GetMapping("/house")
    public List<House> getAllHouses() {
        return houseService.getAllHouses();
    }

    @PostMapping("/house")
    public House saveHouse(@RequestBody House house){
        return houseService.saveHouse(house);
    }
    
    @PatchMapping("/house/{id}")
    public ResponseEntity<House> updateHouse(@PathVariable Integer id, @RequestBody House house) {
        House updatedHouse = houseService.updateHouse(id, house);
        return updatedHouse != null ? ResponseEntity.ok(updatedHouse) : ResponseEntity.notFound().build();
    }
    
    @DeleteMapping("/house/{id}")
    public ResponseEntity<Void> deleteHouse(@PathVariable Integer id) {
        boolean deleted = houseService.deleteHouse(id);
        return deleted ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }
    

    // @RequestMapping("/house")
    // public String getHouse(){
    //     return "Hello world";
    // }
    
}

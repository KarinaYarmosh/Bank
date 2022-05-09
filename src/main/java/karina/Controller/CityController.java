package karina.Controller;

import karina.Entity.City;
import karina.Repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CityController {

    @Autowired
    private CityRepository cityRepository;

    @GetMapping("/cities")
    public List<City> getCities(){
        List<City> cities = cityRepository.findAll();
        return cities;
    }

    @GetMapping("/cities/{id}")
    public City getCitiesById(@PathVariable Long id){
        City city = cityRepository.findById(id).get();
        return city;
    }

    @DeleteMapping("/cities/{id}")
    public String deleteCity(@PathVariable Long id){
        City city = cityRepository.findById(id).get();
        if(city == null){
            return "City with id = "+id+" was not found .";
        }
        String name = city.getName();
        cityRepository.deleteById(id);
        return "City "+name+" was deleted .";
    }

    @PostMapping("/cities")
    public String addCity(@RequestBody City city){
        City city2 = new City();
        city2.setBanks(city.getBanks());
        city2.setName(city.getName());
        cityRepository.save(city2);
        return "City "+city.getName()+" was added .";
    }

    @PutMapping("/cities/{id}")
    public City updateCity(@RequestBody City city){
        City city2 = new City();
        city2.setBanks(city.getBanks());
        city2.setName(city.getName());
        city2.setId(city.getId());
        return cityRepository.save(city);
    }
}

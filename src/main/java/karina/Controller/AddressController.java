package karina.Controller;

import karina.Entity.Address;
import karina.Entity.City;
import karina.Repository.AddressRepository;
import karina.Repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AddressController {

    @Autowired
    private AddressRepository addressRepository;

    @GetMapping("/address")
    public List<Address> getAddress(){
        List<Address> addresses = addressRepository.findAll();
        return addresses;
    }

    @GetMapping("/address/{id}")
    public Address getAddressById(@PathVariable Long id){
        Address address = addressRepository.findById(id).get();
        return address;
    }

    @DeleteMapping("/addresses/{id}")
    public String deleteAddress(@PathVariable Long id){
        Address address = addressRepository.findById(id).get();
        if(address == null){
            return "Address = "+address+" was not found .";
        }
        addressRepository.deleteById(id);
        return "Address "+address+" was deleted .";
    }

//    @PostMapping("/addresses")
//    public String addAddress(@RequestBody Address address){
//        Address address2 = new Address();
////        address2.setClients(address.getClients());
//        address2.setStreet(address.getStreet());
//        addressRepository.save(address2);
//        return "City "+city.getName()+" was added .";
//    }

//    @PutMapping("/addresses/{id}")
//    public City updateCity(@RequestBody City city){
//        City city2 = new City();
//        city2.setBanks(city.getBanks());
//        city2.setName(city.getName());
//        city2.setId(city.getId());
//        return cityRepository.save(city);
//    }
}

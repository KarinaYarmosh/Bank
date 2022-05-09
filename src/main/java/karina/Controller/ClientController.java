package karina.Controller;

import karina.Entity.Client;
import karina.Repository.ClientRepository;
import karina.Service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ClientController {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private ClientService clientService;

    @GetMapping("/clients")
    public List<Client> getAllPage(  @RequestParam(defaultValue = "0") int page,
                                     @RequestParam(defaultValue = "4") int size
    ){
        Pageable paging = PageRequest.of(page, size);
        Page<Client> clientPage;
        clientPage = clientRepository.findAll(paging);
        List<Client> clients = clientPage.getContent();
        return clients;
    }

    @GetMapping("/clients/firstname/{firstName}")
    public List<Client> getClientsByFirstName(@PathVariable String firstName){
        List<Client> clients = clientService.findClientByFirstName(firstName);
        return clients;
    }

    @GetMapping("/clients/pesel/{pesel}")
    public Client getClientByPesel(@PathVariable Long pesel){
        Client clients = clientService.findClientByPesel(pesel);
        return clients;
    }


//    @GetMapping("/client/{id}")
//    public Client getClientById(@PathVariable String first_name){
//        return ClientRepository.findByFirstName(first_name).get();
//    }

//    @DeleteMapping("/client/{pesel}")
//    public String deleteClient(@PathVariable Long pesel){
//        Client client = clientRepository.findByPesel(pesel).get();
//        if(client == null){
//            return "Client with id = "+pesel+" was not found .";
//        }
//        //String name = client.getFirstName();
//        clientRepository.deleteByPesel(pesel);
//        return "Client with pesel: "+pesel+" was deleted .";
//    }

    @PostMapping("/client")
    public String addCity(@RequestBody Client client){
        Client client2 = new Client();
        client2.setAddress(client.getAddress());
        client2.setFirstName(client.getFirstName());
        clientRepository.save(client2);
        return "City "+client.getFirstName()+" was added .";
    }

    @PutMapping("/client/{id}")
    public Client updateCity(@RequestBody Client client){
        Client client2 = new Client();
        client2.setAddress(client.getAddress());
        client2.setFirstName(client.getFirstName());;
        client2.setId(client.getId());
        return clientRepository.save(client);
    }
}

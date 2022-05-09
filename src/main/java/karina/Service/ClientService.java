package karina.Service;

import karina.Entity.Client;
import karina.Repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public List<Client> findClientByFirstName (String firstName){
        List<Client> clients = clientRepository.findClientByFirstName(firstName);
        return clients;
    }

    public Client findClientByPesel (Long pesel){
        Client clients = clientRepository.findByPesel(pesel);
        return clients;
    }

}

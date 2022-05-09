package karina.Repository;

import karina.Entity.Client;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientRepository extends PagingAndSortingRepository<Client,Long> {

    Page<Client> findAll(Pageable pageable);

    List<Client> findClientByFirstName(String firstName);

    Client findByPesel(Long pesel);

    Client deleteByPesel(Long pesel);
}

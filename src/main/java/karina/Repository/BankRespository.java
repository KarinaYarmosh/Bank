package karina.Repository;

import karina.Entity.Bank;
import karina.Entity.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BankRespository extends JpaRepository <Bank,Long> {

    @Query("SELECT b FROM Bank b WHERE b.numberOfBranches > ?1")
    List<Bank> getBanksByNumberOfBranches(Long branch);

    List<Bank> getBankByName(String name);
}

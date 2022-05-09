package karina.Repository;

import karina.Entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<Account,Long> {

    @Query("SELECT b FROM Account b WHERE b.money > ?1")
    List<Account> getAccountByMoney(Long money);
}

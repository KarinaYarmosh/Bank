package karina.Service;

import karina.Entity.Account;
import karina.Repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    public List<Account> getAccountByMoney(Long money){
        List<Account> accounts = accountRepository.getAccountByMoney(money);
        return accounts;
    }
}

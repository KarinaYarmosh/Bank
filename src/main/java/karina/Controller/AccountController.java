package karina.Controller;

import karina.Entity.Account;
import karina.Service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AccountController {

    @Autowired
    private AccountService accountService;

    @GetMapping("/accounts/money/{amount}")
    public List<Account> getAccountByMoney(@PathVariable Long amount){
        List<Account> accounts = accountService.getAccountByMoney(amount);
        return accounts;
    }
}

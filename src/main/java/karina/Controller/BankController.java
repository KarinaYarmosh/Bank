package karina.Controller;

import karina.Entity.Bank;
import karina.Service.BankService;
import karina.Repository.BankRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BankController {

    @Autowired
    private BankService bankService;

    @GetMapping("/banks")
    public List<Bank> getAllBanks(){
        List<Bank> banks = bankService.getAllBanks();
        return banks;
    }

    @GetMapping("/banks/branches/{branch}")
    public List<Bank> getAllBanksByBranches(@PathVariable Long branch){
        List<Bank> banks = bankService.getBanksByNumberOfBranches(branch);
        return banks;
    }


//    @DeleteMapping("/banks/{id}")
//    public String deleteBank(@PathVariable Long id){
//        Bank bank = bankService.findById(id).get();
//        if(bank == null){
//            return "City with id = "+id+" was not found .";
//        }
//        String name = bank.getName();
//        bankRespository.deleteById(id);
//        return "City "+name+" was deleted .";
//    }

//    @PostMapping("/cities")
//    public String addBank(@RequestBody Bank bank){
//        Bank bank2 = new Bank();
//        bank2.setCities(bank.getCities());
//        bank2.setName(bank.getName());
//        bankService.save(bank2);
//        return "City "+bank.getName()+" was added .";
//    }

//    @PutMapping("/cities/{id}")
//    public Bank updateCity(@RequestBody Bank bank){
//        Bank bank2 = new Bank();
//        bank2.setCities(bank.getCities());
//        bank2.setName(bank.getName());
//        bank2.setId(bank.getId());
//        Bank save = bankService.save(bank);
//        return save;
//    }
}

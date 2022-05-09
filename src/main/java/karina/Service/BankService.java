package karina.Service;

import karina.Entity.Bank;
import karina.Repository.BankRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class BankService {

    @Autowired
    private BankRespository bankRespository;

    public List<Bank> getAllBanks(){
        List<Bank> banks = bankRespository.findAll();
        return banks;
    }

    public List<Bank> getBanksByNumberOfBranches(Long branch){
        List<Bank> banks = bankRespository.getBanksByNumberOfBranches(branch);
        return banks;
    }

    public List<Bank> getBankByName(String name){
        List<Bank> banks = bankRespository.getBankByName(name);
        return banks;
    }
}

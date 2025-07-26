package com.project.banking.impl;


import com.project.banking.dto.AccountDto;
import com.project.banking.entity.Account;
import com.project.banking.mapper.AccountMapper;
import com.project.banking.repository.AccountRepository;
import com.project.banking.service.AccountService;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {
    private AccountRepository accountRepository;

    public AccountServiceImpl (AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }
    @Override
    public AccountDto createAccount(AccountDto accountDto){
        Account account = AccountMapper.mapToAccount(accountDto);
        Account savedAccount=accountRepository.save(account);
        return AccountMapper.mapToAccountDto(savedAccount);
    }

    @Override
    public AccountDto getAccountById(Long id) {
        Account account=accountRepository.findById(id).orElseThrow(() -> new RuntimeException("Account not found with id: " + id));
        return AccountMapper.mapToAccountDto(account);
    }

    @Override
    public AccountDto deposit(Long id, double amount) {
        Account account=accountRepository.findById(id).orElseThrow(() -> new RuntimeException("Account not found with id: " + id));
        Double total=account.getBalance() +amount;
        account.setBalance(total);
        Account saveAccount = accountRepository.save(account);
        return AccountMapper.mapToAccountDto(saveAccount);
    }

}

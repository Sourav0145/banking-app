package com.project.banking.service;

import com.project.banking.dto.AccountDto;
import com.project.banking.entity.Account;

public interface AccountService {
    AccountDto createAccount(AccountDto accountDto);

    AccountDto getAccountById(Long id);
}

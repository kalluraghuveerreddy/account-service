package com.photon.accountmanagementservice.service;

import com.photon.accountmanagementservice.dto.AccountDto;
import com.photon.accountmanagementservice.entity.Account;
import com.photon.accountmanagementservice.repository.AccountRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class AccountServiceImpl implements AccountService {

    private AccountRepository accountRepository;

    @Override
    public Mono<AccountDto> createAccount(AccountDto accountDto) {
        Account accounts = new Account(
                accountDto.getId(),
                accountDto.getName(),
                accountDto.getUsername(),
                accountDto.getEmail(),
                accountDto.getMobile(),
                accountDto.getPassword());
        Mono<Account> accountMono = accountRepository.save(accounts);
        return accountMono.map(account -> new AccountDto(account.getId(), account.getName(), account.getEmail(), account.getUsername(),
                account.getMobile(), account.getPassword()));
    }

    @Override
    public Flux<AccountDto> getAccountDetails() {

        return accountRepository.findAll().map(account -> new AccountDto(account.getId(), account.getName(), account.getEmail(), account.getUsername(),
                account.getMobile(), account.getPassword()));
    }

    @Override
    public Mono<Void> deleteAccount(Integer id) {
        accountRepository.deleteById(id);
        return Mono.empty();
    }

    @Override
    public Mono<AccountDto> updateAccount(Integer id, AccountDto accountDto) {
        return null;
    }
}

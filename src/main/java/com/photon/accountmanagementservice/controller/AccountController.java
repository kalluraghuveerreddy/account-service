package com.photon.accountmanagementservice.controller;

import com.photon.accountmanagementservice.dto.AccountDto;
import com.photon.accountmanagementservice.service.AccountService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/accounts")
@AllArgsConstructor
public class AccountController {

    private final AccountService accountService;

    @PostMapping
    public Mono<AccountDto> createAccount(@RequestBody AccountDto accountDto) {
        return accountService.createAccount(accountDto);
    }

    @GetMapping("/getAllAccounts")
    public Flux<AccountDto> getAccounts() {
        return accountService.getAccountDetails();
    }

    @DeleteMapping("{id}")
    public Mono<Void> deleteAccount(@PathVariable Integer id) {
        return accountService.deleteAccount(id);
    }
}

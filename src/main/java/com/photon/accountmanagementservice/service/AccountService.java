package com.photon.accountmanagementservice.service;

import com.photon.accountmanagementservice.dto.AccountDto;
import org.flywaydb.core.api.configuration.FluentConfiguration;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface AccountService {

    Mono<AccountDto> createAccount(AccountDto accountDto);

    Flux<AccountDto> getAccountDetails();

    Mono<Void> deleteAccount(Integer id);

    Mono<AccountDto> updateAccount(Integer id, AccountDto accountDto);
}

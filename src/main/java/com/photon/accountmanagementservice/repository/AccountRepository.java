package com.photon.accountmanagementservice.repository;

import com.photon.accountmanagementservice.entity.Account;
import io.r2dbc.spi.Parameter;
import org.springframework.data.r2dbc.repository.R2dbcRepository;

public interface AccountRepository extends R2dbcRepository<Account, Integer> {
}

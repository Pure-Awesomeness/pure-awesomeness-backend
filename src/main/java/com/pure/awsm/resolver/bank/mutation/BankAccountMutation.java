package com.pure.awsm.resolver.bank.mutation;

import com.pure.awsm.domain.bank.BankAccount;
import com.pure.awsm.domain.bank.Currency;
import com.pure.awsm.domain.bank.input.CreateBankAccountInput;
import graphql.kickstart.tools.GraphQLMutationResolver;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.time.Clock;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.UUID;

@Slf4j
@Component
@RequiredArgsConstructor
public class BankAccountMutation implements GraphQLMutationResolver {

    private final Clock clock;

    public BankAccount createBankAccount(CreateBankAccountInput input) {
        log.info("Create bank account for {}", input);
        return getBankAccount(UUID.randomUUID());
    }

    private BankAccount getBankAccount(UUID id) {
        return BankAccount.builder().id(id).currency(Currency.USD).createdAt(ZonedDateTime.now(clock)).createdOn(LocalDate.now(clock)).build();
    }
}

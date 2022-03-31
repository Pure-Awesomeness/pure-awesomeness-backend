package com.pure.awsm.resolver.bank.query;

import com.pure.awsm.domain.bank.BankAccount;
import com.pure.awsm.domain.bank.Currency;
import graphql.kickstart.tools.GraphQLQueryResolver;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Slf4j
@Component
public class BankAccountResolver implements GraphQLQueryResolver {

    public BankAccount bankAccount(UUID id) {
        log.info("Retrieving bank account ");

        return BankAccount.builder()
                .id(id)
                //.client(Client.builder().firstName("Tapan").lastName("Sabat").build())
                .currency(Currency.USD)
                .build();
    }
}

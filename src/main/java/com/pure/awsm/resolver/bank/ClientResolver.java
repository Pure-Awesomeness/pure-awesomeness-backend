package com.pure.awsm.resolver.bank;

import com.pure.awsm.domain.bank.BankAccount;
import com.pure.awsm.domain.bank.Client;
import graphql.execution.DataFetcherResult;
import graphql.kickstart.execution.error.GenericGraphQLError;
import graphql.kickstart.tools.GraphQLResolver;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
@Component
public class ClientResolver implements GraphQLResolver<BankAccount> {

    private final ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

    public CompletableFuture<Client> client(BankAccount bankAccount) {
        log.info("Requesting client data for bank account id {}", bankAccount.getId());
        return CompletableFuture.supplyAsync(() -> getClient(), executorService);
    }

    /* Rename the method to "client" in order to use it. Also rename other methods with different name */
    public Client client2(BankAccount bankAccount) {
        log.info("Requesting client data for bank account id {}", bankAccount.getId());
        if (1 > 0) {
            throw new RuntimeException("SQL: Select ABC From PQR");
        }
        return getClient();
    }

    /* Rename the method to "client" in order to use it. Also rename other methods with different name */
    public DataFetcherResult<Client> client3(BankAccount bankAccount) {
        log.info("Requesting client data for bank account id {}", bankAccount.getId());
        return DataFetcherResult.<Client>newResult().data(getClient()).error(new GenericGraphQLError("Could not get sub-client info")).build();
    }

    private Client getClient() {
        return Client.builder()
                .id(UUID.randomUUID())
                .firstName("SUJI")
                .lastName("Hai")
                .build();
    }
}

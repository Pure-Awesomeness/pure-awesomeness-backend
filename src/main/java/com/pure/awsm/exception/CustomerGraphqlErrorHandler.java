package com.pure.awsm.exception;

import graphql.GraphQLError;
import graphql.kickstart.execution.error.GraphQLErrorHandler;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CustomerGraphqlErrorHandler implements GraphQLErrorHandler {

    @Override
    public boolean errorsPresent(List<GraphQLError> errors) {
        return GraphQLErrorHandler.super.errorsPresent(errors);
    }

    @Override
    public List<GraphQLError> processErrors(List<GraphQLError> list) {
        return list;
    }
}

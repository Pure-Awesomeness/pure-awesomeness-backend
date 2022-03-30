package com.pure.awsm.domain.bank;

import lombok.Builder;
import lombok.Value;

@Builder
@Value
public class Client {
    String firstName;
    String lastName;
}

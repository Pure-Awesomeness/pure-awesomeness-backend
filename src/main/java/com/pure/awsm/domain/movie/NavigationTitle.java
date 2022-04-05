package com.pure.awsm.domain.movie;

import lombok.Builder;
import lombok.Value;

@Builder
@Value
public class NavigationTitle {
    String fetch;
    String title;
    String url;
}

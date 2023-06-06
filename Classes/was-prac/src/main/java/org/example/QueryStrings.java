package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QueryStrings {


    private List<QueryString> queryStrings = new ArrayList<>();

    public QueryStrings(String queryStringLine) {
        String[] queryStringsTokens = queryStringLine.split("&");
        Arrays.stream(queryStringsTokens)
                .forEach(queryString -> {
                    String[] values = queryString.split("=");
                    if (values.length != 2) {
                        throw new IllegalArgumentException("Wrong Query inputs are given");
                    }
                    queryStrings.add(new QueryString(values[0], values[1]));
                });
    }
}

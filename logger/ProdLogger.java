package com.anararabli.abbtech.logger;

import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("prod")
public class ProdLogger implements LoggerService {

    @Override
    public void log(String message) {
        System.out.println(message);
    }
}

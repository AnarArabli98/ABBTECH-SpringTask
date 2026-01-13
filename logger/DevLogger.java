package com.anararabli.abbtech.logger;

import com.anararabli.abbtech.controller.CarController;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("dev")
public class DevLogger implements LoggerService {

    @Override
    public void log(String message) {

    }
}

package org.hello.world.health;

import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.Liveness;

import javax.enterprise.context.ApplicationScoped;

@Liveness
@ApplicationScoped
public class Healthy implements HealthCheck {
    @Override
    public HealthCheckResponse call() {
        return HealthCheckResponse.named("testing custom health response").up().build();
    }
}

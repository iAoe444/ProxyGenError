package test.proxygen.service;

import io.vertx.codegen.annotations.ProxyGen;
import io.vertx.core.Future;
import io.vertx.core.Vertx;
import io.vertx.serviceproxy.ServiceBinder;
import io.vertx.serviceproxy.ServiceProxyBuilder;

/**
 * @date 2021/8/22 16:51
 */
@ProxyGen
public interface TestService {

    String LOG_ADDRESS = "service.test";

    static TestService createProxy(Vertx vertx) {
        return new ServiceProxyBuilder(vertx)
                .setAddress(LOG_ADDRESS)
                .build(TestService.class);
    }

    static ServiceBinder createHandler(Vertx vertx, TestService testService) {
        ServiceBinder serviceBinder = new ServiceBinder(vertx);
        serviceBinder
                .setAddress(LOG_ADDRESS)
                .register(TestService.class, testService);
        return serviceBinder;
    }

    Future<Void> getName();

}

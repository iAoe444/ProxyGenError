package test.proxygen.main;

import io.vertx.core.Vertx;
import test.proxygen.service.TestService;

/**
 * @date 2021/8/22 16:53
 */
public class Test {

    public static void main(String[] args) {
        TestService proxy = TestService.createProxy(Vertx.vertx());
        proxy.getName();
    }

}

package com.example;

import io.helidon.webserver.Routing;
import io.helidon.webserver.WebServer;
import io.lettuce.core.RedisClient;
import io.lettuce.core.RedisURI;
import io.lettuce.core.api.sync.RedisCommands;

public class Main {
    public static void main(String[] args) {
        RedisCommands<String, String> redis = RedisClient.create()
            .connect(RedisURI.create(System.getenv("REDIS_URL")))
            .sync();

        WebServer server = WebServer.builder()
            .routing(Routing.builder().get("/", (request, response) -> {
                Long counter = redis.incr("counter");
                response.status(200).send("Counter = " + counter);
            }))
            .port(Integer.parseInt(System.getenv("PORT")))
            .build();

        server.start();
    }
}

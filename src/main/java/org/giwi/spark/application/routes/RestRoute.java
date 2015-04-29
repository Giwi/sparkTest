package org.giwi.spark.application.routes;


import org.giwi.spark.application.annotation.SparkRoute;
import org.giwi.spark.application.model.Message;
import org.giwi.spark.application.transformers.JsonTransformer;

import static spark.Spark.*;

/**
 * Created by b3605 on 29/04/15.
 */
@SparkRoute(rootPath = "/rest")
public class RestRoute implements SparkRoute.Route {

    @Override
    public void init(String path) {
        get(path + "/hello", "application/json", (request, response) -> {
            return new Message("Hello World");
        }, new JsonTransformer());

        options(path + "/*", (request, response) -> {
            String accessControlRequestHeaders = request.headers("Access-Control-Request-Headers");
            if (accessControlRequestHeaders != null) {
                response.header("Access-Control-Allow-Headers", accessControlRequestHeaders);
            }

            String accessControlRequestMethod = request.headers("Access-Control-Request-Method");
            if (accessControlRequestMethod != null) {
                response.header("Access-Control-Allow-Methods", accessControlRequestMethod);
            }

            return "OK";
        });

        before((request, response) -> response.header("Access-Control-Allow-Origin", "*"));
    }
}

package com.arkea.test.rest.application.routes;

import com.arkea.test.rest.application.annotation.SparkRoute;
import com.arkea.test.rest.application.model.Message;
import com.arkea.test.rest.application.transformers.JsonTransformer;

import static spark.Spark.get;
import static spark.Spark.options;
import static spark.Spark.before;

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

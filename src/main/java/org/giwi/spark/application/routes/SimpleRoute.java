package org.giwi.spark.application.routes;


import org.giwi.spark.application.annotation.SparkRoute;

import static spark.Spark.get;

/**
 * Created by b3605 on 29/04/15.
 */
@SparkRoute(rootPath = "/hello")
public class SimpleRoute implements SparkRoute.Route {

    @Override
    public void init(String path) {
        get(path +"/hello/:name", (request, response) -> "Hello: " + request.params(":name"));
    }
}

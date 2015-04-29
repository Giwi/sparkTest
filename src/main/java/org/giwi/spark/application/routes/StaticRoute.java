package org.giwi.spark.application.routes;


import org.giwi.spark.application.annotation.SparkRoute;

import static spark.SparkBase.staticFileLocation;

/**
 * Created by b3605 on 29/04/15.
 */
@SparkRoute
public class StaticRoute implements SparkRoute.Route {

    @Override
    public void init(String path) {
        staticFileLocation("/public");
    }
}

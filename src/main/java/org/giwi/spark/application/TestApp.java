package org.giwi.spark.application;

import org.giwi.spark.application.annotation.SparkRoute;
import spark.servlet.SparkApplication;


/**
 * Created by b3605 on 29/04/15.
 */
public class TestApp implements SparkApplication {
    public void init() {
        SparkRoute.SparkLoader.addPackage("org.giwi.spark.application.routes");
    }
}

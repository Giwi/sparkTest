package com.arkea.test.rest.application;

import com.arkea.test.rest.application.annotation.SparkRoute.SparkLoader;
import spark.servlet.SparkApplication;


/**
 * Created by b3605 on 29/04/15.
 */
public class TestApp implements SparkApplication {
    public void init() {
        SparkLoader.addPackage("com.arkea.test.rest.application.routes");
    }
}

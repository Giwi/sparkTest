package com.arkea.test.rest.application.transformers;

import com.google.gson.Gson;
import spark.ResponseTransformer;

/**
 * Created by b3605 on 29/04/15.
 */
public class JsonTransformer implements ResponseTransformer {

    private Gson gson = new Gson();

    /**
     *
     * @param model
     * @return
     */
    @Override
    public String render(Object model) {
        return gson.toJson(model);
    }
}

package org.giwi.spark.application.annotation;

import org.reflections.Reflections;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.InvocationTargetException;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by b3605 on 29/04/15.
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface SparkRoute {
    String rootPath() default "";

    interface Route {
        void init(String path);
    }
    /**
     * The type Spark loader.
     */
    class SparkLoader {
        /**
         * Add package.
         *
         * @param packageName the package name
         */
        public static void addPackage(String packageName) {
            Reflections reflections = new Reflections(packageName);
            Set<Class<?>> annotated = reflections.getTypesAnnotatedWith(SparkRoute.class);
            Iterator<Class<?>> it = annotated.iterator();
            while (it.hasNext()) {
                Class<?> rit = it.next();
                try {
                    if(Route.class.isAssignableFrom(rit)) {
                        Route  r = (Route)  rit.getConstructor().newInstance();
                        r.init(rit.getAnnotation(SparkRoute.class).rootPath());
                    }
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

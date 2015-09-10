package life.plank.controller;

import life.plank.PlankApplication;
import life.plank.controller.exception.PlankResourceNotFoundException;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

/**
 * Created by Praneeth on 9/8/2015.
 */
public class RestPreconditions {
    public static <T> T checkFound(final T resource) throws PlankResourceNotFoundException {
        if (resource == null
            || (resource instanceof Collection
                && ((Collection) resource).isEmpty())
            || (resource instanceof Iterable
                && !((Iterable) resource).iterator().hasNext())) {
            throw new PlankResourceNotFoundException();
        }
        return resource;
    }
}
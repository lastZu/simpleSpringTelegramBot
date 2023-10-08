package github.lastzu.contract;

import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Function;

@FunctionalInterface
public interface ResponseHandler<R> {
    R getResponse(Response response);
}

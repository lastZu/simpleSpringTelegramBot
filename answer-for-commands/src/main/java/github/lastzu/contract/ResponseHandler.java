package github.lastzu.contract;

public interface ResponseHandler<T> {
    T getResponse(Response response);
}

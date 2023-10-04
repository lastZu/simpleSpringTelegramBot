package github.lastzu.contract;

public interface RequestHandler<T>  {
    Request getRequest(T original);
}

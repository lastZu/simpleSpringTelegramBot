package github.lastzu.answer;

import github.lastzu.contract.RequestHandler;
import github.lastzu.contract.ResponseHandler;

public interface AnswerFactory<T, R> {
    public AnswerFactory<T, R> setRequest(T original);

    public AnswerFactory<T, R> setRequestHandler(RequestHandler<T> requestHandler);

    public AnswerFactory<T, R> setResponseHandler(ResponseHandler<R> responseHandler);

    public R activate();
}

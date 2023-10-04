package github.lastzu.answer;

import github.lastzu.contract.Request;
import github.lastzu.contract.RequestHandler;
import github.lastzu.contract.Response;
import github.lastzu.contract.ResponseHandler;

public interface AnswerFactory<T, R> {
    void setRequest(T original, RequestHandler<T> requestHandler);

    R getResponse(ResponseHandler<R> responseHandler);
}

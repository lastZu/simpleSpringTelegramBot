package github.lastzu.answer;

import github.lastzu.contract.Request;
import github.lastzu.contract.RequestHandler;
import github.lastzu.contract.Response;
import github.lastzu.contract.ResponseHandler;

import java.util.function.Function;

abstract class AbstractAnswerMaker<T, R> implements AnswerFactory<T, R>{
    private T original;
    private Function<Request, Response> getAnswer;
    private Function<T, Request> getRequest;
    private Function<Response, R> getResponse;

    public void setAnswer(Answer answer) {
        this.getAnswer = answer::getResponse;
    }

    public AnswerFactory<T, R> setRequest(T original) {
        this.original = original;
        return this;
    }

    public AnswerFactory<T, R> setRequestHandler(RequestHandler<T> requestHandler) {
        this.getRequest = requestHandler::getRequest;
        return this;
    }

    public AnswerFactory<T, R> setResponseHandler(ResponseHandler<R> responseHandler) {
        this.getResponse = responseHandler::getResponse;
        return this;
    }

    public R activate() {
        beforeActivationWork();

        R response = getRequest
                .andThen(getAnswer)
                .andThen(getResponse)
                .apply(original);

        afterActivationWork();

        return response;
    }

    protected abstract void beforeActivationWork();
    protected abstract void afterActivationWork();
}

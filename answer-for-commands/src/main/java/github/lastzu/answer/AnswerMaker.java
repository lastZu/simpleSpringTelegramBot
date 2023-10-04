package github.lastzu.answer;

import github.lastzu.contract.Request;
import github.lastzu.contract.RequestHandler;
import github.lastzu.contract.ResponseHandler;

public class AnswerMaker<T, R> implements AnswerFactory<T, R> {
    private Request request;
    private Answer answer;

    public AnswerMaker(Answer answer) {
        this.answer = answer;
    }

    @Override
    public void setRequest(T original, RequestHandler<T> requestHandler) {
        this.request = requestHandler.getRequest(original);
    }

    @Override
    public R getResponse(ResponseHandler<R> responseHandler) {
        return responseHandler.getResponse(
                answer.getResponse(request)
        );
    }

    protected void setAnswer(Answer answer) {
        this.answer = answer;
    }
}

package github.lastzu.answer;

import github.lastzu.contract.Request;
import github.lastzu.contract.RequestHandler;
import github.lastzu.contract.Response;
import github.lastzu.contract.ResponseHandler;

public interface AnswerFactory<Request, Response> {
    void setRequest(Request original, RequestHandler<Request> requestHandler);

    Response getResponse(ResponseHandler<Response> responseHandler);
}

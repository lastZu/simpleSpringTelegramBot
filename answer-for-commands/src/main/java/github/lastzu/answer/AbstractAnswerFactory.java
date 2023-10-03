package github.lastzu.answer;

import github.lastzu.contract.Request;
import github.lastzu.contract.Response;

abstract class AbstractAnswerFactory implements AnswerFactory{
    private Request request;
    private Answer answer;

    public void setRequest(Request request) {
        this.request = request;
    }

    public Response getResponse() {
        return answer.getResponse(request);
    }

    private void setAnswer(Answer answer) {
        this.answer = answer;
    }
}

package github.lastzu.answer;

import github.lastzu.contract.Request;
import github.lastzu.contract.Response;

public interface Answer {
    Response getResponse(Request request);

    Answer next();
}

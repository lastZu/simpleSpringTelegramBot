package github.lastzu.answer;

public interface AnswerFactory {
    void setRequest(Request request);

    Response getResponse();
}

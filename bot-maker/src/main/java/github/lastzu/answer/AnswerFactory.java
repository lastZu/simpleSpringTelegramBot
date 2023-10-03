package github.lastzu.answer;

import org.telegram.telegrambots.meta.api.objects.Update;

public interface AnswerFactory {
    void setRequest(Request request);

    Response getResponse();
}

package github.lastzu;

import github.lastzu.answer.Answer;
import github.lastzu.answer.AnswerFactory;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class HandlingBot extends TelegramLongPollingBot {
    private AnswerFactory answerFactory;
    private final String name;

    public HandlingBot(String name, String token) {
        this(name, token, new StartAnswerFactory());
    }

    public HandlingBot(String name, String token, AnswerFactory answerFactory) {
        super(token);
        this.name = name;
        this.answerFactory = answerFactory;
    }

    @Override
    public void onUpdateReceived(Update update) {
        answerFactory.setRequest(
                getRequest(update)
        );
        sendAnswer();
    }

    @Override
    public String getBotUsername() {
        return name;
    }

    private void sendAnswer() {
        Response answer = answerFactory.getResponse();
        SendMessage message = getMessage(answer);
        try {
            execute(message);
        } catch (TelegramApiException e) {
            // TODO Logging
            e.printStackTrace();
        }
    }

    private Request getRequest(Update update) {
        return null;
    }

    private SendMessage getMessage(Response response) {
        return  null;
    }

    public void setAnswerFactory(AnswerFactory answerFactory) {
        this.answerFactory = answerFactory;
    }
}

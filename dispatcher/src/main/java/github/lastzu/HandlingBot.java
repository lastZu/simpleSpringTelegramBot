package github.lastzu;

import github.lastzu.answer.AnswerFactory;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class HandlingBot extends TelegramLongPollingBot {
    private AnswerFactory answerFactory;
    private final String name;
    Logger log = LoggerFactory.getLogger(HandlingBot.class);

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
        log.info("Bot received updates");

        answerFactory.setRequest(
                getRequest(update)
        );
        sendAnswer();

        log.info("Bot finished send response");
    }

    @Override
    public String getBotUsername() {
        return name;
    }

    private void sendAnswer() {
        log.debug("Getting message");
        Response answer = answerFactory.getResponse();
        SendMessage message = getMessage(answer);

        try {
            execute(message);
            log.debug("Message send successfully");
        } catch (TelegramApiException e) {
            log.error("Can not send message", e);
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

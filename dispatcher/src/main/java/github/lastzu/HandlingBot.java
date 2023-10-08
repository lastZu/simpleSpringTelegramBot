package github.lastzu;


import github.lastzu.answer.AnswerFactory;
import github.lastzu.answer.Answers;
import github.lastzu.contract.Request;
import github.lastzu.contract.Response;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.List;

public class HandlingBot extends TelegramLongPollingBot {
    private static final int MAX_KEYBOARD_COLUMNS = 3;
    private AnswerFactory<Update, SendMessage> answerFactory;
    private final String name;
    Logger log = LoggerFactory.getLogger(this.getClass());

    public HandlingBot(String name, String token, AnswerFactory<Update, SendMessage> answerFactory) {
        super(token);
        this.name = name;
        this.answerFactory = answerFactory;
    }

    @Override
    public void onUpdateReceived(Update update) {
        log.info("Bot received updates");

        SendMessage message = answerFactory
                .setRequest(update)
                .setRequestHandler(this::getRequest)
                .setResponseHandler(this::getMessage)
                .activate();

        try {
            execute(message);
            log.debug("Message send successfully");
        } catch (TelegramApiException e) {
            log.error("Can not send message", e);
        }

        log.info("Bot finished send response");
    }

    @Override
    public String getBotUsername() {
        return name;
    }

    private Request getRequest(Update update) {
        if (!update.hasMessage()) {
            return Answers.getEmptyRequest();
        }
        Message message = update.getMessage();
        return new Request(
                message.getChatId().toString(),
                message.getText(), // TODO
                message.getText()
        );
    }

    private SendMessage getMessage(Response response) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(response.id());
        sendMessage.setText(response.text());
        InlineKeyboardMarkup keyboardMarkup = makeKeyboardMarkup(response.commands());
        sendMessage.setReplyMarkup(keyboardMarkup);

        return sendMessage;
    }

    private InlineKeyboardMarkup makeKeyboardMarkup(List<String> commands) {
        InlineKeyboardMarkup keyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();

        for(String command : commands) {
            List<InlineKeyboardButton> row = new ArrayList<>();
            for (int i = 0; i < MAX_KEYBOARD_COLUMNS; i++) {
                InlineKeyboardButton button = new InlineKeyboardButton(command);

                String callBack = makeCallback(command);
                button.setCallbackData(callBack);

                row.add(button);
            }
            keyboard.add(row);
        }
        keyboardMarkup.setKeyboard(keyboard);

        return keyboardMarkup;
    }

    private String makeCallback(String commandName) {
        return commandName;
    }
}

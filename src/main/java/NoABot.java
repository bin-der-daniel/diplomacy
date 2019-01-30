import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class NoABot extends TelegramLongPollingBot {


    public void onUpdateReceived(Update update) {
        // We check if the update has a message and the message has text
        if (update.hasMessage() && update.getMessage().hasText()) {
            String message = update.getMessage().getText();
            message = message.replace(" ","Algebren");
            SendMessage outmessage = new SendMessage() // Create a SendMessage object with mandatory fields
                    .setChatId(update.getMessage().getChatId())
                    .setText(message);

            try {
                execute(outmessage); // Call method to send the message
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }
    }
    public void replyToStart(long chatId) {
        try {
            sender.execute(new SendMessage()
                    .setText(Constants.START_REPLY)
                    .setChatId(chatId));

            sender.execute(new SendMessage()
                    .setText(Constants.FIND_TRAINING_DATE)
                    .setChatId(chatId)
                    .setReplyMarkup(KeyboardFactory.withTodayTomorrowButtons()));

            chatStates.put(chatId, State.AWAITING_TRAINING_DAY);

        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }



    public String getBotUsername() {
        // TODO
        return "democracytest_bot";
    }

    @Override
    public String getBotToken() {
        // TODO
        return "670291794:AAFt3JpcPWw97podBrI_EVF4BsLUKRg8rMs";
    }

    public static void main(String[] args) {
        int i = 1;
        ApiContextInitializer.init();
        TelegramBotsApi api = new TelegramBotsApi();

        try {
            api.registerBot(new NoABot());
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}



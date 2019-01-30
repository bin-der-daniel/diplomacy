import org.telegram.telegrambots.Constants;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboard;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.ArrayList;
import java.util.List;

public class KeyboardFactory {
    public static ReplyKeyboard withTodayTomorrowButtons() {
        InlineKeyboardMarkup inlineKeyboard = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> rowsInline = new ArrayList<>();
        List<InlineKeyboardButton> rowInline = new ArrayList<>();
        rowInline.add(new InlineKeyboardButton().setText("Test 1").setCallbackData("Test 1"));
        rowInline.add(new InlineKeyboardButton().setText("Test 1").setCallbackData("Test 1"));
        rowsInline.add(rowInline);
        inlineKeyboard.setKeyboard(rowsInline);
        return inlineKeyboard;
    }
}

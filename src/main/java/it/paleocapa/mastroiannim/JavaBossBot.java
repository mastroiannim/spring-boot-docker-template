package it.paleocapa.mastroiannim;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import org.telegram.telegrambots.meta.api.objects.*;


@Service
public class JavaBossBot extends TelegramLongPollingBot {

	private static final Logger LOG = LoggerFactory.getLogger(JavaBossBot.class);

	private String botUsername;
	private static String botToken;
	private static JavaBossBot instance;

	public static JavaBossBot getJavaBossBotInstance(String botUsername, String botToken){
		if(instance == null) {
			instance = new JavaBossBot();
			instance.botUsername = botUsername;
			JavaBossBot.botToken = botToken;
		}
		return instance;
	}

	private JavaBossBot(){
		super(botToken);
	}

	@Override
	public String getBotToken() {
		return botToken;
	}
	
	@Override
	public String getBotUsername() {
		return botUsername;
	}

	@Override
	public void onUpdateReceived(Update update) {
		if (update.hasMessage() && update.getMessage().hasText()) {
			
			long chatId = update.getMessage().getChatId();

			User sender = update.getMessage().getFrom();
			
			String username = sender.getUserName();
			String msg = String.format("Benvenuto %s, come posso aiutarti? ", username);
			LOG.info(msg);

			SendMessage message = new SendMessage();
			message.setChatId(chatId);
			message.setText(msg);
			
			try {
				execute(message);
			} catch (TelegramApiException e) {
				LOG.error(e.getMessage());
			}
		}
	}
}

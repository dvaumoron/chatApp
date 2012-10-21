package models;

import java.util.ArrayList;
import java.util.List;

import play.libs.Comet;

public class ChatServer {

	public static ChatServer INSTANCE = new ChatServer();

	private List<Comet> listeners = new ArrayList<Comet>();

	public void addListener(Comet listener) {
		listeners.add(listener);
	}

	public void sendMessage(String message) {
		for(Comet listener : listeners) {
			listener.sendMessage(message);
		}
	}
}

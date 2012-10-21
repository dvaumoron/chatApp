package controllers;

import models.ChatServer;
import models.Message;
import play.*;
import play.data.*;
import play.libs.*;
import play.mvc.*;

import views.html.*;

public class Application extends Controller {

	public static Form<Message> messageForm = form(Message.class);

	public static Result index() {
		return ok(index.render(messageForm));
	}

	public static Result comet() {
		Comet comet = new Comet("parent.receiveMessage") {
			@Override
			public void onConnected() {
				ChatServer.INSTANCE.addListener(this);
			}
		};
		return ok(comet);
	}

	public static Result ajax() {
		Form<Message> filledForm = messageForm.bindFromRequest();
		if (!filledForm.hasErrors()) {
			ChatServer.INSTANCE.sendMessage(filledForm.get().toString());
		}
		return ok();
	}

}
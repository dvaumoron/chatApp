package models;

import play.data.validation.Constraints.Required;

public class Message {

	@Required
	public String message;

	@Override
	public String toString() {
		return message;
	}
}

package et.ticketingsystem.ts.util;

public class FieldErrorMessage{

	public String field;
	public String message;
	
	
	public FieldErrorMessage(String field, String message) {
		super();
		this.field = field;
		this.message = message;
	}
	public String getField() {
		return field;
	}
	public String getMessage() {
		return message;
	}
	public void setField(String field) {
		this.field = field;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
}

package logic.exception;

public class UserNotFoundException extends Exception{

	private static final long serialVersionUID = -1482962286272110475L;
	
	private final Throwable cause = new Throwable("USER_NOT_FOUND");
	
	public UserNotFoundException() {
		super("USER_NOT_FOUND");
		this.initCause(cause);
	}
		
}

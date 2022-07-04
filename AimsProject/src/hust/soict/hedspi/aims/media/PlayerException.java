package hust.soict.hedspi.aims.media;
import java.lang.Exception;

public class PlayerException extends Exception {
	public PlayerException() {
		super();
	}
	
	public PlayerException(String msg) {
		super(msg);
	}
	public PlayerException(String msg, Throwable cause) {
		super(msg, cause);
	}
	public PlayerException(Throwable cause) {
		super(cause);
	}
}

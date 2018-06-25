package cn.ol.demo.exception;

public class AddProductException extends Exception {

	public AddProductException() {
		super();
	}

	public AddProductException(String message, Throwable cause) {
		super(message, cause);
	}

	public AddProductException(String message) {
		super(message);
	}

	public AddProductException(Throwable cause) {
		super(cause);
	}

}

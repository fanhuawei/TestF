package cn.com.mobilereal.common.web;


public class BusinessException extends RuntimeException {

    /**
	 * 
	 */
	private static final long serialVersionUID = 5090305683958565376L;
	
	public BusinessException(String message, Throwable cause) {
		super(message, cause);
	}

	public BusinessException(String message) {
		this(message,null);
	}

	public BusinessException(Throwable cause) {
		this(cause.getMessage(),cause.getCause());
	}

}

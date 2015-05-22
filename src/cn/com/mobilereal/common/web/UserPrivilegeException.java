package cn.com.mobilereal.common.web;


@SuppressWarnings("serial")
public class UserPrivilegeException extends RuntimeException {

    public UserPrivilegeException() {
        super();
    }

    public UserPrivilegeException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserPrivilegeException(String message) {
        super(message);
    }

    public UserPrivilegeException(Throwable cause) {
        super(cause);
    }

}

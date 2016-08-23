package com.github.wangxianzhuo.common;

/**
 * service operate exception.
 *
 * @author Yang XuePing
 */
public class ServiceException extends RuntimeException {
    private static final long serialVersionUID = 8295913146847589868L;

    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(String message,
                            Throwable cause) {
        super(message, cause);
    }

}

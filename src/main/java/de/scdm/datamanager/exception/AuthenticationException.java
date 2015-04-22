package de.scdm.datamanager.exception;

public class AuthenticationException extends Exception {

  private static final long serialVersionUID = 1L;

  public AuthenticationException() {
    super();
  }

  public AuthenticationException(Throwable e) {
    super(e);
  }

  public AuthenticationException(String msg) {
    super(msg);
  }
}

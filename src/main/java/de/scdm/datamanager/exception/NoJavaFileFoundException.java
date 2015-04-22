package de.scdm.datamanager.exception;

public class NoJavaFileFoundException extends Exception {

  private static final long serialVersionUID = 1L;

  public NoJavaFileFoundException() {
    super();
  }

  public NoJavaFileFoundException(Throwable e) {
    super(e);
  }

  public NoJavaFileFoundException(String msg) {
    super(msg);
  }
}

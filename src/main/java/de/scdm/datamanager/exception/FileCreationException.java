package de.scdm.datamanager.exception;

public class FileCreationException extends Exception {

  private static final long serialVersionUID = 1L;

  public FileCreationException() {
    super();
  }

  public FileCreationException(Throwable e) {
    super(e);
  }

  public FileCreationException(String msg) {
    super(msg);
  }

}

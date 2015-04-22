package de.scdm.datamanager.exception;

public class DataExtractionException extends Exception {

  private static final long serialVersionUID = 1L;

  public DataExtractionException() {
    super();
  }

  public DataExtractionException(Throwable e) {
    super(e);
  }

  public DataExtractionException(String msg) {
    super(msg);
  }
}

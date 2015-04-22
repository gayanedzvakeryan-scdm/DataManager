package de.scdm.datamanager.util;

import java.io.File;

public class InputFolderValidator {

  public static boolean isEmpty(String path) {
    return path == null || path.trim().isEmpty();
  }

  public static boolean fileNotExists(String path) {
    return !new File(path).exists();
  }

  public static String isValid(String path) {
    if (isEmpty(path)) {
      return Constants.PATH_IS_REQUIRED_MSG;
    }
    if (fileNotExists(path)) {
      return Constants.PATH_IS_INVALID_MSG;
    }
    return "";
  }
}

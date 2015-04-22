package de.scdm.datamanager;

import de.scdm.datamanager.view.DataManagerView;

public class DataManager {

  private DataManagerView dataManagerView;

  public static void main(String[] args) {
    new DataManager();
  }

  public DataManager() {
    dataManagerView = new DataManagerView();
    dataManagerView.showDataExtractorView();
  }

}

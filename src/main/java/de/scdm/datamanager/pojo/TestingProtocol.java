package de.scdm.datamanager.pojo;

import java.util.List;

public class TestingProtocol {

  private String path;
  private String projectName;
  private String revision;
  private String server;
  private String dataset;
  private String datasetVersion;
  private int numberOfTestCases;
  private int numberOfPassedTestCases;
  private int numberOfFailedTestCases;
  private String startDate;
  private String endDate;
  private List<String> testsuites;

  public String getProjectName() {
    return projectName;
  }

  public void setProjectName(String projectName) {
    this.projectName = projectName;
  }

  public String getRevision() {
    return revision;
  }

  public void setRevision(String revision) {
    this.revision = revision;
  }

  public String getServer() {
    return server;
  }

  public void setServer(String server) {
    this.server = server;
  }

  public String getDataset() {
    return dataset;
  }

  public void setDataset(String dataset) {
    this.dataset = dataset;
  }

  public String getDatasetVersion() {
    return datasetVersion;
  }

  public void setDatasetVersion(String datasetVersion) {
    this.datasetVersion = datasetVersion;
  }

  public int getNumberOfTestCases() {
    return numberOfTestCases;
  }

  public void setNumberOfTestCases(int numberOfTestCases) {
    this.numberOfTestCases = numberOfTestCases;
  }

  public int getNumberOfPassedTestCases() {
    return numberOfPassedTestCases;
  }

  public void setNumberOfPassedTestCases(int numberOfPassedTestCases) {
    this.numberOfPassedTestCases = numberOfPassedTestCases;
  }

  public int getNumberOfFailedTestCases() {
    return numberOfFailedTestCases;
  }

  public void setNumberOfFailedTestCases(int numberOfFailedTestCases) {
    this.numberOfFailedTestCases = numberOfFailedTestCases;
  }

  public String getStartDate() {
    return startDate;
  }

  public void setStartDate(String startDate) {
    this.startDate = startDate;
  }

  public String getEndDate() {
    return endDate;
  }

  public void setEndDate(String endDate) {
    this.endDate = endDate;
  }

  public List<String> getTestsuites() {
    return testsuites;
  }

  public void setTestsuites(List<String> testsuites) {
    this.testsuites = testsuites;
  }

  public String getPath() {
    return path;
  }

  public void setPath(String path) {
    this.path = path;
  }
}

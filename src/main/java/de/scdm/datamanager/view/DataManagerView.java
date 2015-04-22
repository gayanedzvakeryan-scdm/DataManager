package de.scdm.datamanager.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFormattedTextField.AbstractFormatter;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.UtilDateModel;
import de.scdm.datamanager.util.Constants;
import de.scdm.eadbdataimporter.EadbDataImporter;

public class DataManagerView extends JFrame {

  private static final long serialVersionUID = 1L;

  private JPanel mainPanel;
  private JPanel importPanel;
  private JPanel exportPanel;

  public DataManagerView() {
    init();
  }

  private void init() {
    mainPanel = new JPanel();
    mainPanel.setLayout(null);

    JTabbedPane tabbedPane = new JTabbedPane();
    tabbedPane.setBounds(5, 5, 440, 235);

    initImportTab();
    initExportEadbtab();

    tabbedPane.addTab("Import", importPanel);
    tabbedPane.addTab("Export", exportPanel);
    mainPanel.add(tabbedPane);

  }

  private void initImportTab() {
    importPanel = new JPanel();
    importPanel.setLayout(null);
    
    JLabel providerLabel = new JLabel("Provider");
    JLabel filePathLabel = new JLabel("File path");
    JLabel tempFolderLabel = new JLabel("Temp folder");
    JLabel dateLabel = new JLabel("Date");

    final JTextField filePathTextField = new JTextField();
    JTextField tempFolderTextField = new JTextField();
    JButton browseFileButton = new JButton("Browse");
    JButton browseTempButton = new JButton("Browse");
    JButton importButton = new JButton("Import");
    
    String[] providers = {"EADB", "WM"};
    JComboBox providerList = new JComboBox(providers);

    filePathTextField.setEditable(false);
    tempFolderTextField.setEditable(false);
    
    providerLabel.setBounds(15, 10, 100, 30);
    providerList.setBounds(120, 10, 200, 30);

    filePathLabel.setBounds(15, 50, 100, 30);
    filePathTextField.setBounds(120, 50, 200, 30);
    browseFileButton.setBounds(330, 50, 90, 30);

    tempFolderLabel.setBounds(15, 90, 100, 30);
    tempFolderTextField.setBounds(120, 90, 200, 30);
    browseTempButton.setBounds(330, 90, 90, 30);

    dateLabel.setBounds(15, 130, 100, 30);
    UtilDateModel model = new UtilDateModel();
    JDatePanelImpl datePanel = new JDatePanelImpl(model);
    final JDatePickerImpl datePicker = new JDatePickerImpl(datePanel,
        new DateLabelFormatter());
    
    datePicker.setBounds(120, 130, 200, 30);

    importButton.setBounds(330, 170, 90, 30);

    importPanel.add(providerLabel);
    importPanel.add(providerList);
    
    importPanel.add(filePathLabel);
    importPanel.add(filePathTextField);
    importPanel.add(browseFileButton);

    importPanel.add(tempFolderLabel);
    importPanel.add(tempFolderTextField);
    importPanel.add(browseTempButton);

    importPanel.add(dateLabel);
    importPanel.add(datePicker);
    importPanel.add(importButton);

    BrowseActionListenerImpl actionListenerImpl = 
        new BrowseActionListenerImpl();
    actionListenerImpl.setFilePathTextField(filePathTextField);
    actionListenerImpl.setType(JFileChooser.FILES_ONLY);
    browseFileButton.addActionListener(actionListenerImpl);

    BrowseActionListenerImpl actionListenerImplTemp = 
        new BrowseActionListenerImpl();
    actionListenerImplTemp.setFilePathTextField(tempFolderTextField);
    actionListenerImplTemp.setType(JFileChooser.DIRECTORIES_ONLY);
    browseTempButton.addActionListener(actionListenerImplTemp);
   
    importButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        String[] args = new String[2];
        args[0] = filePathTextField.getText();
        Date selectedDate = (Date) datePicker.getModel().getValue();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String reportDate = df.format(selectedDate);
        args[1] = reportDate;
        try {
          EadbDataImporter.main(args);
        } catch (Exception e1) {
        }
      }
    });
    
  }

  private void initExportEadbtab() {
    exportPanel = new JPanel();
    exportPanel.setLayout(null);
    
    JLabel providerLabel = new JLabel("Provider");
    JLabel destFolderLabel = new JLabel("<html>Destination<br>folder</html>");
    JLabel dateLabel = new JLabel("Date");

    JTextField destFolderTextField = new JTextField();
    JButton browseDestButton = new JButton("Browse");
    JButton exportButton = new JButton("Export");
    
    String[] providers = {"EADB", "WM"};
    JComboBox providerList = new JComboBox(providers);

    destFolderTextField.setEditable(false);
    
    providerLabel.setBounds(15, 10, 100, 30);
    providerList.setBounds(120, 10, 200, 30);

    destFolderLabel.setBounds(15, 50, 100, 30);
    destFolderTextField.setBounds(120, 50, 200, 30);
    browseDestButton.setBounds(330, 50, 90, 30);

    dateLabel.setBounds(15, 90, 100, 30);
    UtilDateModel model = new UtilDateModel();
    JDatePanelImpl datePanel = new JDatePanelImpl(model);
    JDatePickerImpl datePicker = new JDatePickerImpl(datePanel,
        new DateLabelFormatter());

    datePicker.setBounds(120, 90, 200, 30);

    exportButton.setBounds(330, 130, 90, 30);

    exportPanel.add(providerLabel);
    exportPanel.add(providerList);
    
    exportPanel.add(destFolderLabel);
    exportPanel.add(destFolderTextField);
    exportPanel.add(browseDestButton);

    exportPanel.add(dateLabel);
    exportPanel.add(datePicker);
    exportPanel.add(exportButton);

    BrowseActionListenerImpl actionListenerImplTemp = new BrowseActionListenerImpl();
    actionListenerImplTemp.setFilePathTextField(destFolderTextField);
    actionListenerImplTemp.setType(JFileChooser.DIRECTORIES_ONLY);
    browseDestButton.addActionListener(actionListenerImplTemp);
    
    
  }

  public void showDataExtractorView() {
    setResizable(false);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLocationRelativeTo(null);
    setSize(470, 295);
    setTitle(Constants.DATA_MANAGER_VIEW_FRAME_TITLE);
    add(mainPanel);
    setVisible(true);
  }

  private class DateLabelFormatter extends AbstractFormatter {
    private static final long serialVersionUID = 1L;

    private String datePattern = "yyyy-MM-dd";
    private SimpleDateFormat dateFormatter = new SimpleDateFormat(datePattern);

    @Override
    public Object stringToValue(String text) throws ParseException {
      return dateFormatter.parseObject(text);
    }

    @Override
    public String valueToString(Object value) throws ParseException {
      if (value != null) {
        Calendar cal = (Calendar) value;
        return dateFormatter.format(cal.getTime());
      }
      return "";
    }
  }

  private class BrowseActionListenerImpl implements ActionListener {
    private JFileChooser fileChooser = new JFileChooser();
    private JTextField filePathTextField;

    @Override
    public void actionPerformed(ActionEvent e) {
      fileChooser.setCurrentDirectory(new File("."));
      fileChooser.setDialogTitle("Choose file or directory.");
      if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
        if (getFilePathTextField() != null) {
          getFilePathTextField().setText(
              fileChooser.getSelectedFile().getAbsolutePath());
        }
      }
    }

    public void setType(int type) {
      fileChooser.setFileSelectionMode(type);
    }

    public JTextField getFilePathTextField() {
      return filePathTextField;
    }

    public void setFilePathTextField(JTextField filePathTextField) {
      this.filePathTextField = filePathTextField;
    }
  }

}

package WWWController;

import javax.swing.*;
import java.io.*;

public class Controller {

    private MainPanel    mainPanel;
    private String       hostsPath;
    private Threading    threading;

    private Thread reader;
    private Thread deleteThread;
    private Thread threadingThread;
    private JTextField textF;
    private long fileLength;

    public Controller() {
        showFrame();
    }

    private void showFrame() {

        mainPanel = new MainPanel(this);

        JFrame frame = new JFrame("WWWController");
        frame.add(mainPanel);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }
    public void startSearching(String dirPath) {
        threading = new Threading(this,dirPath);
    }
    public void outPutFoundFile(String fileFound) {
        mainPanel.OutPutToTextArea(fileFound);
    }


    public void vroomVroomRun(JTextField target, String filePath, String websiteString) {
        reader = new Thread(new Reader(this, filePath, websiteString), "Inputter");

    }
    public void vroomDeleteRun(JTextField target, String filePath, String websiteString){
        deleteThread = new Thread(new DeleteThread(this,filePath, websiteString), "Deleter");
    }


}

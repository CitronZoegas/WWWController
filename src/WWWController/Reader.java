package WWWController;

import java.io.*;

public class Reader extends Thread {

    //private long filePath;
    private Controller controller;
    private String websiteString;
    private String filePath;

    public Reader(Controller controller, String filePath, String websiteString) {
        this.controller = controller;
        this.filePath = filePath;
        this.websiteString = websiteString;
        start();
    }

    @Override
    public void run() {
            try{
                //Writing things
                FileWriter fw = new FileWriter(filePath,true);
                BufferedWriter bw = new BufferedWriter(fw);

                bw.newLine();
                bw.write("        127.0.0.1" + "       " + websiteString);//The amount of space is to make it look good in the host file.
                bw.newLine();
                bw.close();

                //printring to console
                File file = new File(filePath);
                BufferedReader br = new BufferedReader(new FileReader(file));

                String strTemp;
                while((strTemp = br.readLine())!= null) {
                    System.out.println(strTemp);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
}

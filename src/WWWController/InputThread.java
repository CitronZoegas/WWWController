package WWWController;

public class InputThread extends Thread {


    private String      websiteString;
    private Controller  controller;


    public InputThread(Controller controller, String websiteString){
        this.controller = controller;
        this.websiteString = websiteString;
        start();
    }

    @Override
    public void run() {
        while(true){

            try{
                Thread.sleep(2000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
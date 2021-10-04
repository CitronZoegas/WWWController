package WWWController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * I want to make a program that can disable websites on command for people who either work from home
 * or have problems with focusing on the important things in life.
 *
 * @Author CitronZoegas(With help from the internet).
 *
 * **/

public class MainPanel extends JPanel {
    private Controller  controller;
    private JPanel      pnlFindReplace = new JPanel(new GridLayout(2, 2, 5, 5));
    private JLabel      lblFind = new JLabel("Enter a file name:", JLabel.TRAILING);
    private JTextField  tfFind = new JTextField();
    private JLabel      lblReplaceWith = new JLabel("Enter website:", JLabel.TRAILING);
    private JTextField  tfReplaceWith = new JTextField();

    private JPanel      pnlSourceDest = new JPanel(new GridLayout(1, 2, 5, 5));

    private JPanel      pnlSource = new JPanel(new BorderLayout(5, 5));
    private JLabel      lblSource = new JLabel("Found file:");
    private JTextArea   taSource = new JTextArea();
    private JScrollPane spSource = new JScrollPane(taSource);


    private JPanel      pnlDest = new JPanel(new BorderLayout(5, 5));
    private JLabel      lblDest = new JLabel("Remove");
    private JTextArea   taDest = new JTextArea();
    private JScrollPane spDest = new JScrollPane(taDest);

    private JPanel      pnlButtons = new JPanel(new GridLayout(1, 1, 5, 5));
    private JButton     btnTfFind = new JButton("Find file");
    private JButton     btnInsertWWW = new JButton("Add website:");
    private JButton     btnDelete = new JButton("Delete file:");




    public MainPanel(Controller controller) {
        this.controller = controller;

        setPreferredSize(new Dimension(800, 450));
        setBorder(BorderFactory.createEmptyBorder(20, 10, 20, 10));
        setLayout(new BorderLayout(5, 5));

        pnlFindReplace.add(lblFind);
        pnlFindReplace.add(tfFind);
        pnlFindReplace.add(lblReplaceWith);
        pnlFindReplace.add(tfReplaceWith);
        add(pnlFindReplace, BorderLayout.NORTH);

        pnlSource.add(lblSource, BorderLayout.NORTH);
        pnlSource.add(spSource, BorderLayout.CENTER);

        pnlDest.add(lblDest, BorderLayout.NORTH);
        pnlDest.add(spDest, BorderLayout.CENTER);


        pnlSourceDest.add(pnlSource);
        pnlSourceDest.add(pnlDest);
        add(pnlSourceDest, BorderLayout.CENTER);

        pnlButtons.add(btnTfFind);
        pnlButtons.add(btnInsertWWW);
        pnlButtons.add(btnDelete);
        add(pnlButtons, BorderLayout.SOUTH);

        ButtonListener listener = new ButtonListener();
        btnDelete.addActionListener(listener);
        btnTfFind.addActionListener(listener);
        btnInsertWWW.addActionListener(listener);
    }
    private  class ButtonListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){

            if(e.getSource() == btnTfFind){
                controller.startSearching(tfFind.getText());
            }
            if(e.getSource() == btnInsertWWW){
                addWebsite();
            }
            if(e.getSource() == btnDelete){
                deleteWebsite();
            }
        }
    }
    public void OutPutToTextArea(String fileFound){
        taSource.append(fileFound);
    }
    private void addWebsite(){
        controller.vroomVroomRun(tfReplaceWith, taSource.getText(),tfReplaceWith.getText());
    }
    private void deleteWebsite() {
        controller.vroomDeleteRun(tfReplaceWith,  taSource.getText(),tfReplaceWith.getText());
    }
}
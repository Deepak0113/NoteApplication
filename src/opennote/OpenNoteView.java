package opennote;

import javax.swing.*;

public class OpenNoteView implements OpenNoteViewCallback {
    private OpenNoteViewControllerCallback openNoteController;

    public OpenNoteView() {
        openNoteController = new OpenNoteController(this);
    }

    public static void main(String[] args) {
        OpenNoteView openNoteView = new OpenNoteView();
        openNoteView.startOpenNoteModule();
    }

    public void startOpenNoteModule(){

//        JTextArea jTextArea = new JTextArea();
//        jTextArea.setBounds(0, 0, jFrame.getWidth(), jFrame.getHeight());
        frameUI();
    }

    private void frameUI(){
        int height = 700, width = 700;
        JFrame jFrame = new JFrame("NoteTaker");
        jFrame.setSize(700, 700);
        JTextArea jTextArea = new JTextArea();
        JButton jButton = new JButton("Apply");

        jTextArea.setBounds(0,0,400,400);
        jButton.setBounds(150,150,95,30);

        addButton(jFrame, "Apply");
        jFrame.setLayout(null);
        jFrame.setVisible(true);
    }

    private void addButton(JFrame jFrame, String btnTitle){
        JButton jButton = new JButton(btnTitle);
        jButton.setBounds(20, 20,90,30);
        jFrame.add(jButton);
    }


}
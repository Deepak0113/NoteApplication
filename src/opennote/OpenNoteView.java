package opennote;

import dto.User;
import home.HomeView;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Scanner;

public class OpenNoteView implements OpenNoteViewCallback {
    private OpenNoteViewControllerCallback openNoteController;
    private final Scanner scanner = new Scanner(System.in);

    public OpenNoteView() {
        openNoteController = new OpenNoteController(this);
    }


    public void startOpenNoteModule(User user){
        System.out.println("Open note: ");
        System.out.println("------------------------------");
        System.out.println("Enter noteID: ");
        String noteId = scanner.nextLine();
        openNoteController.openNote(noteId, user);
    }

    @Override
    public void openNoteSuccess(String note, User user, String noteId) {
        frameUI(note, user, noteId);
        HomeView homeView = new HomeView();
        homeView.startHomeModule(user);
    }

    @Override
    public void openNoteWarning(String message, User user) {
        System.out.println("Open note failed: " + message);
    }

    private void frameUI(String note, User user, String noteId){
        int height = 700, width = 700;
        JFrame jFrame = new JFrame("NoteTaker");
        jFrame.setSize(width, height);

        textArea(jFrame, note, user, noteId);

        jFrame.setVisible(true);
        jFrame.setLayout(null);
        jFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    private void textArea(JFrame jFrame, String note, User user, String noteId){
        JTextArea jTextArea = new JTextArea();
        jTextArea.setBounds(0, 0, jFrame.getWidth(), jFrame.getHeight());
        jTextArea.setText(note);

        JDialog d = new JDialog(jFrame, "adfsadf");
        JLabel l = new JLabel("sdfaf");
        d.setSize(100,100);
        d.add(l);
        d.setVisible(true);

        jTextArea.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_S && e.isControlDown()){
                    openNoteController.saveNote(noteId, user, jTextArea.getText());

                    JDialog d = new JDialog(jFrame, "status");
                    JLabel l = new JLabel("Saved Successfully");
                    d.setSize(100,100);
                    d.add(l);
                    d.setVisible(true);
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });

        scrollPane(jFrame, jTextArea);
    }

    private void scrollPane(JFrame jFrame, JTextArea jTextArea){
        JScrollPane jScrollPane = new JScrollPane(jTextArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        jFrame.add(jScrollPane);
    }
}
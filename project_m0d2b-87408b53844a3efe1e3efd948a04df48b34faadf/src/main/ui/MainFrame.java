package ui;


import ui.UserInput;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {
    static final JTextArea textArea = new JTextArea();


    public static void appendTextArea(String str) {
        textArea.append("\n" + str);
    }

    public void setArea(String str) {
        textArea.setText(str);
    }

    public MainFrame(String title) {
        super(title);

        //Set Layout Manager
        setLayout(new BorderLayout());

        //Create Swing Components

        final JTextField textField = new JTextField();
        JButton button = new JButton("Enter");
        JButton button1 = new JButton("Load Termninal");

        //Add Swing Components to content pane
        Container c = getContentPane();
        c.add(textArea, BorderLayout.CENTER);
        c.add(button, BorderLayout.EAST);
//        c.add(button1, BorderLayout.NORTH);
        c.add(textField, BorderLayout.SOUTH);

        // Add Behaviour

//        button1.addActionListener(new ActionListener() {
//
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                UserInput.input = textField.getText();
//                textField.setText("");
//                System.out.println("i am alive");
//                UserInput.loop= false;
//            }
//        });

        button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                UserInput.input = textField.getText();
                textField.setText("");
                MainFrame.appendTextArea("i am alive");
                UserInput.loop = false;
            }
        });

    }

}

package ru.study.java.andrey;

import javax.swing.*;

public class View {
    private JList<String> list;
    private JTextField textField;
    private Controller controller;

    public void setController(Controller controller) {
        this.controller = controller;
    }

    public void buildFrame() {
        JFrame frame = new JFrame("Chat");
        frame.setLayout(null);
        frame.setSize(300, 400);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        list = new JList<>();
        list.setBounds(5, 5, 273, 290);
        frame.add(list);

        textField = new JTextField();
        textField.setBounds(5, 300, 200, 50);
        frame.add(textField);

        JButton sendButton = new JButton("Send");
        sendButton.setBounds(210, 300, 70, 50);
        frame.add(sendButton);
        sendButton.addActionListener(e -> controller.handleSendButton());

        frame.setVisible(true);
    }
}

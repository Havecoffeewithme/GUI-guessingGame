/**
 * The class represents the guessing game class.
 *
 * @author PercyRatheko ;
 *
 * version 1.8
 */

package com.bcit.comp2601.lab07;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.time.LocalDateTime;


public class GuessingGame
{
    private final static int INITIAL_COUNT;
    private JLabel scoreLabel;

    static
    {
        INITIAL_COUNT = 0;
    }
    private int clickCount = INITIAL_COUNT;

    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(() -> {
        new GuessingGame().createAndShowGUI();});

    }
    private void createAndShowGUI()
    {
        JFrame frame = new JFrame("GUESSING GAME");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(550, 300);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        //panel.setLayout(new FlowLayout());

        JLabel instructionLabel = new JLabel("Guess a number between 1 and 100 : ");
        instructionLabel.setBounds(200,20,200,30);
        panel.add(instructionLabel);

        scoreLabel = new JLabel("Your score: " + clickCount);
        scoreLabel.setBounds(200, 120, 200, 30);
        panel.add(scoreLabel);



        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Options");
        JMenuItem howToPlayItem = new JMenuItem("How to Play");
        JMenuItem feedbackItem = new JMenuItem("Send Feedback");
        JMenuItem restartGameItem = new JMenuItem("Restart Game");
        JMenuItem exitItem = new JMenuItem("Exit");


        JTextField textField = new JTextField();
        textField.setBounds(150,70,100,30);

        JButton button = new JButton("Submit Guess");
        button.setBounds(270,70,120,30);

        button.addActionListener(e -> {
            clickCount++;
            scoreLabel.setText("Your score: " + clickCount);
        });

        howToPlayItem.addActionListener(e -> {
            final String text;
            text = """ 
                    Instructions:
                    1.Enter a number between 1 and 100 in the text field
                    2.Click 'submit Guess' to check your guess.
                    3.if your guess is too-low or too high, you will receive feedback.
                    4.keep guessing until you find the correct number
                    5.your score will be displayed and updated after each guess.
                    6.You can restart the game or exit from the 'Options' menu.
                    """;
            JOptionPane.showMessageDialog(null,text);
        });

        restartGameItem.addActionListener(e -> {
            clickCount = INITIAL_COUNT;
            scoreLabel.setText("Your score: " + clickCount);
            textField.setText("");
        });

        exitItem.addActionListener(e -> System.exit(0));



        panel.add(textField);
        panel.add(button);



        menuBar.add(menu);
        menu.add(howToPlayItem);
        menu.add(feedbackItem);
        menu.add(restartGameItem);
        menu.add(exitItem);

        frame.setJMenuBar(menuBar);
        frame.add(panel);
        frame.setVisible(true);




    }


}

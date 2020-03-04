package com.company;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import javax.swing.*;

public class SimpleGUI extends JFrame{


    Manipulating manipulating = new Manipulating();
    int r = manipulating.rand();


    public JButton button = new JButton("Спробувати");
    public JTextField input = new JTextField("", 1);
    public JLabel label1 = new JLabel("Рандомне число = " + r);
    public JLabel label2 = new JLabel("Спробуйте вгадати пароль");



    public SimpleGUI(){
        super("Генерація паролів");
        this.setBounds(100, 100, 300, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container container = this.getContentPane();
        container.setLayout(new GridLayout(4, 1, 2, 2));
        container.add(label1);
        container.add(label2);
        container.add(input);

        button.addActionListener(new ButtonEvent());
        container.add(button);

    }

    class Manipulating{

        public int rand(){
            Random random = new Random();
            int r = 0;
            r = random.nextInt(100);
            return r;
        }
        public int reader() throws IOException {
            int a;

            try (Scanner scanner = new Scanner(new File("C:\\Users\\Користувач\\IdeaProjects\\security2\\file1.txt:secret.txt")))
            {
                ArrayList<Integer> numbers = new ArrayList<>();
                while (scanner.hasNextInt())
                {
                    numbers.add(scanner.nextInt());
                }
                a = numbers.get(0);
            }
            catch (FileNotFoundException e)
            {
                e.printStackTrace();
                a = 0;
            }
            return a;
        }

        public boolean isTrue() throws IOException {
            boolean result;
            int inp = Integer.valueOf(input.getText());

            if(reader()+r==inp){
                result=true;
            } else result=false;

            return result;
        }
    }

    class ButtonEvent implements ActionListener {

        public void actionPerformed (ActionEvent e){
            String message;

            try {
                if(manipulating.isTrue()){
                    message = "Ви вгадали\n";
                }
                else {
                    message="Невдача";
                }
                JOptionPane.showMessageDialog(null, message, "Результат", JOptionPane.PLAIN_MESSAGE);

            } catch (IOException e1) {
                e1.printStackTrace();
            }

        }

    }

}


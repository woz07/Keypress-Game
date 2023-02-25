import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;
import java.util.Scanner;

public class Main extends JFrame {
    JPanel panel = new JPanel();
    JTextField input = new JTextField();
    JLabel output = new JLabel();
    JLabel scoreOutput = new JLabel("0");
    Scanner sc = new Scanner(System.in);
    Random rand = new Random();
    public Main() {
        setTitle("Keypress Game");
        setSize(200, 200);
        setBackground(Color.WHITE);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        input.setPreferredSize(new Dimension(100, 50));
        output.setPreferredSize(new Dimension(100, 50));
        output.setFont(new Font("Sans Serif", Font.BOLD, 15));
        scoreOutput.setFont(new Font("Sans Serif", Font.BOLD, 15));

        panel.setLayout(new FlowLayout(FlowLayout.CENTER));
        panel.add(input);
        panel.add(output);
        panel.add(scoreOutput);

        output.setText(String.valueOf(generateRandomChar()));

        input.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent keyEvent) {
                if (keyEvent.getKeyCode()==KeyEvent.VK_ENTER) {
                    char userInput = input.getText().charAt(0);
                    if (output.getText().charAt(0) == userInput) {
                        int s = Integer.parseInt(scoreOutput.getText());
                        s++;
                        scoreOutput.setText(String.valueOf(s));
                    } else {
                        int s = Integer.parseInt(scoreOutput.getText());
                        s--;
                        scoreOutput.setText(String.valueOf(s));
                    }
                    input.setText("");
                    output.setText(String.valueOf(generateRandomChar()));
                }
            }
        });
        
        add(panel);
        setVisible(true);
        setResizable(false);
        pack();
        setLocationRelativeTo(null);

    }

    char generateRandomChar() {
        String abc = "abcdefghijklmnopqrstuvwxyz";
        return abc.charAt(rand.nextInt(abc.length()-1));
    }

    public static void main(String[] args) {
        Main main = new Main();
    }
}

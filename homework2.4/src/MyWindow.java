import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class MyWindow extends JFrame {
    MyWindow() {

        JPanel[] jp = new JPanel[4];
        for (int i = 0; i < 2; i++) {
            jp[i] = new JPanel();
            add(jp[i]);
            jp[i].setBackground(new Color(100 + i * 40, 100 + i * 40, 100 + i * 40));
            setVisible(true);
        }
        jp[0].setLayout(new BorderLayout());
        JTextArea jta = new JTextArea();
        jta.setEditable(false);
        JScrollPane jsp = new JScrollPane(jta);
        jp[0].add(jsp);

        jp[1].setLayout(new GridLayout(1, 2));
        JTextField input = new JTextField();
        JButton send = new JButton("Send message");
        jp[1].add(input);
        jp[1].add(send);
        send.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jta.setText(jta.getText() + "\n" + input.getText());
                input.setText("");
            }
        });

        setTitle("Chat Window");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(300, 300, 400, 400);
        setLayout(new GridLayout(2, 1));
        setVisible(true);
    }

}

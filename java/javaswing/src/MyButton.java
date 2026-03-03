import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;

public class MyButton extends JFrame implements ActionListener {

    JButton button;

    MyButton() {

        ImageIcon icon = new ImageIcon("java/javaswing/SensationalIcon.png");

        button = new JButton();
        button.setBounds(140, 100, 190, 150); // button sizing
        button.addActionListener(this); // for click respond
        button.setText("");
        button.setFocusable(false);
        button.setIcon(icon);
        // button.setHorizontalTextPosition(JButtong.CENTER) - for horizontal text position in the button
        // button.setVerticalTextPosition(JButtong.CENTER) - for vertical text position in the button
        // button.setFont(new Font("Comic Sans", Font.BOLD, 25)); - for font formatting
        // button.setIconTextGap(-12); - adjust distance between the button icon and the button text
        // button.setForeGround(Color.cyan); - for font color 
        button.setBackground(Color.LIGHT_GRAY);
        button.setBorder(BorderFactory.createEtchedBorder());
        // button.setEnabled(false); - Disable the button

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setSize(500, 500);
        this.setVisible(true);
        this.add(button);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button) {
            System.out.println("Sensational");
        // button.setEnabled(false); - Disable the button after you click it once
        }
    }
}

import javax.swing.*;
import java.awt.Color;
import helper_classes.*;

public class WindowBuilder {
  public static void main(String[] args) {

     JFrame frame = new JFrame("My Awesome Window");
     frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     frame.setSize(848, 458);
     JPanel panel = new JPanel();
     panel.setLayout(null);
     panel.setBackground(Color.decode("#1e1e1e"));

     JButton Button1 = new JButton("Click Me");
     Button1.setBounds(227, 69, 333, 259);
     Button1.setBackground(Color.decode("#2e2e2e"));
     Button1.setForeground(Color.decode("#D9D9D9"));
     Button1.setFont(CustomFontLoader.loadFont("./resources/fonts/Lato.ttf", 14));
     Button1.setBorder(new RoundedBorder(4, Color.decode("#979797"), 1));
     Button1.setFocusPainted(false);
     OnClickEventHelper.setOnClickColor(Button1, Color.decode("#232323"), Color.decode("#2e2e2e"));
     panel.add(Button1);

     frame.add(panel);
     frame.setVisible(true);

  }
}
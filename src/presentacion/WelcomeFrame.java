package presentacion;

import Logica.TargetPathObservable;
import java.awt.Color;
import java.awt.Font;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JLabel;

public class WelcomeFrame extends TemplateFrame implements Observer {
    
    private JLabel welcomeText;
    private JLabel insertText;    
    private Font labelsFont;    
           
    public WelcomeFrame() {        
        welcomeText = new JLabel();
        insertText = new JLabel();
        labelsFont = new Font("Comic Sans MS", Font.BOLD, 100);        
    }
    
    @Override
    public void addComponents() {        
        add(welcomeText);
        add(insertText);
    }

    public void setComponentsProperties() {
        setWelcomeTextProperties();
        setInsertTextProperties();
    }

    private void setWelcomeTextProperties() {
        welcomeText.setLocation((int) (getWidth() * 0.15), (int) (getHeight() * 0.25));
        welcomeText.setSize((int) (getWidth() * 0.70), (int) (getHeight() * 0.15));
        welcomeText.setForeground(Color.WHITE);
        welcomeText.setFont(labelsFont);
        welcomeText.setText("Bienvenido al cajero UD");
        welcomeText.setHorizontalAlignment(JLabel.CENTER);
        welcomeText.setVerticalAlignment(JLabel.CENTER);
    }
    
    private void setInsertTextProperties(){
        insertText.setLocation(welcomeText.getX(), (int) welcomeText.getY() + welcomeText.getHeight()+ 20 );
        insertText.setSize((int) (getWidth() * 0.70), (int) (getHeight() * 0.15));
        insertText.setForeground(Color.WHITE);
        insertText.setFont(labelsFont);
        insertText.setText("Inserte la tarjeta");
        insertText.setHorizontalAlignment(JLabel.CENTER);
        insertText.setVerticalAlignment(JLabel.CENTER);
    }    

    @Override
    public void update(Observable o, Object arg) {
        if (arg instanceof TargetPathObservable) {
            dispose();
        }
    }
    
}

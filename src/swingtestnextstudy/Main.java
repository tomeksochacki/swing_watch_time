package swingtestnextstudy;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Main extends JFrame {

    public Main(){
        super("Watch");
        this.setDefaultCloseOperation(3);
        this.setBounds(300, 300, 300, 200);
        initComponents();
    }

    public void initComponents(){
        //panel.add(label);
        panel.add(time);

        ActionListener stopwatch = new Clock();
        Timer clock = new Timer(1000, stopwatch);
        this.getContentPane().add(panel);
        clock.start();
        pack();
    }

    private class Clock implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            time.setText(getTime());
        }
    }

    public String getTime(){
        GregorianCalendar gregorianCalendar = new GregorianCalendar();

        String h = ""+gregorianCalendar.get(Calendar.HOUR_OF_DAY);
        String min = ""+gregorianCalendar.get(Calendar.MINUTE);
        String sec = ""+gregorianCalendar.get(Calendar.SECOND);

        if (Integer.parseInt(h)<10){
            h = "0" + h;
        }
        if (Integer.parseInt(min)<10){
            min = "0" + min;
        }
        if (Integer.parseInt(sec)<10){
            sec = "0" + sec;
        }

        return "" + h +":"+ min +":"+ sec;
    }

    static int i = 1;

    JPanel panel = new JPanel();
    JLabel label = new JLabel("Time: ");
    JLabel time = new JLabel(getTime());

    public static void main(String[] args) {
        new Main().setVisible(true);
    }
}

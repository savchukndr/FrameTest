import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by savch on 07.03.2017.
 */
public class ResultFrame {
    private JFrame resultFrame;
    private String carResString, masterResString, selectResString;
    public ResultFrame(){

        initialize();
    }

    public void initialize(){
        resultFrame = new JFrame("Result");
        resultFrame.setSize(400, 200);
        resultFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        resultFrame.setLocationRelativeTo(null);
        resultFrame.setLayout(new GridBagLayout());

        ////Test dataset for Strings
        carResString = "0,1234";
        masterResString = "1,1111";
        selectResString = "10,1010101";
        ////

        JLabel timeIntoCarLabel = new JLabel("Insert into car time:");
        JLabel carResLabel = new JLabel(carResString);
        JLabel timeIntoMasterLabel = new JLabel("Insert into master time:");
        JLabel masterResLabel = new JLabel(masterResString);
        JLabel selectTimeLabel = new JLabel("Select time:");
        JLabel selectResLabel = new JLabel(selectResString);

        resultFrame.add(timeIntoCarLabel, new GridBagConstraints(0, 0, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(2,2,2,2), 2, 2));
        resultFrame.add(carResLabel, new GridBagConstraints(1, 0, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(2,2,2,2), 2, 2));
        resultFrame.add(timeIntoMasterLabel, new GridBagConstraints(0, 1, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(2,2,2,2), 2, 2));
        resultFrame.add(masterResLabel, new GridBagConstraints(1, 1, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(2,2,2,2), 2, 2));
        resultFrame.add(selectTimeLabel, new GridBagConstraints(0, 2, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(2,2,2,2), 2, 2));
        resultFrame.add(selectResLabel, new GridBagConstraints(1, 2, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(2,2,2,2), 2, 2));
    }

    public void show(){
        this.resultFrame.setVisible(true);
        this.resultFrame.pack();
    }
}

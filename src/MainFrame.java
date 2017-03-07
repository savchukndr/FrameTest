import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by savch on 04.03.2017.
 */
public class MainFrame extends JFrame{

    private aTask t;
    private JButton buttonCount, buttonCencel;
    private JProgressBar progressBar;
    private JLabel labelDownload;
    private JTextArea textArea;
    private JRadioButton radioButtonPG, radioButtonRD, radioButtonRDPG;
    private ButtonGroup radioButtonGroup;
    private String choice;

    public MainFrame(){
        try {
            initialize();
        }catch (InterruptedException e){
            System.out.print("Exception: " + e);
        }
    }

    private void initialize() throws InterruptedException {
        //JFrame frame = new JFrame("BaseTest program");

        //Frame
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        //Panels
        JPanel panelLeft = new JPanel();
        panelLeft.setLayout(new GridBagLayout());
        JPanel panelTop = new JPanel();
        JPanel panelRight = new JPanel();
        panelRight.setLayout(new GridBagLayout());

        //Introduce Label
        JLabel welcomeLabel = new JLabel("Please, choose option and start count:");

        //ProgreaaBar Label
        labelDownload = new JLabel();

        //Progress Bar
        progressBar = new JProgressBar();
        progressBar.setStringPainted(true);
        progressBar.setMinimum(0);
        progressBar.setMaximum(100);

        //Radio Buttons
        radioButtonPG = new JRadioButton("PostgreSQL");
        radioButtonPG.setActionCommand("PG");
        radioButtonRD = new JRadioButton("Redis");
        radioButtonRD.setActionCommand("RD");
        radioButtonRDPG = new JRadioButton("Both");
        radioButtonRDPG.setActionCommand("RDPG");
        choice = "RDPG";
        radioButtonRDPG.setSelected(true);

        //Start button inicialization
        buttonCount = new JButton("Start");
        buttonCount.addActionListener(this::startActionPerformed);

        //Cencel button inicialization
        buttonCencel = new JButton("Cencel");
        buttonCencel.addActionListener(this::cencelActionPerformed);

        //Text area
        textArea = new JTextArea(20, 40);
        textArea.setEditable(false);

        //adding scroll to main Text Area
        JScrollPane scroll = new JScrollPane (textArea,
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);


        panelTop.add(welcomeLabel);

        radioButtonGroup = new ButtonGroup();
        radioButtonGroup.add(radioButtonPG);
        radioButtonGroup.add(radioButtonRD);
        radioButtonGroup.add(radioButtonRDPG);

        RadioButtonActionListener actionListener = new RadioButtonActionListener();
        radioButtonPG.addActionListener(actionListener);
        radioButtonRD.addActionListener(actionListener);
        radioButtonRDPG.addActionListener(actionListener);

        //radiobutton for PostgreSQL
        panelLeft.add(radioButtonPG, new GridBagConstraints(0, 0, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(4,2,2,2), 0, 0));
        //radiobutton for Radis
        panelLeft.add(radioButtonRD, new GridBagConstraints(0, 1, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(4,2,2,2), 0, 0));
        //radiobutton for both
        panelLeft.add(radioButtonRDPG, new GridBagConstraints(0, 2, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(4,2,2,2), 0, 0));
        //buttonCount added to panelLeft
        panelLeft.add(buttonCount, new GridBagConstraints(0, 3, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(100,2,2,2), 2, 2));
        panelLeft.add(buttonCencel, new GridBagConstraints(0, 4, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(100,2,2,2), 2, 2));



        add(panelLeft, BorderLayout.WEST);

        //adding scroll with TextArea to panelRight
        panelRight.add(scroll, new GridBagConstraints(0, 0, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(2,2,2,2), 2, 2));
        //adding progressBar to panelRight
        panelRight.add(progressBar, new GridBagConstraints(0, 1, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(2,2,2,2), 2, 2));
        //adding label to panelRight
        panelRight.add(labelDownload, new GridBagConstraints(0, 2, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(2,2,2,2), 2, 2));
        add(panelRight, BorderLayout.CENTER);
        labelDownload.setText("Press \"Start\" to start downloadnig");
        //progressBar.setValue(0);

        add(panelTop, BorderLayout.NORTH);
        setVisible(true);
        pack();

        //REsultWindow
        //ResultFrame resFrame = new ResultFrame();
        //resFrame.show();
        //////////////////////////

    }

    private void startActionPerformed(ActionEvent e){
        (t = new aTask()).execute();
        buttonCount.setEnabled(false);
        buttonCencel.setEnabled(true);
    }

    private void cencelActionPerformed(ActionEvent e){
        buttonCount.setEnabled(true);
        buttonCencel.setEnabled(false);
        t.cancel(true);
        labelDownload.setText("Downloading is interrupted!");
    }


    //ActionListener for RadioButtons
    private class RadioButtonActionListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            choice = radioButtonGroup.getSelection().getActionCommand();
            /*switch (choice){
                case "PG":
                    System.out.println("PG");
                    break;
                case "RD":
                    System.out.println("RD");
                    break;
                case "RDPG":
                    System.out.println("RDPG");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "My Goodness, this is unknown command.");
                    break;
            }*/
        }
    }

    private class aTask extends SwingWorker<Void, String>{

        @Override
        protected Void doInBackground() throws Exception {
            String s = "";

            progressBar.setIndeterminate(false);
            labelDownload.setText("Downloading...");
            textArea.setText("");
            switch (choice){
                case "PG":
                    s = "PG";
                    break;
                case "RD":
                    s = "RD";
                    break;
                case "RDPG":
                    s = "RDPG";
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "My Goodness, this is unknown command.");
                    break;
            }
            for(int i=progressBar.getMinimum(); i<=progressBar.getMaximum(); i++){
                Thread.sleep(70);
                textArea.append(i + ": " + s + "\n");
                progressBar.setValue(i);
            }

            labelDownload.setText("Downloaded!");

            return null;
        }

        @Override
        protected void done(){

        }
    }
}

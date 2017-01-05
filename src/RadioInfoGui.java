import javax.swing.*;
import java.awt.*;

/**
 * Created by c15aem on 2017-01-03.
 */
public class RadioInfoGui {
    private JFrame frame;

    private JButton clear ;
    private JTable resultsfromapi = new JTable();



    /**
     * Builds the Gui
     * @param title
     */
    public RadioInfoGui(String title) {
        frame=new JFrame(title);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        //JPanel middlePanel = buildMiddlePanel();
        JMenuBar upperPanel = buildUpperPanel();
        JPanel lowerPanel = buildLowerPanel();


        frame.add(upperPanel, BorderLayout.NORTH);
        //frame.add(middlePanel, BorderLayout.CENTER);
        frame.add(lowerPanel, BorderLayout.SOUTH);

        frame.pack();
        frame.setSize(500, 500);

    }

    /**
     * true to show and false to not show window
     */
    public void show() {
        frame.setVisible(true);
    }


    /**
     * Creates the lowerpanel
     * @return Lowerpanel as a JPanel
     */
    private JPanel buildLowerPanel() {
        JPanel lowerPanel = new JPanel();
        lowerPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        clear = new JButton("Clear");
        //clear.addActionListener(new ButtonListener(textField, textArea));
        lowerPanel.add(clear);

        return lowerPanel;
    }

    /**
     * Creates the middlepanel
     * @return Middlepanel as a JPanel
     */
    private JPanel buildMiddlePanel() {

        return null;
    }

    /**
     * Creates the upperpanel
     * @return Upperpanel as a JMenuBar
     */
    private JMenuBar buildUpperPanel() {
        JMenuBar menuBar;
        JMenu menu;
        JMenuItem menuItem;

        menuBar = new JMenuBar();

        menu = new JMenu("Info");

        menuBar.add(menu);

        menuItem = new JMenuItem("About");



        menu.add(menuItem);

        menuItem = new JMenuItem("Help");

        JTextArea textArea = new JTextArea();
        textArea.setText(
                "This is an anti-tower defence game where you have a limited "
                        + "amount of credit to create troops and try to reach goal. \n ");

        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);

        scrollPane.setPreferredSize( new Dimension( 500, 500 ) );



        menu.add(menuItem);
        return menuBar;



    }

}

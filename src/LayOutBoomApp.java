import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LayOutBoomApp{

    public LayOutBoomApp(){
        this.PrepareBorderFrame();

    }

    public JFrame PrepareBorderFrame(){
        JFrame MusicApp = new JFrame("MusicApp LayOut");

        MusicApp.setExtendedState(JFrame.MAXIMIZED_BOTH);
        MusicApp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        MusicApp.setLayout(new BorderLayout());

        JLabel north = new JLabel("My Music Catalogue", JLabel.CENTER);
        north.setFont(new Font("Arial", Font.BOLD,24));
        MusicApp.add(north, BorderLayout.NORTH);


        JPanel south = new JPanel();
        JButton SubmitButton = new JButton("Submit");
        JButton ExitButton = new JButton("Exit");
        south.add(SubmitButton);
        south.add(ExitButton);
        MusicApp.add(south, BorderLayout.SOUTH);

        String[] Categories = {"Rap","Reggae","Ballads"};
        JList<String> CategoryList = new JList<>(Categories);
        CategoryList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane CategoryScrollPane =  new JScrollPane(CategoryList);
        MusicApp.add(CategoryScrollPane, BorderLayout.WEST);

        JPanel centre = new JPanel(new GridLayout(5,2));
        centre.add(new JLabel("Artist Name:"));
        JTextField artistField = new JTextField();
        centre.add(artistField);

        centre.add(new JLabel("Recording Studio:"));
        JTextField studioField = new JTextField();
        centre.add(studioField);

        centre.add(new JLabel("Category:"));JComboBox<String> categoryComboBox = new JComboBox<>(Categories);
        centre.add(categoryComboBox);

        centre.add(new JLabel("Available:"));
        JCheckBox availableCheckBox = new JCheckBox();
        centre.add(availableCheckBox);
        MusicApp.add(centre,BorderLayout.CENTER);


        MusicApp.setVisible(true);

        SubmitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String artist = artistField.getText();
                String studio = studioField.getText();
                String category = (String) categoryComboBox.getSelectedItem();
                boolean available = availableCheckBox.isSelected();

                System.out.println("Artist: " + artist);
                System.out.println("Studio: " + studio);
                System.out.println("Category: "+ category);
                System.out.println("Available: "+ available);
            }
        });

        ExitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(2);
            }
        });
        return MusicApp;
    }

}
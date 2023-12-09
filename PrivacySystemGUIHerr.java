/**************************************************************
* Name : PrivacySystemGUIHerr
* Author : Chayton Herr
* Created : 12/8/2023
* Course : CIS 152 Data Structures
* Version : 1.2
* OS : Windows 11
* Copyright : This is my own original work based on
* specifications issued by our instructor
* Description : GUI for PrivacySystemHerr.
* Academic Honesty: I attest that this is my original work.
* I have not used unauthorized source code, either modified or
* unmodified. I have not given other fellow student(s) access to
* my program.
***************************************************************/

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

public class PrivacySystemGUIHerr extends JFrame {
    private PrivacySystemHerr privacySystem;
    private JTextField userTextField, preferenceTextField;
    private DefaultListModel<String> preferencesListModel;

    public PrivacySystemGUIHerr() {
        privacySystem = new PrivacySystemHerr();
        preferencesListModel = new DefaultListModel<>();

        setTitle("Privacy System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(5, 1));

        // Components
        userTextField = new JTextField();
        preferenceTextField = new JTextField();
        JButton addButton = new JButton("Add Preference");
        JButton removeButton = new JButton("Remove Preference");
        JList<String> preferencesList = new JList<>(preferencesListModel);

        // Add components to the frame
        add(new JLabel("User:"));
        add(userTextField);
        add(new JLabel("Preference:"));
        add(preferenceTextField);
        add(addButton);
        add(removeButton);
        add(new JScrollPane(preferencesList));

        // Add action listeners
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String user = userTextField.getText();
                String preference = preferenceTextField.getText();
                privacySystem.addPreference(user, preference);
                updatePreferencesDisplay(user);
            }
        });

        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String user = userTextField.getText();
                String preference = preferenceTextField.getText();
                privacySystem.removePreference(user, preference);
                updatePreferencesDisplay(user);
            }
        });

        pack();
        setLocationRelativeTo(null);
        setVisible(true);

        prepopulateTestData();
    }

    private void updatePreferencesDisplay(String user) {
        LinkedList<String> userPreferences = privacySystem.getPreferences(user);
        preferencesListModel.removeAllElements();
        for (String preference : userPreferences) {
            preferencesListModel.addElement(preference);
        }
        privacySystem.sortPreferences(user);
    }

    // Prepopulate some data for testing
    private void prepopulateTestData() {
        privacySystem.addPreference("user1", "Contact Information");
        privacySystem.addPreference("user1", "Search History");
        privacySystem.addPreference("user1", "Location Data");

        privacySystem.addPreference("user2", "Social Media");
        privacySystem.addPreference("user2", "Cookies");

        updatePreferencesDisplay("user1");
        updatePreferencesDisplay("user2");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new PrivacySystemGUIHerr());
    }
}
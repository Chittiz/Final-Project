/**************************************************************
* Name : PrivacySystemHerr
* Author : Chayton Herr
* Created : 12/8/2023
* Course : CIS 152 Data Structures
* Version : 1.2
* OS : Windows 11
* Copyright : This is my own original work based on
* specifications issued by our instructor
* Description : Defines a PrivacySystemHerr class that manages
* user preferences using a HashMap.
* Academic Honesty: I attest that this is my original work.
* I have not used unauthorized source code, either modified or
* unmodified. I have not given other fellow student(s) access to
* my program.
***************************************************************/

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;

class PrivacySystemHerr {
    private HashMap<String, LinkedList<String>> preferences;

    public PrivacySystemHerr() {
        preferences = new HashMap<>();
    }

    // Add a preference for a user
    public void addPreference(String user, String preference) {
        if (isValidInput(user, preference)) {
            preferences.computeIfAbsent(user, k -> new LinkedList<>()).add(preference);
        } else {
            System.out.println("Invalid input for addPreference");
        }
    }

    // Remove a preference for a user
    public void removePreference(String user, String preference) {
        if (isValidInput(user, preference)) {
            preferences.getOrDefault(user, new LinkedList<>()).remove(preference);
        } else {
            System.out.println("Invalid input for removePreference");
        }
    }

    // Get preferences for a user
    public LinkedList<String> getPreferences(String user) {
        return preferences.getOrDefault(user, new LinkedList<>());
    }

    // Sort preferences using Collections.sort
    public void sortPreferences(String user) {
        LinkedList<String> userPreferences = getPreferences(user);
        Collections.sort(userPreferences);
    }

    private boolean isValidInput(String user, String preference) {
        return user != null && !user.isEmpty() && preference != null && !preference.isEmpty();
    }

    public static void main(String[] args) {
        PrivacySystemHerr privacySystem = new PrivacySystemHerr();

        privacySystem.addPreference("user1", "Contact Information");
        privacySystem.addPreference("user1", "Search History");
        privacySystem.addPreference("user1", "Location Data");

        privacySystem.addPreference("user2", "Social Media");
        privacySystem.addPreference("user2", "Cookies");

        System.out.println("User 1 Preferences: " + privacySystem.getPreferences("user1"));
        System.out.println("User 2 Preferences: " + privacySystem.getPreferences("user2"));

        privacySystem.sortPreferences("user1");
        privacySystem.sortPreferences("user2");

        System.out.println("Sorted User 1 Preferences: " + privacySystem.getPreferences("user1"));
        System.out.println("Sorted User 2 Preferences: " + privacySystem.getPreferences("user2"));
    }
}
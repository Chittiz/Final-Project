/**************************************************************
* Name : PrivacySystemTestHerr
* Author : Chayton Herr
* Created : 12/8/2023
* Course : CIS 152 Data Structures
* Version : 1.2
* OS : Windows 11
* Copyright : This is my own original work based on
* specifications issued by our instructor
* Description : Four unit tests for PrivacySystemHerr.
* Academic Honesty: I attest that this is my original work.
* I have not used unauthorized source code, either modified or
* unmodified. I have not given other fellow student(s) access to
* my program.
***************************************************************/

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

class PrivacySystemHerrTest {

    @Test
    void addPreference() {
        PrivacySystemHerr privacySystem = new PrivacySystemHerr();
        privacySystem.addPreference("user1", "Contact Information");

        LinkedList<String> preferences = privacySystem.getPreferences("user1");
        assertTrue(preferences.contains("Contact Information"));
    }

    @Test
    void removePreference() {
        PrivacySystemHerr privacySystem = new PrivacySystemHerr();
        privacySystem.addPreference("user1", "Contact Information");
        privacySystem.removePreference("user1", "Contact Information");

        LinkedList<String> preferences = privacySystem.getPreferences("user1");
        assertFalse(preferences.contains("Contact Information"));
    }

    @Test
    void getPreferences() {
        PrivacySystemHerr privacySystem = new PrivacySystemHerr();
        privacySystem.addPreference("user1", "Contact Information");
        privacySystem.addPreference("user1", "Search History");

        LinkedList<String> preferences = privacySystem.getPreferences("user1");
        assertEquals(Arrays.asList("Contact Information", "Search History"), preferences);
    }

    @Test
    void sortPreferences() {
        PrivacySystemHerr privacySystem = new PrivacySystemHerr();
        privacySystem.addPreference("user1", "Search History");
        privacySystem.addPreference("user1", "Location Data");
        privacySystem.addPreference("user1", "Contact Information");

        privacySystem.sortPreferences("user1");
        LinkedList<String> sortedPreferences = privacySystem.getPreferences("user1");

        assertEquals(Arrays.asList("Contact Information", "Location Data", "Search History"), sortedPreferences);
    }
}
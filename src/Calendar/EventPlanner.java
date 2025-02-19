package Calendar;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDateTime;

/**
 * Class representing the Event Planner application.
 */
public class EventPlanner {

    public static void main(String[] args) {
        // Start the Event Planner application on the Event Dispatch Thread
        SwingUtilities.invokeLater(() -> {
            // Create and set up the main application window (JFrame)
            JFrame frame = new JFrame("Event Planner");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(600, 400);
            frame.setLayout(new BorderLayout());

            // Create and add the EventListPanel to the frame
            EventListPanel eventListPanel = new EventListPanel();
            addDefaultEvents(eventListPanel); // Add initial events

            frame.add(eventListPanel, BorderLayout.CENTER);
            frame.setVisible(true); // Make the frame visible
        });
    }

    /**
     * Adds default events to the provided EventListPanel.
     *
     * @param events The EventListPanel to which default events will be added.
     */
    private static void addDefaultEvents(EventListPanel events) {
        events.addEvent(new Meeting("Team Meeting",
                LocalDateTime.now().plusDays(1),
                LocalDateTime.now().plusDays(1).plusHours(2),
                "Conference Room A"));

        events.addEvent(new Deadline("Project Submission",
                LocalDateTime.now().plusDays(3)));
    }
}

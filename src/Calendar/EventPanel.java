package Calendar;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

/**
 * Class representing a panel for displaying and managing an event.
 * This class extends JPanel to provide a graphical representation of the event.
 */
public class EventPanel extends JPanel {
    private Event event; // The event to be displayed on the panel
    private JButton completeButton; // Button to mark the event as complete

    /**
     * Constructor to initialize the EventPanel with an event.
     *
     * @param event The event to be displayed on the panel.
     */
    public EventPanel(Event event) {
        this.event = event;
        setPreferredSize(new Dimension(300, 100));
        setBorder(BorderFactory.createLineBorder(Color.BLACK));

        // Add a complete button if the event is completable
        if (event instanceof Completable completable) {
            completeButton = new JButton("Mark as Complete");
            completeButton.addActionListener(e -> {
                completable.complete();
                repaint();
            });
            add(completeButton);
        }

        updateUrgency(); // Update the panel's background color based on event urgency
    }

    /**
     * Overrides the paintComponent method to draw the event details on the panel.
     *
     * @param g The Graphics object used for painting.
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setFont(new Font("Arial", Font.PLAIN, 14));

        int x = 10, y = 20;

        g.drawString("Event: " + event.getName(), x, y);
        y += 20;
        g.drawString("Date: " + event.getDateTime(), x, y);

        // Display additional details if the event is a Meeting
        if (event instanceof Meeting meeting) {
            y += 20;
            g.drawString("Location: " + meeting.getLocation(), x, y);
            y += 20;
            g.drawString("Duration: " + meeting.getDuration().toMinutes() + " mins", x, y);
        }

        // Display completion status if the event is completable
        if (event instanceof Completable completable) {
            y += 20;
            g.drawString("Completed: " + (completable.isComplete() ? "Yes" : "No"), x, y);
        }
    }

    /**
     * Updates the panel's background color based on the urgency of the event.
     * Red: Overdue, Yellow: Imminent, Green: Distant.
     */
    private void updateUrgency() {
        LocalDateTime now = LocalDateTime.now();
        if (event.getDateTime().isBefore(now)) {
            setBackground(Color.RED); // Overdue
        } else if (ChronoUnit.HOURS.between(now, event.getDateTime()) <= 24) {
            setBackground(Color.YELLOW); // Imminent
        } else {
            setBackground(Color.GREEN); // Distant
        }
    }
}

package Calendar;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDateTime;

/**
 * Class representing a modal dialog for adding new events.
 * This class extends JDialog to provide a graphical interface for event input.
 */
public class AddEventModal extends JDialog {
    private JTextField nameField; // Text field for event name
    private JComboBox<String> eventTypeDropdown; // Dropdown menu for event type selection
    private JTextField dateTimeField; // Text field for event date and time
    private JTextField endDateTimeField; // Text field for end date and time (for meetings only)
    private JTextField locationField; // Text field for event location (for meetings only)
    private EventListPanel eventListPanel; // Reference to the EventListPanel

    /**
     * Constructor to initialize the AddEventModal dialog.
     *
     * @param eventListPanel The EventListPanel to which the new event will be added.
     */
    public AddEventModal(EventListPanel eventListPanel) {
        this.eventListPanel = eventListPanel;
        setTitle("Add Event");
        setSize(300, 200);
        setLayout(new GridLayout(6, 2));

        nameField = new JTextField();
        eventTypeDropdown = new JComboBox<>(new String[]{"Meeting", "Deadline"});
        dateTimeField = new JTextField("YYYY-MM-DD HH:MM");
        endDateTimeField = new JTextField("YYYY-MM-DD HH:MM");
        locationField = new JTextField();

        // Add components to the dialog
        add(new JLabel("Event Name:"));
        add(nameField);
        add(new JLabel("Event Type:"));
        add(eventTypeDropdown);
        add(new JLabel("Date & Time:"));
        add(dateTimeField);
        add(new JLabel("End Date & Time (Meetings Only):"));
        add(endDateTimeField);
        add(new JLabel("Location (Meetings Only):"));
        add(locationField);

        JButton addButton = new JButton("Add");
        addButton.addActionListener(e -> addEvent());

        add(addButton);
        setVisible(true);
    }

    /**
     * Adds a new event based on the input fields and adds it to the EventListPanel.
     */
    private void addEvent() {
        String name = nameField.getText();
        LocalDateTime dateTime = LocalDateTime.parse(dateTimeField.getText().replace(" ", "T"));

        if (eventTypeDropdown.getSelectedItem().equals("Meeting")) {
            LocalDateTime endDateTime = LocalDateTime.parse(endDateTimeField.getText().replace(" ", "T"));
            String location = locationField.getText();
            eventListPanel.addEvent(new Meeting(name, dateTime, endDateTime, location));
        } else {
            eventListPanel.addEvent(new Deadline(name, dateTime));
        }

        dispose(); // Close the dialog
    }
}

package Calendar;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Comparator;

/**
 * Class representing a panel that displays a list of events.
 * This class extends JPanel to provide a graphical user interface for managing events.
 */
public class EventListPanel extends JPanel {
    private ArrayList<Event> events; // List of events to be displayed
    private JPanel displayPanel; // Panel to display event panels
    private JComboBox<String> sortDropDown; // Dropdown menu for sorting events
    private JButton addEventButton; // Button to add a new event
    private JComboBox<String> filterDropDown; // Dropdown menu for filtering events
    private JButton clearFilterButton; // Button to clear filters

    /**
     * Constructor to initialize the EventListPanel.
     * Sets up the layout and adds control components.
     */
    public EventListPanel() {
        setLayout(new BorderLayout());

        events = new ArrayList<>();
        displayPanel = new JPanel();
        displayPanel.setLayout(new BoxLayout(displayPanel, BoxLayout.Y_AXIS));

        JPanel controlPanel = new JPanel();
        sortDropDown = new JComboBox<>(new String[]{"Sort by Name", "Sort by Date", "Sort by Name (Desc)", "Sort by Date (Desc)"});
        sortDropDown.addActionListener(e -> sortEvents());

        filterDropDown = new JComboBox<>(new String[]{"Show All", "Show Deadlines", "Show Meetings", "Show Completed"});
        filterDropDown.addActionListener(e -> refreshDisplay());

        clearFilterButton = new JButton("Clear Filters");
        clearFilterButton.addActionListener(e -> clearFilters());

        addEventButton = new JButton("Add Event");
        addEventButton.addActionListener(e -> new AddEventModal(this));

        controlPanel.add(sortDropDown);
        controlPanel.add(filterDropDown);
        controlPanel.add(clearFilterButton);
        controlPanel.add(addEventButton);

        add(controlPanel, BorderLayout.NORTH);
        add(new JScrollPane(displayPanel), BorderLayout.CENTER);
    }

    /**
     * Adds an event to the list and refreshes the display.
     *
     * @param event The event to be added.
     */
    public void addEvent(Event event) {
        events.add(event);
        refreshDisplay();
    }

    /**
     * Refreshes the display panel to show the filtered and sorted list of events.
     */
    private void refreshDisplay() {
        displayPanel.removeAll();
        String filter = (String) filterDropDown.getSelectedItem();

        for (Event event : events) {
            if (filter.equals("Show All") ||
                    (filter.equals("Show Deadlines") && event instanceof Deadline) ||
                    (filter.equals("Show Meetings") && event instanceof Meeting) ||
                    (filter.equals("Show Completed") && event instanceof Completable && ((Completable) event).isComplete())) {
                displayPanel.add(new EventPanel(event));
            }
        }

        displayPanel.revalidate();
        displayPanel.repaint();
    }

    /**
     * Clears the filters and shows all events.
     */
    private void clearFilters() {
        filterDropDown.setSelectedItem("Show All");
        refreshDisplay();
    }

    /**
     * Sorts the events based on the selected criteria from the dropdown menu.
     */
    private void sortEvents() {
        String selected = (String) sortDropDown.getSelectedItem();
        if (selected.equals("Sort by Name")) {
            events.sort(Comparator.comparing(Event::getName));
        } else if (selected.equals("Sort by Date")) {
            events.sort(Comparator.comparing(Event::getDateTime));
        } else if (selected.equals("Sort by Name (Desc)")) {
            events.sort(Comparator.comparing(Event::getName).reversed());
        } else if (selected.equals("Sort by Date (Desc)")) {
            events.sort(Comparator.comparing(Event::getDateTime).reversed());
        }
        refreshDisplay();
    }
}

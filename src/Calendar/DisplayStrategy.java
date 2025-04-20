package Calendar;

/**
 * Strategy interface for displaying an event.
 * Classes implementing this define how an event should be shown.
 */
public interface DisplayStrategy {
    void display(Event e); // Display method to be customized per strategy
}

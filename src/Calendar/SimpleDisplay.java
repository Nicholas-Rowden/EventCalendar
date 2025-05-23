package Calendar;

/**
 * A simple display strategy that only shows the event name.
 */
public class SimpleDisplay implements DisplayStrategy {
    public void display(Event e) {
        System.out.println("Event: " + e.getName());
    }
}

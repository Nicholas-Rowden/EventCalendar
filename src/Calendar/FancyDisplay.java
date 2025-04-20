package Calendar;

/**
 * A more detailed display strategy that shows the name and date of the event.
 */
public class FancyDisplay implements DisplayStrategy {
    public void display(Event e) {
        System.out.println("Event: " + e.getName() + " on " + e.getDateTime());
    }
}

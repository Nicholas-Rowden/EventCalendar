package Calendar;

public class FancyDisplay implements DisplayStrategy {
    public void display(Event e) {
        System.out.println("Event: " + e.getName() + " on " + e.getDateTime());
    }
}

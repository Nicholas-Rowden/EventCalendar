package Calendar;

public class SimpleDisplay implements DisplayStrategy {
    public void display(Event e) {
        System.out.println("Event: " + e.getName());
    }
}

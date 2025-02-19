package Calendar;

/**
 * Interface representing a completable task or event.
 */
public interface Completable {

    /**
     * Marks the task or event as complete.
     */
    void complete();

    /**
     * Checks whether the task or event is complete.
     *
     * @return true if the task or event is complete, false otherwise.
     */
    boolean isComplete();
}

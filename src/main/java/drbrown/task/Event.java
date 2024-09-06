package drbrown.task;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Represents an event task in the DrBrown application.
 * An event task has a description, a status (completed or not), a start date/time, and an end date/time.
 */
public class Event extends Task {

    private static final DateTimeFormatter FILE_DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HHmm");
    private final LocalDateTime startDateTime;
    private final LocalDateTime endDateTime;

    /**
     * Constructs an Event task with the specified status, description, start date/time, and end date/time.
     *
     * @param isCompleted  The completion status of the task (true if completed, false otherwise).
     * @param description  The description of the event.
     * @param start        The start date and time of the event.
     * @param end          The end date and time of the event.
     */
    public Event(boolean isCompleted, String description, LocalDateTime start, LocalDateTime end) {
        super(isCompleted, description);
        this.startDateTime = start;
        this.endDateTime = end;
    }

    /**
     * Returns the string representation of the event task in the format suitable for file storage.
     * The format includes the type of task (Event), its completion status, description,
     * start date/time, and end date/time, separated by vertical bars.
     *
     * @return A string formatted for file storage representing the event task.
     */
    @Override
    public String toFileString() {
        return "E | " + getStatus() + " | " + getDescription() + " | "
                + startDateTime.format(FILE_DATE_TIME_FORMATTER) + " | "
                + endDateTime.format(FILE_DATE_TIME_FORMATTER);
    }

    /**
     * Returns the string representation of the event task in the format suitable for UI display.
     * This method provides a user-friendly message to describe the scheduled event.
     *
     * @return A user-friendly string that describes the scheduled event.
     */
    @Override
    public String toUiString() {
        return "The appropriate question is: 'When the hell are they?' Your event is now set in time!\n";
    }

    /**
     * Returns the string representation of the event task for console or text display.
     * This format includes the type of task (Event), its completion status, description,
     * start date/time, and end date/time.
     *
     * @return A string representation of the event task with its status,
     *     description, start date/time, and end date/time.
     */
    @Override
    public String toString() {
        return "[E][" + (getStatus() ? "X" : " ") + "] " + getDescription()
                + " (from: " + startDateTime.format(DateTimeFormatter.ofPattern("MMM dd yyyy")) + " end: "
                + endDateTime.format(DateTimeFormatter.ofPattern("MMM dd yyyy HH:mm")) + ")";
    }
}

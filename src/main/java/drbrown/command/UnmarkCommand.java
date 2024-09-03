package drbrown.command;

import drbrown.task.Task;
import drbrown.utils.DrBrownException;
import drbrown.utils.Storage;
import drbrown.utils.TaskList;
import drbrown.utils.Ui;

import java.util.ArrayList;

/**
 * Represents a command to unmark a task as incomplete in the task list.
 */
public class UnmarkCommand extends Command {

    private final int itemIndex;

    /**
     * Constructs an UnmarkCommand with the specified index of the task to be marked as incomplete.
     *
     * @param itemIndex The index of the task to unmark as incomplete.
     */
    public UnmarkCommand(int itemIndex) {
        this.itemIndex = itemIndex;
    }

    /**
     * Executes the unmark command by setting the status of the task at the specified index to incomplete.
     * It displays the unmarked task and handles exceptions if the index is out of bounds.
     *
     * @param tasks   The TaskList containing the current tasks.
     * @param ui      The UI object to display messages to the user.
     * @param storage The Storage object for saving changes to the file (not used in this command).
     * @throws DrBrownException If the task index is invalid (out of bounds).
     */

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws DrBrownException {
        try {
            ArrayList<Task> list = tasks.getList();
            Task unmarkTask = list.get(itemIndex);
            unmarkTask.setStatus(false);
            ui.showUnmarkTask(unmarkTask);
        } catch (IndexOutOfBoundsException e) {
            throw new DrBrownException("You got the count wrong! That’s not how you calculate time travel – you're off by a few gigawatts!");
        }
    }

    /**
     * Indicates whether this command exits the program.
     *
     * @return false, as this command does not exit the program.
     */

    @Override
    public boolean isExit() {
        return false;
    }
}

package gitlet;

import java.util.Date;

/** Represents a gitlet commit object.
 *  TODO: It's a good idea to give a description here of what else this Class
 *  does at a high level.
 *
 *  @author TODO
 */
public class Commit {
    /**
     *
     * List all instance variables of the Commit class here with a useful
     * comment above them describing what that variable represents and how that
     * variable is used. We've provided one example for `message`.
     */

    /** The message of this Commit. */
    private String message;
    /** The id of this Commit. */
    private String id;
    /** The timestap of this Commit. */
    private Date timestap;
    /** The parent commits of this Commit. */
    private Commit parent_commit;

    public Commit(String msg, Date ts) {
        message = msg;
        timestap = ts;
    }
}

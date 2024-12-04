package gitlet;

import java.io.Serializable;

public class Blob implements Serializable {
    /** Represents a gitlet blob object.
     *  TODO: It's a good idea to give a description here of what else this Class
     *  does at a high level.
     *
     *  @author am1ao
     */

    /** id */
    private String id;
    private Byte[] content;
    private String filename;

    public Blob() {

    }

    public String get_id() {
        return id;
    }

    public String get_filename() {
        return filename;
    }
}

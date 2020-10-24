package org.roostify.endpoint.admin;

/**
 * @author lvenkateswaran
 * @since 10/22/2020
 * Refreshing / removing old files in a directory.
 */
public class CleanRequest {
    String dirName;

    public String getDirName() {
        return dirName;
    }

    public void setDirName(String dirName) {
        this.dirName = dirName;
    }
}

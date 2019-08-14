package com.junk.application;

/**
 *
 * @author Elmer
 */
public class DencFile {
    private String originalFileName;
    private String fileSize;
    private String password;
    private String tempFileName;

    public DencFile(String originalFileName, String fileSize, String password, String tempFileName ) {
        this.originalFileName = originalFileName;
        this.fileSize = fileSize;
        this.password = password;
        this.tempFileName = tempFileName;
    }

    public String getFileSize() {
        return fileSize;
    }

    public String getOriginalFileName() {
        return originalFileName;
    }

    public String getPassword() {
        return password;
    }

    public String getTempFileName() {
        return tempFileName;
    }
    

    public void setFileSize(String fileSize) {
        this.fileSize = fileSize;
    }

    public void setOriginalFileName(String originalFileName) {
        this.originalFileName = originalFileName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setTempFileName(String tempFileName) {
        this.tempFileName = tempFileName;
    }

    @Override
    public String toString() {
        return originalFileName + ":" + fileSize + ":" + password + ":" + tempFileName;
    }
    
    
}

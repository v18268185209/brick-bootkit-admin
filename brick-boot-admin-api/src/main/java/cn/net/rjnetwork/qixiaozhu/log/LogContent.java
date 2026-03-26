package cn.net.rjnetwork.qixiaozhu.log;

import java.util.List;

/**
 * Public log content model.
 */
public class LogContent {
    private String fileName;
    private String filePath;
    private long fileSize;
    private String encoding;
    private List<String> lines;
    private boolean truncated;
    private long totalLines;

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public long getFileSize() {
        return fileSize;
    }

    public void setFileSize(long fileSize) {
        this.fileSize = fileSize;
    }

    public String getEncoding() {
        return encoding;
    }

    public void setEncoding(String encoding) {
        this.encoding = encoding;
    }

    public List<String> getLines() {
        return lines;
    }

    public void setLines(List<String> lines) {
        this.lines = lines;
    }

    public boolean isTruncated() {
        return truncated;
    }

    public void setTruncated(boolean truncated) {
        this.truncated = truncated;
    }

    public long getTotalLines() {
        return totalLines;
    }

    public void setTotalLines(long totalLines) {
        this.totalLines = totalLines;
    }
}

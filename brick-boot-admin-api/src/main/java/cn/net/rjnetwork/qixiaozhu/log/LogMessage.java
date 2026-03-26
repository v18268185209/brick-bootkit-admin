package cn.net.rjnetwork.qixiaozhu.log;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Public SSE log message model.
 */
public class LogMessage {
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    private String type;
    private String fileName;
    private String content;
    private String timestamp;
    private boolean isNewFile;

    public LogMessage() {
        this.timestamp = FORMATTER.format(LocalDateTime.now());
    }

    public LogMessage(String type, String fileName, String content) {
        this.type = type;
        this.fileName = fileName;
        this.content = content;
        this.timestamp = FORMATTER.format(LocalDateTime.now());
    }

    public static LogMessage of(String type, String fileName, String content) {
        return new LogMessage(type, fileName, content);
    }

    public static LogMessage heartbeat() {
        LogMessage msg = new LogMessage();
        msg.setType("heartbeat");
        return msg;
    }

    public static LogMessage newFile(String fileName) {
        LogMessage msg = new LogMessage();
        msg.setType("newfile");
        msg.setFileName(fileName);
        msg.setNewFile(true);
        return msg;
    }

    public static LogMessage data(String fileName, String content) {
        return new LogMessage("data", fileName, content);
    }

    public static LogMessage error(String message) {
        return new LogMessage("error", null, message);
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public boolean isNewFile() {
        return isNewFile;
    }

    public void setNewFile(boolean newFile) {
        isNewFile = newFile;
    }
}

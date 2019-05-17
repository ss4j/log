package com.hfjy.frame.log.model;

public enum LogType {
    SYSTEM("system"), REQUEST("request"), SERVER("server"), SERVERERROR("serverError"),
    DB("db"), DB_ERROR("dbError"), STATISTICS("statistics"), MONITOR("mnitor"),
    TASK("task");
    private String name;

    LogType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static LogType getLogType(String typeStr) {
        LogType result = LogType.SYSTEM;
        for (LogType logType : LogType.values()) {
            if (logType.name == typeStr) {
                result = logType;
                break;
            }
        }
        return result;
    }
}

package com.hfjy.frame.log.model;

public class DBErrorLog  extends DBLog {

    public DBErrorLog(String dbType, String dsn, Long usedTime) {
        super(dbType, dsn, usedTime);
    }

    @Override
    public String getLogType() {
        return LogType.DB_ERROR.getName();
    }
}

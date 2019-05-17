package com.hfjy.frame.log.model;

public class DBLog extends AbstractCommonLogDefine {
    private String dbType;
    private String dsn;
    private String query;
    private String args;
    private Long usedTime;

    public DBLog(String dbType, String dsn, Long usedTime) {
        this.dbType = dbType;
        this.dsn = dsn;
        this.usedTime = usedTime;
    }

    public String getDbType() {
        return dbType;
    }

    public DBLog setDbType(String dbType) {
        this.dbType = dbType;
        return this;
    }

    public String getDsn() {
        return dsn;
    }

    public DBLog setDsn(String dsn) {
        this.dsn = dsn;
        return this;
    }

    public String getQuery() {
        return query;
    }

    public DBLog setQuery(String query) {
        this.query = query;
        return this;
    }

    public String getArgs() {
        return args;
    }

    public DBLog setArgs(String args) {
        this.args = args;
        return this;
    }

    public Long getUsedTime() {
        return usedTime;
    }

    public DBLog setUsedTime(Long usedTime) {
        this.usedTime = usedTime;
        return this;
    }

    @Override
    public void extend(AbstractBaseLogDefine define) {
        DBLog log = (DBLog)define;
        this.setDbType(log.getDbType()).setDsn(log.getDsn()).setQuery(log.getQuery()).setArgs(log.getArgs())
        .setUsedTime(log.getUsedTime());
    }

    @Override
    public String getLogType() {
        return LogType.DB.getName();
    }

    public static DBLog build(AbstractBaseLogDefine define) {
        return (DBLog)define;
    }
}

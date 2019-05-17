package com.hfjy.frame.log.model;

public class TaskLog extends AbstractCommonLogDefine {
    private String serverId;
    private String name;
    private boolean success;
    private long usedTime;
    private String memo;

    public TaskLog(String serverId, String name, boolean success, long usedTime) {
        this.serverId = serverId;
        this.name = name;
        this.success = success;
        this.usedTime = usedTime;
    }

    public String getServerId() {
        return serverId;
    }

    public TaskLog setServerId(String serverId) {
        this.serverId = serverId;
        return this;
    }

    public String getName() {
        return name;
    }

    public TaskLog setName(String name) {
        this.name = name;
        return this;
    }

    public boolean isSuccess() {
        return success;
    }

    public TaskLog setSuccess(boolean success) {
        this.success = success;
        return this;
    }

    public long getUsedTime() {
        return usedTime;
    }

    public TaskLog setUsedTime(long usedTime) {
        this.usedTime = usedTime;
        return this;
    }

    public String getMemo() {
        return memo;
    }

    public TaskLog setMemo(String memo) {
        this.memo = memo;
        return this;
    }

    @Override
    public void extend(AbstractBaseLogDefine define) {
        TaskLog log = (TaskLog)define;
        this.setServerId(log.getServerId()).setName(log.getName()).setSuccess(log.isSuccess())
                .setUsedTime(log.getUsedTime()).setMemo(log.getMemo());
    }

    @Override
    public String getLogType() {
        return LogType.TASK.getName();
    }

    public static TaskLog build(AbstractBaseLogDefine define) {
        return (TaskLog)define;
    }
}

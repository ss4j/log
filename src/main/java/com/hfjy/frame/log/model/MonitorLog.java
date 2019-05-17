package com.hfjy.frame.log.model;

public class MonitorLog extends AbstractCommonLogDefine {
    private String name;
    private String target;
    private String targetInfo;
    private String expect;
    private String result;
    private boolean isSuccess;
    private Long usedTime;
    private String memo;

    public MonitorLog(String name, String target, String targetInfo, String expect, String result, boolean isSuccess, Long usedTime) {
        this.name = name;
        this.target = target;
        this.targetInfo = targetInfo;
        this.expect = expect;
        this.result = result;
        this.isSuccess = isSuccess;
        this.usedTime = usedTime;
    }

    public String getName() {
        return name;
    }

    public MonitorLog setName(String name) {
        this.name = name;
        return this;
    }

    public String getTarget() {
        return target;
    }

    public MonitorLog setTarget(String target) {
        this.target = target;
        return this;
    }

    public String getTargetInfo() {
        return targetInfo;
    }

    public MonitorLog setTargetInfo(String targetInfo) {
        this.targetInfo = targetInfo;
        return this;
    }

    public String getExpect() {
        return expect;
    }

    public MonitorLog setExpect(String expect) {
        this.expect = expect;
        return this;
    }

    public String getResult() {
        return result;
    }

    public MonitorLog setResult(String result) {
        this.result = result;
        return this;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public MonitorLog setSuccess(boolean success) {
        isSuccess = success;
        return this;
    }

    public Long getUsedTime() {
        return usedTime;
    }

    public MonitorLog setUsedTime(Long usedTime) {
        this.usedTime = usedTime;
        return this;
    }

    public String getMemo() {
        return memo;
    }

    public MonitorLog setMemo(String memo) {
        this.memo = memo;
        return this;
    }

    @Override
    public void extend(AbstractBaseLogDefine define) {
        MonitorLog log = (MonitorLog)define;
        this.setName(log.getName()).setTarget(log.getTarget()).setTargetInfo(log.getTargetInfo())
                .setExpect(log.getExpect()).setResult(log.getResult()).setSuccess(log.isSuccess)
                .setUsedTime(log.getUsedTime()).setMemo(log.getMemo());
    }

    @Override
    public String getLogType() {
        return LogType.MONITOR.getName();
    }

    public static MonitorLog build(AbstractBaseLogDefine define) {
        return (MonitorLog)define;
    }
}

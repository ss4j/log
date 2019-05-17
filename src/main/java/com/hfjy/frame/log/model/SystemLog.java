package com.hfjy.frame.log.model;

public class SystemLog extends AbstractCommonLogDefine {
    private String callStacks;

    public String getCallStacks() {
        return callStacks;
    }

    public SystemLog setCallStacks(String callStacks) {
        this.callStacks = callStacks;
        return this;
    }

    @Override
    public String getLogType() {
        return LogType.SYSTEM.getName();
    }

    @Override
    public void extend(AbstractBaseLogDefine define) {
        SystemLog log = (SystemLog)define;
        this.setCallStacks(log.getCallStacks());
    }

    public static SystemLog build(AbstractBaseLogDefine define) {
        return (SystemLog)define;
    }
}

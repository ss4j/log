package com.hfjy.frame.log.model;

import com.hfjy.frame.log.common.BaseLogAction;

public abstract class AbstractBaseLogDefine implements BaseLogAction {
    protected String logType;
    protected String level;
    protected String msg;

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public abstract void extend(AbstractBaseLogDefine define);

    public static <T extends AbstractBaseLogDefine> T build(AbstractBaseLogDefine define) {
        return (T)define;
    }
}

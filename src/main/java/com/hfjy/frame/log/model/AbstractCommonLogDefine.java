package com.hfjy.frame.log.model;

import com.alibaba.fastjson.JSON;
import com.hfjy.frame.log.vo.AppConfig;

public abstract class AbstractCommonLogDefine extends AbstractBaseLogDefine {
    protected String logTime;
    protected String traceId;

    public AbstractCommonLogDefine() {
        this.logType = getLogType();
    }


    public String getLogTime() {
        return logTime;
    }

    public AbstractCommonLogDefine setLogTime(String logTime) {
        this.logTime = logTime;
        return this;
    }

    public String getTraceId() {
        return traceId;
    }

    public AbstractCommonLogDefine setTraceId(String traceId) {
        this.traceId = traceId;
        return this;
    }

    @Override
    public String toJson() {
        return JSON.toJSONString(this);
    }
}

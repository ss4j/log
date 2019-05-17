package com.hfjy.frame.log.model;

import com.alibaba.fastjson.JSON;
import com.hfjy.frame.log.vo.AppConfig;

public abstract class AbstractCommonLogDefine extends AbstractBaseLogDefine {
    protected String appImage;
    protected String appVersion;
    protected String serverName;
    protected String serverIp;
    protected String logTime;
    protected String traceId;

    public AbstractCommonLogDefine() {
        this.logType = getLogType();
    }

    public AbstractCommonLogDefine(AppConfig config) {
        this.appImage  = config.getAppImage();
        this.appVersion = config.getAppVersion();
        this.serverName = config.getServerName();
        this.serverIp = config.getServerIp();
        this.logType = getLogType();
    }

    public String getAppImage() {
        return appImage;
    }

    public AbstractCommonLogDefine setAppImage(String appImage) {
        this.appImage = appImage;
        return this;
    }

    public String getAppVersion() {
        return appVersion;
    }

    public AbstractCommonLogDefine setAppVersion(String appVersion) {
        this.appVersion = appVersion;
        return this;
    }

    public String getServerName() {
        return serverName;
    }

    public AbstractCommonLogDefine setServerName(String serverName) {
        this.serverName = serverName;
        return this;
    }

    public String getServerIp() {
        return serverIp;
    }

    public AbstractCommonLogDefine setServerIp(String serverIp) {
        this.serverIp = serverIp;
        return this;
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

    public AbstractCommonLogDefine init(AppConfig appConfig) {
        setServerIp(appConfig.getServerIp()).setAppImage(appConfig.getAppImage())
                .setAppVersion(appConfig.getAppVersion()).setServerName(appConfig.getServerName());
        return this;
    }
}

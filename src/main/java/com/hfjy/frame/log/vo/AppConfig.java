package com.hfjy.frame.log.vo;

public class AppConfig {
    private String appImage;
    private String appVersion;
    private String serverName;
    private String serverIp;

    public AppConfig() {
    }

    public AppConfig(String appImage, String appVersion, String serverName, String serverIp) {
        this.appImage = appImage;
        this.appVersion = appVersion;
        this.serverName = serverName;
        this.serverIp = serverIp;
    }

    public String getAppImage() {
        return appImage;
    }

    public AppConfig setAppImage(String appImage) {
        this.appImage = appImage;
        return this;
    }

    public String getAppVersion() {
        return appVersion;
    }

    public AppConfig setAppVersion(String appVersion) {
        this.appVersion = appVersion;
        return this;
    }

    public String getServerName() {
        return serverName;
    }

    public AppConfig setServerName(String serverName) {
        this.serverName = serverName;
        return this;
    }

    public String getServerIp() {
        return serverIp;
    }

    public AppConfig setServerIp(String serverIp) {
        this.serverIp = serverIp;
        return this;
    }
}

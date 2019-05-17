package com.hfjy.frame.log.model;

public class ServerLog extends AbstractCommonLogDefine {
    private Integer weight;
    private String node;
    private String proto;
    private Long startTime;

    public ServerLog(String node, String proto, Long startTime) {
        this.node = node;
        this.proto = proto;
        this.startTime = startTime;
    }

    public Integer getWeight() {
        return weight;
    }

    public ServerLog setWeight(Integer weight) {
        this.weight = weight;
        return this;
    }

    public String getNode() {
        return node;
    }

    public ServerLog setNode(String node) {
        this.node = node;
        return this;
    }

    public String getProto() {
        return proto;
    }

    public ServerLog setProto(String proto) {
        this.proto = proto;
        return this;
    }

    public Long getStartTime() {
        return startTime;
    }

    public ServerLog setStartTime(Long startTime) {
        this.startTime = startTime;
        return this;
    }

    @Override
    public String getLogType() {
        return LogType.SERVER.getName();
    }

    @Override
    public void extend(AbstractBaseLogDefine define) {
        ServerLog serverLog = (ServerLog)define;
        this.setWeight(serverLog.getWeight()).setNode(serverLog.getNode()).setProto(serverLog.getProto())
                .setStartTime(serverLog.getStartTime());
    }

    public static ServerLog build(AbstractBaseLogDefine define) {
        return (ServerLog)define;
    }
}

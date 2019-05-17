package com.hfjy.frame.log.model;

public class StatisticsLog extends AbstractCommonLogDefine {
    private String serverId;
    private String name;
    private Long startTime;
    private Long endTime;
    private Integer total;
    private Integer failed;
    private Long avgTime;
    private Long minTime;
    private Long maxTime;

    public StatisticsLog(String serverId, String name, Long startTime, Long endTime) {
        this.serverId = serverId;
        this.name = name;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public String getServerId() {
        return serverId;
    }

    public StatisticsLog setServerId(String serverId) {
        this.serverId = serverId;
        return this;
    }

    public String getName() {
        return name;
    }

    public StatisticsLog setName(String name) {
        this.name = name;
        return this;
    }

    public Long getStartTime() {
        return startTime;
    }

    public StatisticsLog setStartTime(Long startTime) {
        this.startTime = startTime;
        return this;
    }

    public Long getEndTime() {
        return endTime;
    }

    public StatisticsLog setEndTime(Long endTime) {
        this.endTime = endTime;
        return this;
    }

    public Integer getTotal() {
        return total;
    }

    public StatisticsLog setTotal(Integer total) {
        this.total = total;
        return this;
    }

    public Integer getFailed() {
        return failed;
    }

    public StatisticsLog setFailed(Integer failed) {
        this.failed = failed;
        return this;
    }

    public Long getAvgTime() {
        return avgTime;
    }

    public StatisticsLog setAvgTime(Long avgTime) {
        this.avgTime = avgTime;
        return this;
    }

    public Long getMinTime() {
        return minTime;
    }

    public StatisticsLog setMinTime(Long minTime) {
        this.minTime = minTime;
        return this;
    }

    public Long getMaxTime() {
        return maxTime;
    }

    public StatisticsLog setMaxTime(Long maxTime) {
        this.maxTime = maxTime;
        return this;
    }

    // 说明文档中要求没有该字段，因此置空。
    @Override
    public String getMsg() {
        return null;
    }

    @Override
    public void extend(AbstractBaseLogDefine define) {
        StatisticsLog log = (StatisticsLog)define;
        this.setServerId(log.getServerId()).setName(log.getName()).setStartTime(log.getStartTime())
        .setEndTime(log.getEndTime()).setTotal(log.getTotal()).setFailed(log.getFailed())
        .setAvgTime(log.getAvgTime()).setMinTime(log.getMinTime()).setMaxTime(log.getMaxTime());
    }

    @Override
    public String getLogType() {
        return LogType.STATISTICS.getName();
    }

    public static StatisticsLog build(AbstractBaseLogDefine define) {
        return (StatisticsLog)define;
    }
}

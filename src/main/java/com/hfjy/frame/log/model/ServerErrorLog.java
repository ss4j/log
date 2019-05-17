package com.hfjy.frame.log.model;

public class ServerErrorLog extends ServerLog {
    public ServerErrorLog(String node, String proto, Long startTime) {
        super(node, proto, startTime);
    }

    @Override
    public String getLogType() {
        return LogType.SERVERERROR.getName();
    }

    public static ServerErrorLog build(AbstractBaseLogDefine define) {
        return (ServerErrorLog)define;
    }
}

package com.hfjy.frame.log.common;

import com.alibaba.fastjson.JSON;
import com.hfjy.frame.log.model.*;
import com.hfjy.frame.log.vo.AppConfig;

public class CustomLogFactory {
    public static String formatToJSON(AppConfig appConfig, AbstractBaseLogDefine logInfo) {
        AbstractCommonLogDefine logDefine;
        if (logInfo != null) {
            LogType logType = LogType.getLogType(logInfo.getLogType());
            switch (logType) {
                case SYSTEM:
                    logDefine = SystemLog.build(logInfo);
                    break;
                case SERVER:
                    logDefine = ServerLog.build(logInfo);
                    break;
                case SERVERERROR:
                    logDefine = ServerErrorLog.build(logInfo);
                    break;
                case DB:
                    logDefine = DBLog.build(logInfo);
                    break;
                case DB_ERROR:
                    logDefine = DBErrorLog.build(logInfo);
                    break;
                case REQUEST:
                    logDefine = RequestLog.build(logInfo);
                    break;
                case TASK:
                    logDefine = TaskLog.build(logInfo);
                    break;
                default:
                    logDefine = SystemLog.build(logInfo);
            }
        } else {
            logDefine = SystemLog.build(logInfo);
        }
        logDefine.init(appConfig).extend(logInfo);
        return JSON.toJSONString(logDefine);
    }
}

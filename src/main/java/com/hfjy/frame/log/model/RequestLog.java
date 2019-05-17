package com.hfjy.frame.log.model;

/**
 * 记录服务处理请求、响应日志
 */
public class RequestLog extends AbstractCommonLogDefine {
    private String sessionId;
    private String clientId;
    private String clientIp;
    private String app;
    private String host;
    private String method;
    private String path;
    private String handle;
    private String requestId;
    private String requestHeaders;
    private String requestData;
    private Integer priority;
    private Integer authLevel;
    private String responseCode;
    private String responseData;
    private String responseDataLength;
    private String responseHeaders;
    private Long usedTime;
    private String fromApp;
    private String fromNode;

    public RequestLog(String clientIp, String host, String method, String path, String handle, String responseCode) {
        this.clientIp = clientIp;
        this.host = host;
        this.method = method;
        this.path = path;
        this.handle = handle;
        this.responseCode = responseCode;
    }

    public String getSessionId() {
        return sessionId;
    }

    public RequestLog setSessionId(String sessionId) {
        this.sessionId = sessionId;
        return this;
    }

    public String getClientId() {
        return clientId;
    }

    public RequestLog setClientId(String clientId) {
        this.clientId = clientId;
        return this;
    }

    public String getClientIp() {
        return clientIp;
    }

    public RequestLog setClientIp(String clientIp) {
        this.clientIp = clientIp;
        return this;
    }

    public String getApp() {
        return app;
    }

    public RequestLog setApp(String app) {
        this.app = app;
        return this;
    }

    public String getHost() {
        return host;
    }

    public RequestLog setHost(String host) {
        this.host = host;
        return this;
    }

    public String getMethod() {
        return method;
    }

    public RequestLog setMethod(String method) {
        this.method = method;
        return this;
    }

    public String getPath() {
        return path;
    }

    public RequestLog setPath(String path) {
        this.path = path;
        return this;
    }

    public String getHandle() {
        return handle;
    }

    public RequestLog setHandle(String handle) {
        this.handle = handle;
        return this;
    }

    public String getRequestId() {
        return requestId;
    }

    public RequestLog setRequestId(String requestId) {
        this.requestId = requestId;
        return this;
    }

    public String getRequestHeaders() {
        return requestHeaders;
    }

    public RequestLog setRequestHeaders(String requestHeaders) {
        this.requestHeaders = requestHeaders;
        return this;
    }

    public String getRequestData() {
        return requestData;
    }

    public RequestLog setRequestData(String requestData) {
        this.requestData = requestData;
        return this;
    }

    public Integer getPriority() {
        return priority;
    }

    public RequestLog setPriority(Integer priority) {
        this.priority = priority;
        return this;
    }

    public Integer getAuthLevel() {
        return authLevel;
    }

    public RequestLog setAuthLevel(Integer authLevel) {
        this.authLevel = authLevel;
        return this;
    }

    public String getResponseCode() {
        return responseCode;
    }

    public RequestLog setResponseCode(String responseCode) {
        this.responseCode = responseCode;
        return this;
    }

    public String getResponseData() {
        return responseData;
    }

    public RequestLog setResponseData(String responseData) {
        this.responseData = responseData;
        return this;
    }

    public String getResponseDataLength() {
        return responseDataLength;
    }

    public RequestLog setResponseDataLength(String responseDataLength) {
        this.responseDataLength = responseDataLength;
        return this;
    }

    public String getResponseHeaders() {
        return responseHeaders;
    }

    public RequestLog setResponseHeaders(String responseHeaders) {
        this.responseHeaders = responseHeaders;
        return this;
    }

    public Long getUsedTime() {
        return usedTime;
    }

    public RequestLog setUsedTime(Long usedTime) {
        this.usedTime = usedTime;
        return this;
    }

    public String getFromApp() {
        return fromApp;
    }

    public RequestLog setFromApp(String fromApp) {
        this.fromApp = fromApp;
        return this;
    }

    public String getFromNode() {
        return fromNode;
    }

    public RequestLog setFromNode(String fromNode) {
        this.fromNode = fromNode;
        return this;
    }

    @Override
    public void extend(AbstractBaseLogDefine define) {
        RequestLog log = (RequestLog)define;
        this.setSessionId(log.getSessionId()).setClientId(log.getClientId()).setClientIp(log.getClientIp())
                .setApp(log.getApp()).setHost(log.getHost()).setMethod(log.getMethod())
                .setPath(log.getPath()).setHandle(log.getHandle()).setRequestId(log.getRequestId())
                .setRequestHeaders(log.getRequestHeaders()).setRequestData(log.getRequestData())
                .setPriority(log.getPriority()).setAuthLevel(log.getAuthLevel())
                .setResponseCode(log.getResponseCode()).setResponseData(log.getResponseData())
                .setResponseDataLength(log.getResponseDataLength()).setResponseHeaders(log.getResponseHeaders())
                .setUsedTime(log.getUsedTime()).setFromApp(log.getFromApp()).setFromNode(log.getFromNode());
    }

    @Override
    public String getLogType() {
        return LogType.REQUEST.getName();
    }

    public static RequestLog build(AbstractBaseLogDefine define) {
        return (RequestLog)define;
    }
}

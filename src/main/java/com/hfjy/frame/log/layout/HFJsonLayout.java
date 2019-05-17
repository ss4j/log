package com.hfjy.frame.log.layout;

import com.hfjy.frame.log.common.CustomLogFactory;
import com.hfjy.frame.log.model.AbstractBaseLogDefine;
import com.hfjy.frame.log.model.SystemLog;
import com.hfjy.frame.log.vo.AppConfig;
import org.apache.logging.log4j.core.Layout;
import org.apache.logging.log4j.core.LogEvent;
import org.apache.logging.log4j.core.config.Configuration;
import org.apache.logging.log4j.core.config.Node;
import org.apache.logging.log4j.core.config.plugins.*;
import org.apache.logging.log4j.core.layout.AbstractStringLayout;
import org.apache.logging.log4j.core.layout.PatternLayout;
import org.apache.logging.log4j.core.layout.PatternSelector;
import org.apache.logging.log4j.core.pattern.RegexReplacement;

import java.nio.charset.Charset;

/**
 * 定义log4j2的layout，输出自定义json(官方提供的JsonLayout无法满足公司需求)
 */
@Plugin(name = "HFJsonLayout", category = Node.CATEGORY, elementType = Layout.ELEMENT_TYPE, printObject = true)
public class HFJsonLayout extends AbstractStringLayout {
    private PatternLayout patternLayout;
    private AppConfig appConfig;

    private HFJsonLayout(Configuration config, RegexReplacement replace, String eventPattern,
                              PatternSelector patternSelector, Charset charset, boolean alwaysWriteExceptions,
                              boolean noConsoleNoAnsi, String headerPattern, String footerPattern,
                         AppConfig appConfig) {
        super(config, charset, PatternLayout.newSerializerBuilder().setConfiguration(config).setReplace(replace)
                .setPattern(headerPattern).setPatternSelector(patternSelector).setAlwaysWriteExceptions(alwaysWriteExceptions)
                .setNoConsoleNoAnsi(noConsoleNoAnsi).build(), PatternLayout.newSerializerBuilder().setConfiguration(config).setReplace(replace)
                .setPattern(footerPattern).setPatternSelector(patternSelector).setAlwaysWriteExceptions(alwaysWriteExceptions)
                .setNoConsoleNoAnsi(noConsoleNoAnsi).build());
        this.appConfig = appConfig;

        this.patternLayout = PatternLayout.newBuilder()
                .withPattern(eventPattern)
                .withPatternSelector(patternSelector)
                .withConfiguration(config)
                .withRegexReplacement(replace)
                .withAlwaysWriteExceptions(alwaysWriteExceptions)
                .withHeader(headerPattern)
                .withFooter(footerPattern)
                .withNoConsoleNoAnsi(noConsoleNoAnsi)
                .build();
    }


    // 通过从log的参数获取业务相关log信息
    // 在获取后，最后一个参数为业务消息参数，如果没有，则为默认系统类型
    // 通过给定的业务log类型进行不同处理，最后转换为json字符串
    @Override
    public String toSerializable(LogEvent event) {
        String message = patternLayout.toSerializable(event);
        AbstractBaseLogDefine logInfo = null;
        if (event.getMessage() != null && event.getMessage().getParameters() != null && event.getMessage().getParameters().length > 0) {
            Object obj = event.getMessage().getParameters()[event.getMessage().getParameters().length - 1];
            if (obj instanceof AbstractBaseLogDefine) {
                logInfo = (AbstractBaseLogDefine) obj;
            } else {
                logInfo = new SystemLog();
            }
        } else {
            logInfo = new SystemLog();
        }
        logInfo.setLevel(event.getLevel().name().toLowerCase());
        logInfo.setMsg(message);

        String jsonStr = CustomLogFactory.formatToJSON(appConfig, logInfo);
        return jsonStr + "\n";
    }

    @PluginFactory
    public static HFJsonLayout createLayout(
            @PluginAttribute(value = "pattern", defaultString = PatternLayout.DEFAULT_CONVERSION_PATTERN) final String pattern,
            @PluginElement("PatternSelector") final PatternSelector patternSelector,
            @PluginConfiguration final Configuration config,
            @PluginElement("Replace") final RegexReplacement replace,
            @PluginAttribute(value = "charset") final Charset charset,
            @PluginAttribute(value = "alwaysWriteExceptions", defaultBoolean = true) final boolean alwaysWriteExceptions,
            @PluginAttribute(value = "noConsoleNoAnsi", defaultBoolean = false) final boolean noConsoleNoAnsi,
            @PluginAttribute("header") final String headerPattern,
            @PluginAttribute("footer") final String footerPattern,
            @PluginAttribute("appVersion") final String appVersion,
            @PluginAttribute("serverName") final String serverName,
            @PluginAttribute("appImage") final String appImage,
            @PluginAttribute("serverIp") final String serverIp
    ) {
        AppConfig appConfig = new AppConfig(appImage, appVersion, serverName, serverIp);
        return new HFJsonLayout(config, replace, pattern, patternSelector, charset, alwaysWriteExceptions,
                noConsoleNoAnsi, headerPattern, footerPattern, appConfig);
    }
}

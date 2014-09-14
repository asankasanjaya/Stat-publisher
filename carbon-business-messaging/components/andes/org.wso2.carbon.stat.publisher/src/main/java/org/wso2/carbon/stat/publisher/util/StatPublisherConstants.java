package org.wso2.carbon.stat.publisher.util;

import org.wso2.carbon.core.RegistryResources;

import java.io.File;

public final class StatPublisherConstants {
    public static final String RESOURCE = "StatisticConfiguration";
    public static final String ENABLE_STAT_PUBLISHER = "enableStatPublisher";
    public static final String USER_NAME = "username";
    public static final String PASSWORD = "password";
    public static final String URL = "url";
    public static final String MB_STAT_ENABLE = "mbStatEnable";
    public static final String MESSAGE_STAT_ENABLE = "messageStatEnable";
    public static final String SYSTEM_STAT_ENABLE = "systemStatEnable";
    public static final String MEDIATION_STATISTICS_REG_PATH =
            RegistryResources.COMPONENTS + "org.wso2.carbon.stat.publisher/messageBrokerStats/";
    public static final String JMX_XML = "jmx.xml";
    public static final String CARBON_XML = "carbon.xml";
    public static final String STAT_CONF_XML = "mbStatConfiguration.xml";
    public static final String CONF_DIRECTORY_PATH = "repository"+ File.separator+"conf"+File.separator;
    public static final String JMX_DIRECTORY_PATH = "repository"+ File.separator+"conf"+File.separator+"etc"+File.separator;

}
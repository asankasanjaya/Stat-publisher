/*
 *  Licensed to the Apache Software Foundation (ASF) under one
 *  or more contributor license agreements.  See the NOTICE file
 *  distributed with this work for additional information
 *  regarding copyright ownership.  The ASF licenses this file
 *  to you under the Apache License, Version 2.0 (the
 *  "License"); you may not use this file except in compliance
 *  with the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing,
 *  software distributed under the License is distributed on an
 *  "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *  KIND, either express or implied.  See the License for the
 *  specific language governing permissions and limitations
 *  under the License.
 *
 *
 */
package org.wso2.andes.server.logging.messages;

import static org.wso2.andes.server.logging.AbstractRootMessageLogger.DEFAULT_LOG_HIERARCHY_PREFIX;

import org.apache.log4j.Logger;
import org.wso2.andes.server.logging.LogMessage;
import org.wso2.andes.server.registry.ApplicationRegistry;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Generated Using GeneratedLogMessages and LogMessages.vm
 *
 * This file is based on the content of LogMessages.properties
 *
 * It is generated so that we can provide compile time validation of the
 * message parameters.
 *
 * DO NOT EDIT DIRECTLY THIS FILE IS GENERATED.
 *
 */
public class MessageStoreMessages
{
    static ResourceBundle _messages;
    static Locale _currentLocale;
    
    public static final String MESSAGESTORE_LOG_HIERARCHY = DEFAULT_LOG_HIERARCHY_PREFIX + "messagestore";
    public static final String CLOSED_LOG_HIERARCHY = DEFAULT_LOG_HIERARCHY_PREFIX + "messagestore.closed";
    public static final String RECOVERY_COMPLETE_LOG_HIERARCHY = DEFAULT_LOG_HIERARCHY_PREFIX + "messagestore.recovery_complete";
    public static final String RECOVERED_LOG_HIERARCHY = DEFAULT_LOG_HIERARCHY_PREFIX + "messagestore.recovered";
    public static final String CREATED_LOG_HIERARCHY = DEFAULT_LOG_HIERARCHY_PREFIX + "messagestore.created";
    public static final String STORE_LOCATION_LOG_HIERARCHY = DEFAULT_LOG_HIERARCHY_PREFIX + "messagestore.store_location";
    public static final String RECOVERY_START_LOG_HIERARCHY = DEFAULT_LOG_HIERARCHY_PREFIX + "messagestore.recovery_start";

    static
    {
        Logger.getLogger(MESSAGESTORE_LOG_HIERARCHY);
        Logger.getLogger(CLOSED_LOG_HIERARCHY);
        Logger.getLogger(RECOVERY_COMPLETE_LOG_HIERARCHY);
        Logger.getLogger(RECOVERED_LOG_HIERARCHY);
        Logger.getLogger(CREATED_LOG_HIERARCHY);
        Logger.getLogger(STORE_LOCATION_LOG_HIERARCHY);
        Logger.getLogger(RECOVERY_START_LOG_HIERARCHY);

        reload();
    }

    public static void reload()
    {
        if (ApplicationRegistry.isConfigured())
        {
            _currentLocale = ApplicationRegistry.getInstance().getConfiguration().getLocale();
        }
        else
        {
            _currentLocale = Locale.getDefault();
        }

        _messages = ResourceBundle.getBundle("org.wso2.andes.server.logging.messages.MessageStore_logmessages", _currentLocale);
    }


    /**
     * Log a MessageStore message of the Format:
     * <pre>MST-1003 : Closed</pre>
     * Optional values are contained in [square brackets] and are numbered
     * sequentially in the method call.
     *
     */
    public static LogMessage CLOSED()
    {
        String rawMessage = _messages.getString("CLOSED");

        final String message = rawMessage;

        return new LogMessage()
        {
            public String toString()
            {
                return message;
            }
            
            public String getLogHierarchy()
            {
                return CLOSED_LOG_HIERARCHY;
            }
        };
    }

    /**
     * Log a MessageStore message of the Format:
     * <pre>MST-1006 : Recovery Complete</pre>
     * Optional values are contained in [square brackets] and are numbered
     * sequentially in the method call.
     *
     */
    public static LogMessage RECOVERY_COMPLETE()
    {
        String rawMessage = _messages.getString("RECOVERY_COMPLETE");

        final String message = rawMessage;

        return new LogMessage()
        {
            public String toString()
            {
                return message;
            }
            
            public String getLogHierarchy()
            {
                return RECOVERY_COMPLETE_LOG_HIERARCHY;
            }
        };
    }

    /**
     * Log a MessageStore message of the Format:
     * <pre>MST-1005 : Recovered {0,number} messages</pre>
     * Optional values are contained in [square brackets] and are numbered
     * sequentially in the method call.
     *
     */
    public static LogMessage RECOVERED(Number param1)
    {
        String rawMessage = _messages.getString("RECOVERED");

        final Object[] messageArguments = {param1};
        // Create a new MessageFormat to ensure thread safety.
        // Sharing a MessageFormat and using applyPattern is not thread safe
        MessageFormat formatter = new MessageFormat(rawMessage, _currentLocale);

        final String message = formatter.format(messageArguments);

        return new LogMessage()
        {
            public String toString()
            {
                return message;
            }
            
            public String getLogHierarchy()
            {
                return RECOVERED_LOG_HIERARCHY;
            }
        };
    }

    /**
     * Log a MessageStore message of the Format:
     * <pre>MST-1001 : Created : {0}</pre>
     * Optional values are contained in [square brackets] and are numbered
     * sequentially in the method call.
     *
     */
    public static LogMessage CREATED(String param1)
    {
        String rawMessage = _messages.getString("CREATED");

        final Object[] messageArguments = {param1};
        // Create a new MessageFormat to ensure thread safety.
        // Sharing a MessageFormat and using applyPattern is not thread safe
        MessageFormat formatter = new MessageFormat(rawMessage, _currentLocale);

        final String message = formatter.format(messageArguments);

        return new LogMessage()
        {
            public String toString()
            {
                return message;
            }
            
            public String getLogHierarchy()
            {
                return CREATED_LOG_HIERARCHY;
            }
        };
    }

    /**
     * Log a MessageStore message of the Format:
     * <pre>MST-1002 : Store location : {0}</pre>
     * Optional values are contained in [square brackets] and are numbered
     * sequentially in the method call.
     *
     */
    public static LogMessage STORE_LOCATION(String param1)
    {
        String rawMessage = _messages.getString("STORE_LOCATION");

        final Object[] messageArguments = {param1};
        // Create a new MessageFormat to ensure thread safety.
        // Sharing a MessageFormat and using applyPattern is not thread safe
        MessageFormat formatter = new MessageFormat(rawMessage, _currentLocale);

        final String message = formatter.format(messageArguments);

        return new LogMessage()
        {
            public String toString()
            {
                return message;
            }
            
            public String getLogHierarchy()
            {
                return STORE_LOCATION_LOG_HIERARCHY;
            }
        };
    }

    /**
     * Log a MessageStore message of the Format:
     * <pre>MST-1004 : Recovery Start</pre>
     * Optional values are contained in [square brackets] and are numbered
     * sequentially in the method call.
     *
     */
    public static LogMessage RECOVERY_START()
    {
        String rawMessage = _messages.getString("RECOVERY_START");

        final String message = rawMessage;

        return new LogMessage()
        {
            public String toString()
            {
                return message;
            }
            
            public String getLogHierarchy()
            {
                return RECOVERY_START_LOG_HIERARCHY;
            }
        };
    }


}

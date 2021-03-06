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
public class ExchangeMessages
{
    static ResourceBundle _messages;
    static Locale _currentLocale;
    
    public static final String EXCHANGE_LOG_HIERARCHY = DEFAULT_LOG_HIERARCHY_PREFIX + "exchange";
    public static final String CREATED_LOG_HIERARCHY = DEFAULT_LOG_HIERARCHY_PREFIX + "exchange.created";
    public static final String DELETED_LOG_HIERARCHY = DEFAULT_LOG_HIERARCHY_PREFIX + "exchange.deleted";

    static
    {
        Logger.getLogger(EXCHANGE_LOG_HIERARCHY);
        Logger.getLogger(CREATED_LOG_HIERARCHY);
        Logger.getLogger(DELETED_LOG_HIERARCHY);

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

        _messages = ResourceBundle.getBundle("org.wso2.andes.server.logging.messages.Exchange_logmessages", _currentLocale);
    }


    /**
     * Log a Exchange message of the Format:
     * <pre>EXH-1001 : Create :[ Durable] Type: {0} Name: {1}</pre>
     * Optional values are contained in [square brackets] and are numbered
     * sequentially in the method call.
     *
     */
    public static LogMessage CREATED(String param1, String param2, boolean opt1)
    {
        String rawMessage = _messages.getString("CREATED");
        StringBuffer msg = new StringBuffer();

        // Split the formatted message up on the option values so we can
        // rebuild the message based on the configured options.
        String[] parts = rawMessage.split("\\[");
        msg.append(parts[0]);

        int end;
        if (parts.length > 1)
        {

            // Add Option : Durable
            end = parts[1].indexOf(']');
            if (opt1)
            {
                msg.append(parts[1].substring(0, end));
            }

            // Use 'end + 1' to remove the ']' from the output
            msg.append(parts[1].substring(end + 1));
        }

        rawMessage = msg.toString();

        final Object[] messageArguments = {param1, param2};
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
     * Log a Exchange message of the Format:
     * <pre>EXH-1002 : Deleted</pre>
     * Optional values are contained in [square brackets] and are numbered
     * sequentially in the method call.
     *
     */
    public static LogMessage DELETED()
    {
        String rawMessage = _messages.getString("DELETED");

        final String message = rawMessage;

        return new LogMessage()
        {
            public String toString()
            {
                return message;
            }
            
            public String getLogHierarchy()
            {
                return DELETED_LOG_HIERARCHY;
            }
        };
    }


}

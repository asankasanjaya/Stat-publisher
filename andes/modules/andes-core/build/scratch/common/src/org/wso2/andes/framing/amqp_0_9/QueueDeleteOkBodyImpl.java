



/*
 *
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 *
 */

/*
 * This file is auto-generated by Qpid Gentools v.0.1 - do not modify.
 * Supported AMQP version:
 *   0-9
 */
 
 
package org.wso2.andes.framing.amqp_0_9;

import java.util.HashMap;

import org.apache.mina.common.ByteBuffer;
import org.wso2.andes.framing.*;
import org.wso2.andes.AMQException;

public class QueueDeleteOkBodyImpl extends AMQMethodBody_0_9 implements QueueDeleteOkBody
{
    private static final AMQMethodBodyInstanceFactory FACTORY_INSTANCE = new AMQMethodBodyInstanceFactory()
    {
        public AMQMethodBody newInstance(ByteBuffer in, long size) throws AMQFrameDecodingException
        {
            return new QueueDeleteOkBodyImpl(in);
        }
		
 
    };
    
	
    public static AMQMethodBodyInstanceFactory getFactory()
    {
        return FACTORY_INSTANCE;
    }

    public static final int CLASS_ID =  50; 
    
    public static final int METHOD_ID = 41; 
    

	
    // Fields declared in specification
    private final long _messageCount; // [messageCount]

    
    // Constructor

    public QueueDeleteOkBodyImpl(ByteBuffer buffer) throws AMQFrameDecodingException
    {
        _messageCount = readUnsignedInteger( buffer );
	}
	
    public QueueDeleteOkBodyImpl(
                                long messageCount
                            )
    {
        _messageCount = messageCount;
    }
    
    public int getClazz() 
    { 
        return CLASS_ID; 
    }
    
    public int getMethod() 
    { 
        return METHOD_ID; 
    }

    
    public final long getMessageCount()
    {
        return _messageCount;
    }

    protected int getBodySize()
    {      
	    int size = 4;
        return size;        
    }

    public void writeMethodPayload(ByteBuffer buffer)
    {
        writeUnsignedInteger( buffer, _messageCount );
    }

    public boolean execute(MethodDispatcher dispatcher, int channelId) throws AMQException
	{
    return ((MethodDispatcher_0_9)dispatcher).dispatchQueueDeleteOk(this, channelId);	

	    
	}
	
	
    public String toString()
    {
        StringBuilder buf = new StringBuilder("[QueueDeleteOkBodyImpl: ");
        buf.append( "messageCount=" );
		buf.append(  getMessageCount() );
        buf.append("]");
        return buf.toString();
    }


}

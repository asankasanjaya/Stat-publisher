



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

public class BasicGetOkBodyImpl extends AMQMethodBody_0_9 implements BasicGetOkBody
{
    private static final AMQMethodBodyInstanceFactory FACTORY_INSTANCE = new AMQMethodBodyInstanceFactory()
    {
        public AMQMethodBody newInstance(ByteBuffer in, long size) throws AMQFrameDecodingException
        {
            return new BasicGetOkBodyImpl(in);
        }
		
 
    };
    
	
    public static AMQMethodBodyInstanceFactory getFactory()
    {
        return FACTORY_INSTANCE;
    }

    public static final int CLASS_ID =  60; 
    
    public static final int METHOD_ID = 71; 
    

	
    // Fields declared in specification
    private final long _deliveryTag; // [deliveryTag]
    private final byte _bitfield0; // [redelivered]
    private final AMQShortString _exchange; // [exchange]
    private final AMQShortString _routingKey; // [routingKey]
    private final long _messageCount; // [messageCount]

    
    // Constructor

    public BasicGetOkBodyImpl(ByteBuffer buffer) throws AMQFrameDecodingException
    {
        _deliveryTag = readLong( buffer );
        _bitfield0 = readBitfield( buffer );
        _exchange = readAMQShortString( buffer );
        _routingKey = readAMQShortString( buffer );
        _messageCount = readUnsignedInteger( buffer );
	}
	
    public BasicGetOkBodyImpl(
                                long deliveryTag,
                                boolean redelivered,
                                AMQShortString exchange,
                                AMQShortString routingKey,
                                long messageCount
                            )
    {
        _deliveryTag = deliveryTag;
        byte bitfield0 = (byte)0;
        if( redelivered )
		{		    
            bitfield0 = (byte) (((int) bitfield0) | (1 << 0));
		}
 
        _bitfield0 = bitfield0; 
        _exchange = exchange;
        _routingKey = routingKey;
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

    
    public final long getDeliveryTag()
    {
        return _deliveryTag;
    }
    public final boolean getRedelivered()
    {
        return (((int)(_bitfield0)) & ( 1 << 0)) != 0;
    }
    public final AMQShortString getExchange()
    {
        return _exchange;
    }
    public final AMQShortString getRoutingKey()
    {
        return _routingKey;
    }
    public final long getMessageCount()
    {
        return _messageCount;
    }

    protected int getBodySize()
    {      
	    int size = 13;
        size += getSizeOf( _exchange );
        size += getSizeOf( _routingKey );
        return size;        
    }

    public void writeMethodPayload(ByteBuffer buffer)
    {
        writeLong( buffer, _deliveryTag );
        writeBitfield( buffer, _bitfield0 );
        writeAMQShortString( buffer, _exchange );
        writeAMQShortString( buffer, _routingKey );
        writeUnsignedInteger( buffer, _messageCount );
    }

    public boolean execute(MethodDispatcher dispatcher, int channelId) throws AMQException
	{
    return ((MethodDispatcher_0_9)dispatcher).dispatchBasicGetOk(this, channelId);	

	    
	}
	
	
    public String toString()
    {
        StringBuilder buf = new StringBuilder("[BasicGetOkBodyImpl: ");
        buf.append( "deliveryTag=" );
		buf.append(  getDeliveryTag() );
		buf.append( ", " );		
        buf.append( "redelivered=" );
		buf.append(  getRedelivered() );
		buf.append( ", " );		
        buf.append( "exchange=" );
		buf.append(  getExchange() );
		buf.append( ", " );		
        buf.append( "routingKey=" );
		buf.append(  getRoutingKey() );
		buf.append( ", " );		
        buf.append( "messageCount=" );
		buf.append(  getMessageCount() );
        buf.append("]");
        return buf.toString();
    }


}

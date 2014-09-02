



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

public class QueueUnbindBodyImpl extends AMQMethodBody_0_9 implements QueueUnbindBody
{
    private static final AMQMethodBodyInstanceFactory FACTORY_INSTANCE = new AMQMethodBodyInstanceFactory()
    {
        public AMQMethodBody newInstance(ByteBuffer in, long size) throws AMQFrameDecodingException
        {
            return new QueueUnbindBodyImpl(in);
        }
		
 
    };
    
	
    public static AMQMethodBodyInstanceFactory getFactory()
    {
        return FACTORY_INSTANCE;
    }

    public static final int CLASS_ID =  50; 
    
    public static final int METHOD_ID = 50; 
    

	
    // Fields declared in specification
    private final int _ticket; // [ticket]
    private final AMQShortString _queue; // [queue]
    private final AMQShortString _exchange; // [exchange]
    private final AMQShortString _routingKey; // [routingKey]
    private final FieldTable _arguments; // [arguments]

    
    // Constructor

    public QueueUnbindBodyImpl(ByteBuffer buffer) throws AMQFrameDecodingException
    {
        _ticket = readUnsignedShort( buffer );
        _queue = readAMQShortString( buffer );
        _exchange = readAMQShortString( buffer );
        _routingKey = readAMQShortString( buffer );
        _arguments = readFieldTable( buffer );
	}
	
    public QueueUnbindBodyImpl(
                                int ticket,
                                AMQShortString queue,
                                AMQShortString exchange,
                                AMQShortString routingKey,
                                FieldTable arguments
                            )
    {
        _ticket = ticket;
        _queue = queue;
        _exchange = exchange;
        _routingKey = routingKey;
        _arguments = arguments;
    }
    
    public int getClazz() 
    { 
        return CLASS_ID; 
    }
    
    public int getMethod() 
    { 
        return METHOD_ID; 
    }

    
    public final int getTicket()
    {
        return _ticket;
    }
    public final AMQShortString getQueue()
    {
        return _queue;
    }
    public final AMQShortString getExchange()
    {
        return _exchange;
    }
    public final AMQShortString getRoutingKey()
    {
        return _routingKey;
    }
    public final FieldTable getArguments()
    {
        return _arguments;
    }

    protected int getBodySize()
    {      
	    int size = 2;
        size += getSizeOf( _queue );
        size += getSizeOf( _exchange );
        size += getSizeOf( _routingKey );
        size += getSizeOf( _arguments );
        return size;        
    }

    public void writeMethodPayload(ByteBuffer buffer)
    {
        writeUnsignedShort( buffer, _ticket );
        writeAMQShortString( buffer, _queue );
        writeAMQShortString( buffer, _exchange );
        writeAMQShortString( buffer, _routingKey );
        writeFieldTable( buffer, _arguments );
    }

    public boolean execute(MethodDispatcher dispatcher, int channelId) throws AMQException
	{
    return ((MethodDispatcher_0_9)dispatcher).dispatchQueueUnbind(this, channelId);	

	    
	}
	
	
    public String toString()
    {
        StringBuilder buf = new StringBuilder("[QueueUnbindBodyImpl: ");
        buf.append( "ticket=" );
		buf.append(  getTicket() );
		buf.append( ", " );		
        buf.append( "queue=" );
		buf.append(  getQueue() );
		buf.append( ", " );		
        buf.append( "exchange=" );
		buf.append(  getExchange() );
		buf.append( ", " );		
        buf.append( "routingKey=" );
		buf.append(  getRoutingKey() );
		buf.append( ", " );		
        buf.append( "arguments=" );
		buf.append(  getArguments() );
        buf.append("]");
        return buf.toString();
    }


}

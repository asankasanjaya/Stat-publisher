



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
 *   8-0
 */
 
 
package org.wso2.andes.framing.amqp_8_0;

import java.util.HashMap;

import org.apache.mina.common.ByteBuffer;
import org.wso2.andes.framing.*;
import org.wso2.andes.AMQException;

public class QueueDeleteBodyImpl extends AMQMethodBody_8_0 implements QueueDeleteBody
{
    private static final AMQMethodBodyInstanceFactory FACTORY_INSTANCE = new AMQMethodBodyInstanceFactory()
    {
        public AMQMethodBody newInstance(ByteBuffer in, long size) throws AMQFrameDecodingException
        {
            return new QueueDeleteBodyImpl(in);
        }
		
 
    };
    
	
    public static AMQMethodBodyInstanceFactory getFactory()
    {
        return FACTORY_INSTANCE;
    }

    public static final int CLASS_ID =  50; 
    
    public static final int METHOD_ID = 40; 
    

	
    // Fields declared in specification
    private final int _ticket; // [ticket]
    private final AMQShortString _queue; // [queue]
    private final byte _bitfield0; // [ifUnused, ifEmpty, nowait]

    
    // Constructor

    public QueueDeleteBodyImpl(ByteBuffer buffer) throws AMQFrameDecodingException
    {
        _ticket = readUnsignedShort( buffer );
        _queue = readAMQShortString( buffer );
        _bitfield0 = readBitfield( buffer );
	}
	
    public QueueDeleteBodyImpl(
                                int ticket,
                                AMQShortString queue,
                                boolean ifUnused,
                                boolean ifEmpty,
                                boolean nowait
                            )
    {
        _ticket = ticket;
        _queue = queue;
        byte bitfield0 = (byte)0;
        if( ifUnused )
		{		    
            bitfield0 = (byte) (((int) bitfield0) | (1 << 0));
		}
 
        if( ifEmpty )
		{		    
            bitfield0 = (byte) (((int) bitfield0) | (1 << 1));
		}
 
        if( nowait )
		{		    
            bitfield0 = (byte) (((int) bitfield0) | (1 << 2));
		}
        _bitfield0 = bitfield0; 
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
    public final boolean getIfUnused()
    {
        return (((int)(_bitfield0)) & ( 1 << 0)) != 0;
    }
    public final boolean getIfEmpty()
    {
        return (((int)(_bitfield0)) & ( 1 << 1)) != 0;
    }
    public final boolean getNowait()
    {
        return (((int)(_bitfield0)) & ( 1 << 2)) != 0;
    }

    protected int getBodySize()
    {      
	    int size = 3;
        size += getSizeOf( _queue );
        return size;        
    }

    public void writeMethodPayload(ByteBuffer buffer)
    {
        writeUnsignedShort( buffer, _ticket );
        writeAMQShortString( buffer, _queue );
        writeBitfield( buffer, _bitfield0 );
    }

    public boolean execute(MethodDispatcher dispatcher, int channelId) throws AMQException
	{
    return ((MethodDispatcher_8_0)dispatcher).dispatchQueueDelete(this, channelId);	

	    
	}
	
	
    public String toString()
    {
        StringBuilder buf = new StringBuilder("[QueueDeleteBodyImpl: ");
        buf.append( "ticket=" );
		buf.append(  getTicket() );
		buf.append( ", " );		
        buf.append( "queue=" );
		buf.append(  getQueue() );
		buf.append( ", " );		
        buf.append( "ifUnused=" );
		buf.append(  getIfUnused() );
		buf.append( ", " );		
        buf.append( "ifEmpty=" );
		buf.append(  getIfEmpty() );
		buf.append( ", " );		
        buf.append( "nowait=" );
		buf.append(  getNowait() );
        buf.append("]");
        return buf.toString();
    }


}

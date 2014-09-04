



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

public class BasicRejectBodyImpl extends AMQMethodBody_8_0 implements BasicRejectBody
{
    private static final AMQMethodBodyInstanceFactory FACTORY_INSTANCE = new AMQMethodBodyInstanceFactory()
    {
        public AMQMethodBody newInstance(ByteBuffer in, long size) throws AMQFrameDecodingException
        {
            return new BasicRejectBodyImpl(in);
        }
		
 
    };
    
	
    public static AMQMethodBodyInstanceFactory getFactory()
    {
        return FACTORY_INSTANCE;
    }

    public static final int CLASS_ID =  60; 
    
    public static final int METHOD_ID = 90; 
    

	
    // Fields declared in specification
    private final long _deliveryTag; // [deliveryTag]
    private final byte _bitfield0; // [requeue]

    
    // Constructor

    public BasicRejectBodyImpl(ByteBuffer buffer) throws AMQFrameDecodingException
    {
        _deliveryTag = readLong( buffer );
        _bitfield0 = readBitfield( buffer );
	}
	
    public BasicRejectBodyImpl(
                                long deliveryTag,
                                boolean requeue
                            )
    {
        _deliveryTag = deliveryTag;
        byte bitfield0 = (byte)0;
        if( requeue )
		{		    
            bitfield0 = (byte) (((int) bitfield0) | (1 << 0));
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

    
    public final long getDeliveryTag()
    {
        return _deliveryTag;
    }
    public final boolean getRequeue()
    {
        return (((int)(_bitfield0)) & ( 1 << 0)) != 0;
    }

    protected int getBodySize()
    {      
	    int size = 9;
        return size;        
    }

    public void writeMethodPayload(ByteBuffer buffer)
    {
        writeLong( buffer, _deliveryTag );
        writeBitfield( buffer, _bitfield0 );
    }

    public boolean execute(MethodDispatcher dispatcher, int channelId) throws AMQException
	{
    return ((MethodDispatcher_8_0)dispatcher).dispatchBasicReject(this, channelId);	

	    
	}
	
	
    public String toString()
    {
        StringBuilder buf = new StringBuilder("[BasicRejectBodyImpl: ");
        buf.append( "deliveryTag=" );
		buf.append(  getDeliveryTag() );
		buf.append( ", " );		
        buf.append( "requeue=" );
		buf.append(  getRequeue() );
        buf.append("]");
        return buf.toString();
    }


}

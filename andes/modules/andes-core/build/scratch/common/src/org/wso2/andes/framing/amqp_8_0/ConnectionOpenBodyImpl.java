



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

public class ConnectionOpenBodyImpl extends AMQMethodBody_8_0 implements ConnectionOpenBody
{
    private static final AMQMethodBodyInstanceFactory FACTORY_INSTANCE = new AMQMethodBodyInstanceFactory()
    {
        public AMQMethodBody newInstance(ByteBuffer in, long size) throws AMQFrameDecodingException
        {
            return new ConnectionOpenBodyImpl(in);
        }
		
 
    };
    
	
    public static AMQMethodBodyInstanceFactory getFactory()
    {
        return FACTORY_INSTANCE;
    }

    public static final int CLASS_ID =  10; 
    
    public static final int METHOD_ID = 40; 
    

	
    // Fields declared in specification
    private final AMQShortString _virtualHost; // [virtualHost]
    private final AMQShortString _capabilities; // [capabilities]
    private final byte _bitfield0; // [insist]

    
    // Constructor

    public ConnectionOpenBodyImpl(ByteBuffer buffer) throws AMQFrameDecodingException
    {
        _virtualHost = readAMQShortString( buffer );
        _capabilities = readAMQShortString( buffer );
        _bitfield0 = readBitfield( buffer );
	}
	
    public ConnectionOpenBodyImpl(
                                AMQShortString virtualHost,
                                AMQShortString capabilities,
                                boolean insist
                            )
    {
        _virtualHost = virtualHost;
        _capabilities = capabilities;
        byte bitfield0 = (byte)0;
        if( insist )
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

    
    public final AMQShortString getVirtualHost()
    {
        return _virtualHost;
    }
    public final AMQShortString getCapabilities()
    {
        return _capabilities;
    }
    public final boolean getInsist()
    {
        return (((int)(_bitfield0)) & ( 1 << 0)) != 0;
    }

    protected int getBodySize()
    {      
	    int size = 1;
        size += getSizeOf( _virtualHost );
        size += getSizeOf( _capabilities );
        return size;        
    }

    public void writeMethodPayload(ByteBuffer buffer)
    {
        writeAMQShortString( buffer, _virtualHost );
        writeAMQShortString( buffer, _capabilities );
        writeBitfield( buffer, _bitfield0 );
    }

    public boolean execute(MethodDispatcher dispatcher, int channelId) throws AMQException
	{
    return ((MethodDispatcher_8_0)dispatcher).dispatchConnectionOpen(this, channelId);	

	    
	}
	
	
    public String toString()
    {
        StringBuilder buf = new StringBuilder("[ConnectionOpenBodyImpl: ");
        buf.append( "virtualHost=" );
		buf.append(  getVirtualHost() );
		buf.append( ", " );		
        buf.append( "capabilities=" );
		buf.append(  getCapabilities() );
		buf.append( ", " );		
        buf.append( "insist=" );
		buf.append(  getInsist() );
        buf.append("]");
        return buf.toString();
    }


}
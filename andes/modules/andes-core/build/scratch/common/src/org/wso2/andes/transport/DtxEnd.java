package org.wso2.andes.transport;
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


import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.wso2.andes.transport.codec.Decoder;
import org.wso2.andes.transport.codec.Encodable;
import org.wso2.andes.transport.codec.Encoder;

import org.wso2.andes.transport.network.Frame;

import org.wso2.andes.util.Strings;




public final class DtxEnd extends Method {

    public static final int TYPE = 1539;

    public final int getStructType() {
        return TYPE;
    }

    public final int getSizeWidth() {
        return 0;
    }

    public final int getPackWidth() {
        return 2;
    }

    public final boolean hasPayload() {
        return false;
    }

    public final byte getEncodedTrack() {
        return Frame.L4;
    }

    public final boolean isConnectionControl()
    {
        return false;
    }

    private short packing_flags = 0;
    private Xid xid;


    public DtxEnd() {}


    public DtxEnd(Xid xid, Option ... _options) {
        if(xid != null) {
            setXid(xid);
        }

        for (int i=0; i < _options.length; i++) {
            switch (_options[i]) {
            case FAIL: packing_flags |= 512; break;
            case SUSPEND: packing_flags |= 1024; break;
            case SYNC: this.setSync(true); break;
            case BATCH: this.setBatch(true); break;
            case UNRELIABLE: this.setUnreliable(true); break;
            case NONE: break;
            default: throw new IllegalArgumentException("invalid option: " + _options[i]);
            }
        }

    }

    public <C> void dispatch(C context, MethodDelegate<C> delegate) {
        delegate.dtxEnd(context, this);
    }


    public final boolean hasXid() {
        return (packing_flags & 256) != 0;
    }

    public final DtxEnd clearXid() {
        packing_flags &= ~256;
        this.xid = null;
        this.dirty = true;
        return this;
    }

    public final Xid getXid() {
        return xid;
    }

    public final DtxEnd setXid(Xid value) {
        this.xid = value;
        packing_flags |= 256;
        this.dirty = true;
        return this;
    }

    public final DtxEnd xid(Xid value) {
        return setXid(value);
    }

    public final boolean hasFail() {
        return (packing_flags & 512) != 0;
    }

    public final DtxEnd clearFail() {
        packing_flags &= ~512;

        this.dirty = true;
        return this;
    }

    public final boolean getFail() {
        return hasFail();
    }

    public final DtxEnd setFail(boolean value) {

        if (value)
            packing_flags |= 512;
        else
            packing_flags &= ~512;
        this.dirty = true;
        return this;
    }

    public final DtxEnd fail(boolean value) {
        return setFail(value);
    }

    public final boolean hasSuspend() {
        return (packing_flags & 1024) != 0;
    }

    public final DtxEnd clearSuspend() {
        packing_flags &= ~1024;

        this.dirty = true;
        return this;
    }

    public final boolean getSuspend() {
        return hasSuspend();
    }

    public final DtxEnd setSuspend(boolean value) {

        if (value)
            packing_flags |= 1024;
        else
            packing_flags &= ~1024;
        this.dirty = true;
        return this;
    }

    public final DtxEnd suspend(boolean value) {
        return setSuspend(value);
    }




    public void write(Encoder enc)
    {
        enc.writeUint16(packing_flags);
        if ((packing_flags & 256) != 0)
            enc.writeStruct(Xid.TYPE, this.xid);

    }

    public void read(Decoder dec)
    {
        packing_flags = (short) dec.readUint16();
        if ((packing_flags & 256) != 0)
            this.xid = (Xid)dec.readStruct(Xid.TYPE);

    }

    public Map<String,Object> getFields()
    {
        Map<String,Object> result = new LinkedHashMap<String,Object>();

        if ((packing_flags & 256) != 0)
            result.put("xid", getXid());
        if ((packing_flags & 512) != 0)
            result.put("fail", getFail());
        if ((packing_flags & 1024) != 0)
            result.put("suspend", getSuspend());


        return result;
    }

}

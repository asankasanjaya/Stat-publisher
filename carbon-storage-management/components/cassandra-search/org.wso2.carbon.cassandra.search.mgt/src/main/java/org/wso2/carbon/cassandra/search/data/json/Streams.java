/*
 *  Licensed to the Apache Software Foundation (ASF) under one
 *  or more contributor license agreements.  See the NOTICE file
 *  distributed with this work for additional information
 *  regarding copyright ownership.  The ASF licenses this file
 *  to you under the Apache License, Version 2.0 (the
 *  "License"); you may not use this file except in compliance
 *  with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing,
 *  software distributed under the License is distributed on an
 *   * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *  KIND, either express or implied.  See the License for the
 *  specific language governing permissions and limitations
 *  under the License.
 */
package org.wso2.carbon.cassandra.search.data.json;

import java.util.ArrayList;
import java.util.List;

public class Streams {
    private List<StreamInfo> streams = null;

    public Streams() {
        this.streams = new ArrayList<StreamInfo>();
    }

    public void addStream(String streamID) {
        streams.add(new StreamInfo(streamID));
    }

    public void setActivities(List<StreamInfo> streams) {
        this.streams = streams;
    }

    public class StreamInfo {
        private String streamID;

        public StreamInfo(String streamID) {
            this.streamID = streamID;
        }

        public String getStreamID() {
            return streamID;
        }

        public void setStreamID(String streamID) {
            this.streamID = streamID;
        }
    }
}

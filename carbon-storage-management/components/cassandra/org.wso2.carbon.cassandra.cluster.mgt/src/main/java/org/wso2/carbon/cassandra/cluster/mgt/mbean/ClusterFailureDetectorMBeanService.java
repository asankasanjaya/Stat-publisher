package org.wso2.carbon.cassandra.cluster.mgt.mbean;/*
*Copyright (c) 2005-2010, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
*
*WSO2 Inc. licenses this file to you under the Apache License,
*Version 2.0 (the "License"); you may not use this file except
*in compliance with the License.
*You may obtain a copy of the License at
*
*http://www.apache.org/licenses/LICENSE-2.0
*
*Unless required by applicable law or agreed to in writing,
*software distributed under the License is distributed on an
*"AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
*KIND, either express or implied.  See the License for the
*specific language governing permissions and limitations
*under the License.
*/

import org.apache.cassandra.gms.FailureDetectorMBean;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.wso2.carbon.cassandra.cluster.ClusterMBeanDataAccess;
import org.wso2.carbon.cassandra.cluster.mgt.exception.ClusterDataAdminException;
import org.wso2.carbon.cassandra.cluster.mgt.component.ClusterAdminComponentManager;

public class ClusterFailureDetectorMBeanService {
    private static Log log = LogFactory.getLog(ClusterFailureDetectorMBeanService.class);
    private FailureDetectorMBean failureDetectorMBean;

    public ClusterFailureDetectorMBeanService() throws
                                                ClusterDataAdminException {
        createProxyConnection();
    }

    /**
     * Get storage service instance
     * @throws org.wso2.carbon.cassandra.cluster.mgt.exception.ClusterDataAdminException
     */
    private void createProxyConnection() throws ClusterDataAdminException {
        ClusterMBeanDataAccess clusterMBeanDataAccess = ClusterAdminComponentManager.getInstance().getClusterMBeanDataAccess();
        try{
            failureDetectorMBean= clusterMBeanDataAccess.locateFailureDetectorMBean();
        }
        catch(Exception e){
            throw new ClusterDataAdminException("Unable to locate failure detector MBean connection",e,log);
        }
    }

    /**
     * Get gossip info
     * @return string gossip info
     */
    public String getGossipInfo()
    {
        return failureDetectorMBean.getAllEndpointStates();
    }
}

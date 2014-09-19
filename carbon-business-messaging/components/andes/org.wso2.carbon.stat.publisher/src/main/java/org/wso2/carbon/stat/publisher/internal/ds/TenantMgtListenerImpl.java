/*
*  Copyright (c) 2005-2010, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
*
*  WSO2 Inc. licenses this file to you under the Apache License,
*  Version 2.0 (the "License"); you may not use this file except
*  in compliance with the License.
*  You may obtain a copy of the License at
*
*    http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing,
* software distributed under the License is distributed on an
* "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
* KIND, either express or implied.  See the License for the
* specific language governing permissions and limitations
* under the License.
*/

package org.wso2.carbon.stat.publisher.internal.ds;

import org.wso2.carbon.stat.publisher.exception.StatPublisherConfigurationException;
import org.wso2.carbon.stat.publisher.publisher.StatPublisherManager;
import org.wso2.carbon.stratos.common.beans.TenantInfoBean;
import org.wso2.carbon.stratos.common.exception.StratosException;
import org.wso2.carbon.stratos.common.listeners.TenantMgtListener;


public class TenantMgtListenerImpl implements TenantMgtListener {
    public static TenantMgtListenerImpl getTenantMgtListener() {
        return tenantMgtListener;
    }

    private static TenantMgtListenerImpl tenantMgtListener = new TenantMgtListenerImpl();
    StatPublisherManager statPublisherManager = ServiceValueHolder.getInstance().getStatPublisherManagerService();

    private TenantMgtListenerImpl() {

    }


    @Override
    public void onTenantCreate(TenantInfoBean tenantInfoBean) throws StratosException {


    }

    @Override
    public void onTenantUpdate(TenantInfoBean tenantInfoBean) throws StratosException {

    }

    @Override
    public void onTenantDelete(int i) {
        try {
            statPublisherManager.onRemove(i);
        } catch (StatPublisherConfigurationException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onTenantRename(int i, String s, String s2) throws StratosException {

    }

    @Override
    public void onTenantInitialActivation(int i) throws StratosException {
        try {
            statPublisherManager.onCreate(i);
        } catch (StatPublisherConfigurationException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onTenantActivation(int i) throws StratosException {
        try {
            statPublisherManager.onCreate(i);
        } catch (StatPublisherConfigurationException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void onTenantDeactivation(int i) throws StratosException {

        try {
            statPublisherManager.onRemove(i);
        } catch (StatPublisherConfigurationException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onSubscriptionPlanChange(int i, String s, String s2) throws StratosException {

    }

    @Override
    public int getListenerOrder() {
        return 0;
    }
}

/*
 * Copyright (c) 2017, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 * WSO2 Inc. licenses this file to you under the Apache License,
 *  Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.wso2.carbon.identity.user.store.outbound.dao;

public class SQLQueries {

    public static final String ACCESS_TOKEN_INSERT = "INSERT INTO UM_ACCESS_TOKEN(UM_TOKEN,UM_STATUS,UM_TENANT," +
            "UM_DOMAIN)VALUES(?,?,?,?)";
    public static final String ACCESS_TOKEN_GET = "SELECT UM_TOKEN FROM UM_ACCESS_TOKEN WHERE UM_TENANT=? AND " +
            "UM_DOMAIN=? AND UM_STATUS=?";
    public static final String ACCESS_TOKEN_STATUS_UPDATE_BY_TOKEN = "UPDATE UM_ACCESS_TOKEN SET UM_STATUS=? WHERE " +
            "UM_TOKEN=?";

    public static final String ACCESS_TOKEN_STATUS_UPDATE = "UPDATE UM_ACCESS_TOKEN SET UM_STATUS=? WHERE UM_TENANT=?" +
            " AND UM_DOMAIN=?";
    public static final String AGENT_CONNECTIONS_GET = "SELECT C.UM_NODE, C.UM_STATUS FROM " +
            "UM_ACCESS_TOKEN A JOIN UM_AGENT_CONNECTIONS C ON A.UM_STATUS=? AND A.UM_DOMAIN=? AND A.UM_TENANT=? AND " +
            "A.UM_ID = C.UM_ACCESS_TOKEN_ID ORDER BY C.UM_NODE;";
    public static final String AGENT_CONNECTIONS_DELETE_BY_DOMAIN = "DELETE FROM UM_AGENT_CONNECTIONS WHERE " +
            "UM_ACCESS_TOKEN_ID IN (SELECT A.UM_ID FROM UM_ACCESS_TOKEN A WHERE A.UM_DOMAIN=? AND A.UM_TENANT=?);";

    public static final String AGENT_CONNECTIONS_UPDATE_STATUS_BY_DOMAIN = "UPDATE UM_AGENT_CONNECTIONS " +
            "SET UM_STATUS=? WHERE UM_ACCESS_TOKEN_ID IN (SELECT A.UM_ID FROM UM_ACCESS_TOKEN A WHERE A.UM_DOMAIN=? " +
            "AND A.UM_TENANT=?);";
}

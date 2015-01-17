/*
 * Copyright 2010-2015 Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License").
 * You may not use this file except in compliance with the License.
 * A copy of the License is located at
 * 
 *  http://aws.amazon.com/apache2.0
 * 
 * or in the "license" file accompanying this file. This file is distributed
 * on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either
 * express or implied. See the License for the specific language governing
 * permissions and limitations under the License.
 */

package com.amazonaws.services.elastictranscoder.model.transform;

import com.amazonaws.services.elastictranscoder.model.Permission;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.ListUnmarshaller;
import com.amazonaws.transform.SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller;
import com.amazonaws.transform.Unmarshaller;
import com.amazonaws.com.fasterxml.jackson.core.JsonToken;

import static com.amazonaws.com.fasterxml.jackson.core.JsonToken.END_ARRAY;
import static com.amazonaws.com.fasterxml.jackson.core.JsonToken.END_OBJECT;
import static com.amazonaws.com.fasterxml.jackson.core.JsonToken.FIELD_NAME;
import static com.amazonaws.com.fasterxml.jackson.core.JsonToken.START_OBJECT;
import static com.amazonaws.com.fasterxml.jackson.core.JsonToken.VALUE_NULL;

/**
 * Permission JSON Unmarshaller
 */
public class PermissionJsonUnmarshaller implements Unmarshaller<Permission, JsonUnmarshallerContext> {

    public Permission unmarshall(JsonUnmarshallerContext context) throws Exception {
        Permission permission = new Permission();

        int originalDepth = context.getCurrentDepth();
        String currentParentElement = context.getCurrentParentElement();
        int targetDepth = originalDepth + 1;

        JsonToken token = context.currentToken;
        if (token == null) token = context.nextToken();
        if (token == VALUE_NULL) return null;

        while (true) {
            if (token == null) break;

            if (token == FIELD_NAME || token == START_OBJECT) {
                if (context.testExpression("GranteeType", targetDepth)) {
                    context.nextToken();
                    permission.setGranteeType(StringJsonUnmarshaller.getInstance().unmarshall(context));
                }
                if (context.testExpression("Grantee", targetDepth)) {
                    context.nextToken();
                    permission.setGrantee(StringJsonUnmarshaller.getInstance().unmarshall(context));
                }
                if (context.testExpression("Access", targetDepth)) {
                    context.nextToken();
                    permission.setAccess(new ListUnmarshaller<String>(StringJsonUnmarshaller.getInstance()).unmarshall(context));
                }
            } else if (token == END_ARRAY || token == END_OBJECT) {
                if (context.getLastParsedParentElement() == null || context.getLastParsedParentElement().equals(currentParentElement)) {
                    if (context.getCurrentDepth() <= originalDepth) break;
                }
            }

            token = context.nextToken();
        }

        return permission;
    }

    private static PermissionJsonUnmarshaller instance;

    public static PermissionJsonUnmarshaller getInstance() {
        if (instance == null) instance = new PermissionJsonUnmarshaller();
        return instance;
    }
}
    
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

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.http.HttpMethodName;
import com.amazonaws.services.elastictranscoder.model.Notifications;
import com.amazonaws.services.elastictranscoder.model.UpdatePipelineNotificationsRequest;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringInputStream;
import com.amazonaws.util.StringUtils;
import com.amazonaws.util.json.JSONWriter;

import java.io.StringWriter;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import static com.amazonaws.util.StringUtils.UTF8;

/**
 * Update Pipeline Notifications Request Marshaller
 */
public class UpdatePipelineNotificationsRequestMarshaller implements Marshaller<Request<UpdatePipelineNotificationsRequest>, UpdatePipelineNotificationsRequest> {

    private static final String RESOURCE_PATH_TEMPLATE;
    private static final Map<String, String> STATIC_QUERY_PARAMS;
    private static final Map<String, String> DYNAMIC_QUERY_PARAMS;

    static {
        String path = "2012-09-25/pipelines/{Id}/notifications";
        Map<String, String> staticMap = new HashMap<String, String>();
        Map<String, String> dynamicMap = new HashMap<String, String>();

        int index = path.indexOf("?");
        if (index != -1) {
            String queryString = path.substring(index + 1);
            path = path.substring(0, index);

            for (String s : queryString.split("[;&]")) {
                index = s.indexOf("=");
                if (index != -1) {
                    String name = s.substring(0, index);
                    String value = s.substring(index + 1);

                    if (value.startsWith("{") && value.endsWith("}")) {
                        dynamicMap.put(value.substring(1, value.length() - 1), name);
                    } else {
                        staticMap.put(name, value);
                    }
                }
            }
        }

        RESOURCE_PATH_TEMPLATE = path;
        STATIC_QUERY_PARAMS = Collections.unmodifiableMap(staticMap);
        DYNAMIC_QUERY_PARAMS = Collections.unmodifiableMap(dynamicMap);
    }

    public Request<UpdatePipelineNotificationsRequest> marshall(UpdatePipelineNotificationsRequest updatePipelineNotificationsRequest) {
        if (updatePipelineNotificationsRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(...)");
        }

        Request<UpdatePipelineNotificationsRequest> request = new DefaultRequest<UpdatePipelineNotificationsRequest>(updatePipelineNotificationsRequest, "AmazonElasticTranscoder");
        String target = "EtsCustomerService.UpdatePipelineNotifications";
        request.addHeader("X-Amz-Target", target);

        request.setHttpMethod(HttpMethodName.POST);
        String uriResourcePath = RESOURCE_PATH_TEMPLATE;

        if (DYNAMIC_QUERY_PARAMS.containsKey("Id")) {
            String name = DYNAMIC_QUERY_PARAMS.get("Id");
            String value = (updatePipelineNotificationsRequest.getId() == null) ? null : StringUtils.fromString(updatePipelineNotificationsRequest.getId());

            if (!(value == null || value.isEmpty())) {
                request.addParameter(name, value);
            }
        } else {
            uriResourcePath = uriResourcePath.replace("{Id}", (updatePipelineNotificationsRequest.getId() == null) ? "" : StringUtils.fromString(updatePipelineNotificationsRequest.getId()));
        }

        request.setResourcePath(uriResourcePath.replaceAll("//", "/"));

        for (Map.Entry<String, String> entry : STATIC_QUERY_PARAMS.entrySet()) {
            request.addParameter(entry.getKey(), entry.getValue());
        }

        try {
            StringWriter stringWriter = new StringWriter();
            JSONWriter jsonWriter = new JSONWriter(stringWriter);

            jsonWriter.object();

            Notifications notifications = updatePipelineNotificationsRequest.getNotifications();
            if (notifications != null) {

                jsonWriter.key("Notifications");
                jsonWriter.object();

                if (notifications.getProgressing() != null) {
                    jsonWriter.key("Progressing").value(notifications.getProgressing());
                }
                if (notifications.getCompleted() != null) {
                    jsonWriter.key("Completed").value(notifications.getCompleted());
                }
                if (notifications.getWarning() != null) {
                    jsonWriter.key("Warning").value(notifications.getWarning());
                }
                if (notifications.getError() != null) {
                    jsonWriter.key("Error").value(notifications.getError());
                }
                jsonWriter.endObject();
            }

            jsonWriter.endObject();

            String snippet = stringWriter.toString();
            byte[] content = snippet.getBytes(UTF8);
            request.setContent(new StringInputStream(snippet));
            request.addHeader("Content-Length", Integer.toString(content.length));
            request.addHeader("Content-Type", "application/x-amz-json-1.0");
        } catch (Throwable t) {
            throw new AmazonClientException("Unable to marshall request to JSON: " + t.getMessage(), t);
        }

        return request;
    }
}

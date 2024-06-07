package org.viafirma;

import java.util.ArrayList;
import java.util.List;

public class SaveObjectRequest {
    private String uri;
    private String userId;
    private String operationId;
    private String objectReference;
    private String sourceApplication;
    private String sourceInstance;
    private List<MetadataItem> metadata = new ArrayList<>();
    private long objectLength = -1;
    private String objectName;

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getOperationId() {
        return operationId;
    }

    public void setOperationId(String operationId) {
        this.operationId = operationId;
    }

    public String getObjectReference() {
        return objectReference;
    }

    public void setObjectReference(String objectReference) {
        this.objectReference = objectReference;
    }

    public String getSourceApplication() {
        return sourceApplication;
    }

    public void setSourceApplication(String sourceApplication) {
        this.sourceApplication = sourceApplication;
    }

    public String getSourceInstance() {
        return sourceInstance;
    }

    public void setSourceInstance(String sourceInstance) {
        this.sourceInstance = sourceInstance;
    }

    public List<MetadataItem> getMetadata() {
        return metadata;
    }

    public void setMetadata(List<MetadataItem> metadata) {
        this.metadata = metadata;
    }

    public long getObjectLength() {
        return objectLength;
    }

    public void setObjectLength(long objectLength) {
        this.objectLength = objectLength;
    }

    public String getObjectName() {
        return objectName;
    }

    public void setObjectName(String objectName) {
        this.objectName = objectName;
    }
}

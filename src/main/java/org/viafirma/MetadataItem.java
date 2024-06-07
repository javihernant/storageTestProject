package org.viafirma;

public class MetadataItem {

    private String key;
    private String value;
    private MetadataItemType type = MetadataItemType.TYPE_STRING;

    public MetadataItem() {
        // Empty constructor
    }

    public MetadataItem(String key, String value, MetadataItemType type) {
        this.key = key;
        this.value = value;
        this.type = type;
    }

    public MetadataItemType getType() {
        return type;
    }

    public void setType(MetadataItemType type) {
        this.type = type;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

}

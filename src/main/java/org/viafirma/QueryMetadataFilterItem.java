package org.viafirma;

public class QueryMetadataFilterItem {
    private String field;
    private String type;
    private String value;

    public QueryMetadataFilterItem(String field, String value, String type ) {
        this.field = field;
        this.type = type;
        this.value = value;
    }

    @Override
    public String toString() {
        return "QueryMetadataFilterItem{" +
                "field='" + field + '\'' +
                ", type='" + type + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}

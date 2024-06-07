package org.viafirma;

import java.util.ArrayList;
import java.util.List;

public class QueryMetadataRequest {

    private List<QueryMetadataFilterItem> filters = new ArrayList<>();

    public List<QueryMetadataFilterItem> getFilters() {
        return filters;
    }

    public void setFilters(List<QueryMetadataFilterItem> filters) {
        this.filters = filters;
    }

    @Override
    public String toString() {
        return "QueryMetadataRequest{" +
                "filters=" + filters +
                '}';
    }
}
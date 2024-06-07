package org.viafirma;

import java.sql.Types;
import java.util.Arrays;

public enum MetadataItemType {
    TYPE_NUMBER(Types.DOUBLE),
    TYPE_STRING(Types.VARCHAR),
    TYPE_TIMESTAMP(Types.TIMESTAMP),
    TYPE_BOOLEAN(Types.BOOLEAN);

    private int intType;

    MetadataItemType(int intType) {
        this.intType = intType;
    }

    public static MetadataItemType findByDBType(int intType) {
        return Arrays.stream(values()).filter(s -> s.intType == intType).findFirst().orElseGet(null);
    }

    public int getIntType() {
        return intType;
    }
}


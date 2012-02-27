package com.cobaltolabs.cms.core;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 *
 * @author Mario Arias
 *         Date: 23/02/12
 *         Time: 1:46
 */

public final class CmsUtil {
// -------------------------- STATIC METHODS --------------------------

    public static Map<String, Object> object(Entry... entries) {
        Map<String, Object> map = new HashMap<String, Object>(entries.length);
        for (Entry entry : entries) {
            map.put(entry.getKey(), entry.getValue());
        }
        return map;
    }

    public static Entry e(String key, Object value) {
        return new Entry(key, value);
    }

// --------------------------- CONSTRUCTORS ---------------------------

    private CmsUtil() {
    }

// -------------------------- INNER CLASSES --------------------------

    public static class Entry {
        private String key;
        private Object value;

        public Entry(String key, Object value) {
            this.key = key;
            this.value = value;
        }

        public String getKey() {
            return key;
        }

        public Object getValue() {
            return value;
        }
    }
}

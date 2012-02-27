package com.cobaltolabs.cms.core.stripes;

import net.sourceforge.stripes.action.StreamingResolution;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;

/**
 * Created by IntelliJ IDEA.
 *
 * @author Mario Arias
 *         Date: 22/02/12
 *         Time: 23:44
 */
public class JsonResolution extends StreamingResolution {
    public static final String CONTENT_TYPE = "application/json";
    // --------------------------- CONSTRUCTORS ---------------------------

    public JsonResolution(ObjectMapper objectMapper, Object object) throws IOException {
        super(CONTENT_TYPE, objectMapper.writeValueAsString(object));
    }
}

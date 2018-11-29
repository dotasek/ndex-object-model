package org.ndexbio.cxio.aspects.readers;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map.Entry;

import org.ndexbio.cxio.aspects.datamodels.CyAnnotationsElement;
import org.ndexbio.cxio.aspects.datamodels.CyVisualPropertiesElement;
import org.ndexbio.cxio.aspects.datamodels.Mapping;
import org.ndexbio.cxio.core.interfaces.AspectElement;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

public final class CyAnnotationsFragmentReader extends AbstractFragmentReader {

    public static CyAnnotationsFragmentReader createInstance() {
        return new CyAnnotationsFragmentReader();
    }

    private CyAnnotationsFragmentReader() {
        super();
    }

    @Override
    public final String getAspectName() {
        return CyAnnotationsElement.ASPECT_NAME;
    }

    @Override
    public final AspectElement readElement(final ObjectNode o) throws IOException {
        CyAnnotationsElement ae = new CyAnnotationsElement(
        									ParserUtils.getTextValueRequired(o, CyAnnotationsElement.UUID), 
        									o.get(CyAnnotationsElement.VIEW).asLong());
        
        if (o.has(CyVisualPropertiesElement.PROPERTIES)) {
            final Iterator<Entry<String, JsonNode>> it = o.get(CyVisualPropertiesElement.PROPERTIES).fields();
            if (it != null) {
                while (it.hasNext()) {
                    final Entry<String, JsonNode> kv = it.next();
                    ae.putProperty(kv.getKey(), kv.getValue().asText());
                }

            }
        }
        return ae;
    }

}

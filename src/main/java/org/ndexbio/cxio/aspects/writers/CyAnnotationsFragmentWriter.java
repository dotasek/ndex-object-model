package org.ndexbio.cxio.aspects.writers;

import java.io.IOException;
import java.util.Map;

import org.ndexbio.cxio.aspects.datamodels.CyAnnotationsElement;
import org.ndexbio.cxio.core.interfaces.AspectElement;
import org.ndexbio.cxio.util.JsonWriter;

public class CyAnnotationsFragmentWriter extends AbstractFragmentWriter {

    public static CyAnnotationsFragmentWriter createInstance() {
        return new CyAnnotationsFragmentWriter();
    }

    private CyAnnotationsFragmentWriter() {
    }

    @Override
    public String getAspectName() {
        return CyAnnotationsElement.ASPECT_NAME;
    }

    @Override
    public void writeElement(final AspectElement element, final JsonWriter w) throws IOException {
        final CyAnnotationsElement e = (CyAnnotationsElement) element;
        w.writeStartObject();
        w.writeStringField(CyAnnotationsElement.UUID, e.getUUID());
        w.writeNumberField(CyAnnotationsElement.VIEW, e.getView());
        if ((e.getProperties() != null) && !e.getProperties().isEmpty()) {
			w.writeObjectFieldStart(CyAnnotationsElement.PROPERTIES);
			for (final Map.Entry<String, String> entry : e.getProperties().entrySet()) {
				if (entry.getValue() != null) {
					w.writeStringField(entry.getKey(), entry.getValue());
				}
			}
			w.writeEndObject();
		}
        w.writeEndObject();
    }
}

package org.ndexbio.cxio.aspects.writers;

import java.io.IOException;

import org.ndexbio.cxio.aspects.datamodels.ATTRIBUTE_DATA_TYPE;
import org.ndexbio.cxio.aspects.datamodels.AbstractAttributesAspectElement;
import org.ndexbio.cxio.aspects.datamodels.AbstractElementAttributesAspectElement;
import org.ndexbio.cxio.util.JsonWriter;

public final class WriterUtil {

    public static void writeAttributesElement(final JsonWriter w, final AbstractElementAttributesAspectElement e
    			/*, final AspectKeyFilter filter*/) throws IOException {
    //    if ((filter == null) || filter.isPass(e.getName())) {
            w.writeStartObject();
            w.writeNumberFieldIfNotEmpty(AbstractAttributesAspectElement.ATTR_SUBNETWORK, e.getSubnetwork());
          
            w.writeNumberField(AbstractElementAttributesAspectElement.ATTR_PROPERTY_OF, e.getPropertyOf());
          
            w.writeStringField(AbstractAttributesAspectElement.ATTR_NAME, e.getName());
            if (e.isSingleValue()) {
                w.writeStringField(AbstractAttributesAspectElement.ATTR_VALUES, e.getValue());
            }
            else {
                w.writeList(AbstractAttributesAspectElement.ATTR_VALUES, e.getValues());
            }
            if (e.getDataType() != ATTRIBUTE_DATA_TYPE.STRING) {
                w.writeStringField(AbstractAttributesAspectElement.ATTR_DATA_TYPE, e.getDataType().toString());
            }
            w.writeEndObject();
   //     }
    }
    
    
    public static void writeAttributesElement(final JsonWriter w, final AbstractAttributesAspectElement e 
    		/*, final AspectKeyFilter filter */) throws IOException {
   //     if ((filter == null) || filter.isPass(e.getName())) {
            w.writeStartObject();
            w.writeNumberFieldIfNotEmpty(AbstractAttributesAspectElement.ATTR_SUBNETWORK, e.getSubnetwork());
            
            w.writeStringField(AbstractAttributesAspectElement.ATTR_NAME, e.getName());
            if (e.isSingleValue()) {
                w.writeStringField(AbstractAttributesAspectElement.ATTR_VALUES, e.getValue());
            }
            else {
                w.writeList(AbstractAttributesAspectElement.ATTR_VALUES, e.getValues());
            }
            if (e.getDataType() != ATTRIBUTE_DATA_TYPE.STRING) {
                w.writeStringField(AbstractAttributesAspectElement.ATTR_DATA_TYPE, e.getDataType().toString());
            }
            w.writeEndObject();
   //     }
    }

}

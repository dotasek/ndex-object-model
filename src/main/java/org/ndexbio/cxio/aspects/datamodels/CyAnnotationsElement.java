package org.ndexbio.cxio.aspects.datamodels;

import java.io.IOException;

import org.ndexbio.cxio.util.CxConstants;
import org.ndexbio.cxio.util.JsonWriter;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * This is used to represent an annotation in a network.
 *
 * @author dotasek
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)

public final class CyAnnotationsElement extends AbstractAspectElement {

    /**
	 * 
	 */
	private static final long serialVersionUID = -1305940218684987322L;
	public final static String UUID              ="uuid";
    public final static String ANNOTATION_NAME = "n";
    public final static String ASPECT_NAME     = "cyAnnotations";
    
	@JsonProperty(CxConstants.ID)
    private  String        _uuid;

	@JsonProperty(ANNOTATION_NAME)
    private String        _annotation_name;
	
	public CyAnnotationsElement () {
		_uuid = null;
	}
	

    public CyAnnotationsElement(final String id, final String annotation_name) {
        _uuid = id;
        _annotation_name = annotation_name;
    }


    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        return (o instanceof CyAnnotationsElement) && (_uuid.equals(((CyAnnotationsElement) o).getUUID()));
    }

    @Override
	@JsonIgnore
    final public String getAspectName() {
        return CyAnnotationsElement.ASPECT_NAME;
    }

	@JsonIgnore
    final public String getUUID() {
        return _uuid;
    }
    
    public void setUUID(String uuid) { _uuid = uuid; }

	@JsonIgnore
    public String getAnnotationName() {
        return _annotation_name;
    }
    
	
    
    final public void setAnnotationName( final String annotation_name ) {
        _annotation_name = annotation_name;
    }

    @Override
    public int hashCode() {
        return String.valueOf(_uuid).hashCode();
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        if (_annotation_name != null) {
            sb.append(_annotation_name);
            sb.append(" ");
        }
        sb.append("id: ");
        sb.append(_uuid);
        return sb.toString();
    }

	@Override
	public void write(JsonWriter w) throws IOException {
	       w.writeStartObject();
	       w.writeStringField("uuid", _uuid);
	        if (_annotation_name != null) {
	            w.writeStringField(CyAnnotationsElement.ANNOTATION_NAME, _annotation_name);
	        }
	        w.writeEndObject();	 
	        w.flush();
	} 

}

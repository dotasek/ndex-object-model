package org.ndexbio.cxio.aspects.datamodels;

import java.io.IOException;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

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
	public final static String ASPECT_NAME = "cyAnnotations";
	
	public final static String UUID = "uuid";
	public final static String VIEW = "view";
	public final static String PROPERTIES = "properties";
	
	@JsonProperty(UUID)
	private String _uuid;
	
	@JsonProperty(VIEW)
	private Long _view;

	 final public Long getView() {
	        return _view;
	    }
	    
	    public void setView (Long v) { _view = v;}
	
	@JsonProperty(PROPERTIES)
	// @JsonSerialize(using = AttributeValueSerializer.class)
	private SortedMap<String, String> _properties;

	public final SortedMap<String, String> getProperties() {
		return _properties;
	}

	public void setProperties(SortedMap<String, String> p) {
		_properties = p;
	}

	public final void putProperty(final String name, final String value) {
		_properties.put(name, value);
	}

	public CyAnnotationsElement() {
		_uuid = null;
		_view = null;
		_properties = new TreeMap<>();
	}

	public CyAnnotationsElement(final String uuid, long view) {
		_uuid = uuid;
		_view = view;
		_properties = new TreeMap<>();
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

	public void setUUID(String uuid) {
		_uuid = uuid;
	}

	@Override
	public int hashCode() {
		return String.valueOf(_uuid).hashCode();
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder();
		
		sb.append("uuid: ");
		sb.append(_uuid);
		sb.append("\n");
		
		  sb.append("view: ");
          sb.append(_view);
          sb.append("\n");
		
		sb.append("properties:");
		sb.append("\n");
		for (final Map.Entry<String, String> entry : _properties.entrySet()) {
			sb.append(entry.getKey());
			sb.append(": ");
			sb.append(entry.getValue());
			sb.append("\n");
		}
		return sb.toString();
	}

	@Override
	public void write(JsonWriter w) throws IOException {
		final CyAnnotationsElement c = this;
		w.writeStartObject();
		w.writeStringField(CyAnnotationsElement.UUID, _uuid);
		w.writeNumberField(CyVisualPropertiesElement.VIEW, c.getView());
		
		if ((c.getProperties() != null) && !c.getProperties().isEmpty()) {
			w.writeObjectFieldStart(CyAnnotationsElement.PROPERTIES);
			for (final Map.Entry<String, String> entry : c.getProperties().entrySet()) {
				if (entry.getValue() != null) {
					w.writeStringField(entry.getKey(), entry.getValue());
				}
			}
			w.writeEndObject();
		}

		w.writeEndObject();
		w.flush();
	}

}

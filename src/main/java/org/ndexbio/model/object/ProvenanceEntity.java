package org.ndexbio.model.object;

import java.util.ArrayList;
import java.util.List;

import org.ndexbio.model.object.network.NetworkSummary;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ProvenanceEntity extends NdexObject {

	private List<SimplePropertyValuePair> _properties;
	private ProvenanceEvent _creationEvent;
	private String _uri;

	public ProvenanceEntity () {
		super();
        _type = this.getClass().getSimpleName();
        
        _properties = new ArrayList<SimplePropertyValuePair>();
	}

	public ProvenanceEntity(NetworkSummary networkSummary, String hostURI) {
		super();
		_type = this.getClass().getSimpleName();
		_uri = hostURI + "/network/" + networkSummary.getExternalId();
		_properties = new ArrayList<SimplePropertyValuePair>();
	}

	public List<SimplePropertyValuePair> getProperties() {
		return _properties;
	}

	public void setProperties(List<SimplePropertyValuePair> properties) {
		this._properties = properties;
	}

	public ProvenanceEvent getCreationEvent() {
		return _creationEvent;
	}

	public void setCreationEvent(ProvenanceEvent creationEvent) {
		this._creationEvent = creationEvent;
	}

	public String getUri() {
		return _uri;
	}

	public void setUri(String uri) {
		this._uri = uri;
	}
	
}

package org.ndexbio.model.object.network;

import org.ndexbio.model.object.NdexObject;

public abstract class NetworkElement extends NdexObject {
	
	private long _id;
	
	public NetworkElement () {
		_id = -1;
	}

	public long getId() {
		return _id;
	}

	public void setId(long id) {
		this._id = id;
	}
	


}

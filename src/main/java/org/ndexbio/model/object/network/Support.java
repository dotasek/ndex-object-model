package org.ndexbio.model.object.network;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Support extends NetworkElement
{

	private String _text;
    private long _citationId;



    /**************************************************************************
    * Default constructor.
    **************************************************************************/
    public Support()
    {
        super();
        _type = this.getClass().getSimpleName();
    }



    public String getText()
    {
        return _text;
    }

    public void setText(String text)
    {
        _text = text;
    }

	public long getCitation() {
		return _citationId;
	}

	public void setCitation(long citationId) {
		this._citationId = citationId;
	}
    
    
}

package org.ndexbio.model.object.network;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.ndexbio.model.object.Membership;
import org.ndexbio.model.object.NdexExternalObject;
import org.ndexbio.model.object.NdexProperty;
import org.ndexbio.model.object.PropertiedObject;
import org.ndexbio.model.object.Request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)

public class Network extends NetworkSummary implements PropertiedObject
{
    private Map<Long,Citation> _citations;
    private Map<Long, Edge> _edges;
    private Map<Long,Membership> _members;
    private Map<Long,Namespace> _namespaces;
    
    private Map<Long, Node> _nodes;
    private Map<Long, Request> _requests;
    private Map<Long, Support> _supports;
    private Map<Long, BaseTerm> _baseTerms;
    private Map<Long, FunctionTerm> _functionTerms;
    private Map<Long, ReifiedEdgeTerm> _reifiedEdgeTerms;


	private List<NdexProperty> _properties;
	private List<NdexProperty> _presentationProperties;

    /**************************************************************************
    * Default constructor.
    **************************************************************************/
    public Network()
    {
        super();
        _type = this.getClass().getSimpleName();

        initCollections();
    }


    

    public Map<Long,Citation> getCitations()
    {
        return _citations;
    }

    public void setCitations(Map<Long,Citation> citations)
    {
        _citations = citations;
    }

     public Map<Long, Edge> getEdges()
    {
        return _edges;
    }

    public void setEdges(Map<Long, Edge> edges)
    {
        _edges = edges;
    }

   
    public Map<Long,Membership> getMembers()
    {
        return _members;
    }
    
    public void setMembers(Map<Long,Membership> members)
    {
        _members = members;
    }
    

    public Map<Long,Namespace> getNamespaces()
    {
        return _namespaces;
    }

    public void setNamespaces( Map<Long,Namespace> namespaces)
    {
        _namespaces = namespaces;
    }

    public Map<Long,Node> getNodes()
    {
        return _nodes;
    }

    public void setNodes(Map<Long,Node> nodes)
    {
        _nodes = nodes;
    }
    
    public Map<Long,Request> getRequests()
    {
        return _requests;
    }
    
    public void setRequests(Map<Long,Request> requests)
    {
        _requests = requests;
    }

    public Map<Long, Support> getSupports()
    {
        return _supports;
    }

    public void setSupports(Map<Long, Support> supports)
    {
        _supports = supports;
    }

    

    /**************************************************************************
    * Initializes the collections. 
    **************************************************************************/
    private void initCollections()
    {
        _citations = new HashMap<Long,Citation>();
        _edges = new TreeMap<Long, Edge>();
        _members = new HashMap<Long,Membership>();
        _namespaces = new HashMap<Long,Namespace>();
        _nodes = new TreeMap<Long,Node>();
        _requests = new HashMap<Long,Request>();
        _supports = new HashMap<Long, Support>();
        _baseTerms = new HashMap<Long,BaseTerm>(10);
        
        _functionTerms = new HashMap<Long,FunctionTerm>(10);
        _reifiedEdgeTerms = new HashMap<Long,ReifiedEdgeTerm> (10);
        
        _properties = new ArrayList<NdexProperty> (10);
    	_presentationProperties = new ArrayList<NdexProperty> (10);
    }


	public List<NdexProperty> getProperties() {
		return _properties;
	}

	public List<NdexProperty> getPresentationProperties() {
		return _presentationProperties;
	}

	public void setProperties(List<NdexProperty> properties) {
		_properties = properties;
	}

	public void setPresentationProperties(List<NdexProperty> properties) {
		_presentationProperties = properties;
	}

/*
	public long getHighestElementId() {
		return _highestElementId;
	}



	public void setHighestElementId(long _highestElementId) {
		this._highestElementId = _highestElementId;
	}
*/


	public Map<Long,BaseTerm> getBaseTermIds() {
		return _baseTerms;
	}




	public void setBaseTermIds(Map<Long,BaseTerm> _baseTerms) {
		this._baseTerms = _baseTerms;
	}




	public Map<Long,FunctionTerm> getFunctionTerms() {
		return _functionTerms;
	}




	public void setFunctionTerms(Map<Long,FunctionTerm> _functionTerms) {
		this._functionTerms = _functionTerms;
	}




	public Map<Long,ReifiedEdgeTerm> getReifiedEdgeTerms() {
		return _reifiedEdgeTerms;
	}




	public void setReifiedEdgeTerms(Map<Long,ReifiedEdgeTerm> _reifiedEdgeTerms) {
		this._reifiedEdgeTerms = _reifiedEdgeTerms;
	}
}

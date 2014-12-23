package org.apache.catalina.connector;

import java.io.Serializable;
import java.security.Principal;
/**
 * Generic implementation of <strong>java.security.Principal</strong> that
 * is used to represent principals authenticated at the protocol handler level.
 *
 */
public class CoyotePrincipal implements Principal, Serializable {

	private static final long serialVersionUID = 4364036820337114976L;

	public CoyotePrincipal(String name) {
        this.name = name;
    }

    /**
     * The username of the user represented by this Principal.
     */
    protected String name = null;

    public String getName() {
        return (this.name);
    }

    /**
     * Return a String representation of this object, which exposes only
     * information that should be public.
     */
    public String toString() {
        StringBuffer sb = new StringBuffer("CoyotePrincipal[");
        sb.append(this.name);
        sb.append("]");
        return (sb.toString());
    }
}

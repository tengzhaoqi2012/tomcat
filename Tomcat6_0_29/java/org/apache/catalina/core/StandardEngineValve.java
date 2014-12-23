package org.apache.catalina.core;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.CometEvent;
import org.apache.catalina.Host;
import org.apache.catalina.connector.Request;
import org.apache.catalina.connector.Response;
import org.apache.catalina.util.StringManager;
import org.apache.catalina.valves.ValveBase;

/**
 * Valve that implements the default basic behavior for the
 * <code>StandardEngine</code> container implementation.
 * <p>
 * <b>USAGE CONSTRAINT</b>:  This implementation is likely to be useful only
 * when processing HTTP requests.
 */
final class StandardEngineValve extends ValveBase {

    /**
     * The descriptive information related to this implementation.
     */
    private static final String info = "org.apache.catalina.core.StandardEngineValve/1.0";

    /**
     * The string manager for this package.
     */
    private static final StringManager sm = StringManager.getManager(Constants.Package);

    /**
     * Return descriptive information about this Valve implementation.
     */
    public String getInfo() {
        return (info);
    }

    /**
     * Select the appropriate child Host to process this request,
     * based on the requested server name.  If no matching Host can
     * be found, return an appropriate HTTP error.
     *
     * @param request Request to be processed
     * @param response Response to be produced
     * @param valveContext Valve context used to forward to the next Valve
     *
     * @exception IOException if an input/output error occurred
     * @exception ServletException if a servlet error occurred
     */
    public final void invoke(Request request, Response response) throws IOException, ServletException {
        // Select the Host to be used for this Request
        Host host = request.getHost();
        if (host == null) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST,
            					sm.getString("standardEngine.noHost", 
            					request.getServerName()));
            return;
        }

        // Ask this Host to process this request
        //host.getPipeline().getFirst()Ϊorg.apache.catalina.valves.ErrorReportValve[localhost]
        host.getPipeline().getFirst().invoke(request, response);
    }


    /**
     * Process Comet event.
     *
     * @param request Request to be processed
     * @param response Response to be produced
     * @param valveContext Valve context used to forward to the next Valve
     *
     * @exception IOException if an input/output error occurred
     * @exception ServletException if a servlet error occurred
     */
    public final void event(Request request, Response response, CometEvent event) throws IOException, ServletException {
        // Ask this Host to process this request
        request.getHost().getPipeline().getFirst().event(request, response, event);
    }
}

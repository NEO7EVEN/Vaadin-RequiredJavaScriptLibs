package de.neo7even.vaadin.required.server;

import javax.servlet.ServletException;

import org.json.JSONArray;
import org.json.JSONException;

import com.google.gwt.safehtml.shared.SafeHtmlUtils;
import com.vaadin.server.BootstrapFragmentResponse;
import com.vaadin.server.BootstrapListener;
import com.vaadin.server.BootstrapPageResponse;
import com.vaadin.server.ServiceException;
import com.vaadin.server.SessionInitEvent;
import com.vaadin.server.SessionInitListener;
import com.vaadin.server.VaadinServlet;

public class RequiredJavaScriptLibsServlet extends VaadinServlet {

	private static final long serialVersionUID = -3248321598207418156L;

	@Override
	protected void servletInitialized() throws ServletException {
		super.servletInitialized();
		getService().addSessionInitListener(new SessionInitListener() {
			private static final long serialVersionUID = -7523461351480900529L;

			@Override
			public void sessionInit(SessionInitEvent event) throws ServiceException {
				event.getSession().addBootstrapListener(new BootstrapListener() {
					private String requiredJavaScriptLibraries = getServletConfig().getInitParameter(
							"requiredJavaScriptLibs");
					private static final long serialVersionUID = 5201979684307789630L;

					@Override
					public void modifyBootstrapPage(BootstrapPageResponse response) {
						if (requiredJavaScriptLibraries != null) {
							try {
								JSONArray arr = new JSONArray(requiredJavaScriptLibraries);
								response.getDocument().head()
										.append("<!-- Required JavaScript libraries - START -->\n");
								for (int i = 0; i < arr.length(); i++) {
									response.getDocument()
											.head()
											.append("<script src=\"" + SafeHtmlUtils.htmlEscape(arr.getString(i))
													+ "\" type=\"text/javascript\" language=\"JavaScript\"></script>\n");
								}
								response.getDocument().head().append("<!-- Required JavaScript libraries - END -->\n");
							} catch (JSONException e) {
								e.printStackTrace();
							}
						}

					}

					@Override
					public void modifyBootstrapFragment(BootstrapFragmentResponse response) {

					}
				});
			}
		});
	}
}

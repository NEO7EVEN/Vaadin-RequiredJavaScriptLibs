# Required JavaScript Libraries

//TODO Write README ;-)

```xml
<?xml version="1.0" encoding="UTF-8"?>
<web-app id="WebApp_ID" version="2.4" xmlns="http://java.sun.com/xml/ns/j2ee" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:schemaLocation="http://java.sun.com/xml/ns/j2ee http://java.sun.com/xml/ns/j2ee/web-app_2_4.xsd">
	<display-name>RequiredJavaScriptLibs</display-name>
	<context-param>
		<description>
		Vaadin production mode</description>
		<param-name>productionMode</param-name>
		<param-value>false</param-value>
	</context-param>
	<servlet>
		<servlet-name>Requiredjavascriptlibs Application</servlet-name>
		<!--  Use the RequiredJavaScriptLibsServlet -->
		<servlet-class>de.neo7even.vaadin.required.server.RequiredJavaScriptLibsServlet</servlet-class>
		<init-param>
			<description>
			Vaadin UI class to use</description>
			<param-name>UI</param-name>
			<param-value>de.neo7even.vaadin.required.test.RequiredJavascriptLibsUI</param-value>
		</init-param>
		<!--  List required JavaScript libraries -->
		<init-param>
			<description>URLs of required JavaScript libraries</description>
			<param-name>requiredJavaScriptLibs</param-name>
			<param-value>
				[
					"http://code.jquery.com/jquery-latest.min.js",
					"VAADIN/js/test.js"
				]
			</param-value>
		</init-param>
	</servlet>
	<servlet-mapping>
		<servlet-name>Requiredjavascriptlibs Application</servlet-name>
		<url-pattern>/*</url-pattern>
	</servlet-mapping>
	<welcome-file-list>
		<welcome-file>index.html</welcome-file>
		<welcome-file>index.htm</welcome-file>
		<welcome-file>index.jsp</welcome-file>
		<welcome-file>default.html</welcome-file>
		<welcome-file>default.htm</welcome-file>
		<welcome-file>default.jsp</welcome-file>
	</welcome-file-list>
</web-app>

```
package org.iskconsv.server;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;

@SuppressWarnings("serial")
public class AuthenticationServlet extends HttpServlet
{
	private final String TITLE = "ISKCON of Silicon Valley";
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException
	{
		UserService userService = UserServiceFactory.getUserService();
		PrintWriter out = response.getWriter();

		out.println("<html><head><title>" + TITLE + "</title></head><body>");
		out.println("<h1>Welcome to " + TITLE + "</h1>");
		
		String query = request.getPathInfo();
		if(query == null)
			query = "invalid";

		// TODO: Fix redirection - currently redirects to "/" only
		// user wants to sign in
		if(query.startsWith("login", 1))
		{
			
			String originalReferer = request.getParameter("destination");
			if (originalReferer == null)
				request.getHeader("Referer");
			if (originalReferer == null)
				originalReferer = "/";
			
			String loginURL = userService.createLoginURL(request.getServletPath() + "/loggedIn/?destination=" + originalReferer);
			
			out.println("<h3>Please <a href='" + loginURL + "'>click here</a> if you don't get redirected before you read this.</h3>");
			response.sendRedirect(loginURL);
		}
		
		// user has signed in
		else if (query.startsWith("loggedIn", 1))
		{
			if(request.getUserPrincipal() == null)
			{
				out.println("<h3>Login failed</h3>");
				out.println("<h4><a href='/'>Click here</a> to return to the site.</h4>");
			}
			else
			{
				Cookie usernameCookie = new Cookie("username", userService.getCurrentUser().getEmail());
				usernameCookie.setPath("/");
				
				Cookie nicknameCookie = new Cookie("nickname", userService.getCurrentUser().getNickname());
				nicknameCookie.setPath("/");
				
				// set some cookies
				response.addCookie(usernameCookie);
				response.addCookie(nicknameCookie);
				
				String originalReferer = request.getParameter("destination");
				if (originalReferer == null)
					originalReferer = "/";
				
				// a message no one can read
				out.println("<h4>You have successfully signed in. Redirecting to the application now...</h4>");
				out.println("<h4><a href='" + originalReferer +"'>Click here</a> if it lasts for long enough for you to read.</h4>");
				
				response.sendRedirect(originalReferer);
			}
		}
		
		// user wants to sign out
		else if(query.startsWith("logout", 1))
		{
			response.addCookie(getDeletionCookie("username"));
			response.addCookie(getDeletionCookie("nickname"));
			
			String originalReferer = request.getParameter("destination");
			if(originalReferer == null)
				originalReferer = "/";
			
			response.sendRedirect(userService.createLogoutURL(request.getServletPath() + "/loggedOut/?destination=" + originalReferer));
		}
		
		// user has signed out
		else if(query.startsWith("loggedOut", 1))
		{
			String originalReferer = request.getParameter("destination");
			if(originalReferer == null)
				originalReferer = "/";
			
			out.println("<h2>You have successfully signed out.</h2>");
			out.println("<h3><a href='" + originalReferer + "'>Return to the site</a></h3>");
			
			response.sendRedirect(originalReferer);
		}
		
		// none of the above
		else
		{
			response.setStatus(404);
			out.println("<h2>Page Not Found</h2><h2>You might find <a href='/'>this</a> interesting.</h2>");
		}
		out.println("</body></html>");
	}
	
	private Cookie getDeletionCookie(String name)
	{
		Cookie deleteCookie =  new Cookie(name, "");
		deleteCookie.setMaxAge(0);
		deleteCookie.setPath("/");
		return deleteCookie;
	}
}
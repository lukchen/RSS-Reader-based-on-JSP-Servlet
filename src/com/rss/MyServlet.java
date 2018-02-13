package com.rss;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.soap.Node;

/**
 * Servlet implementation class HelloForm
 */
@WebServlet("/MyServlet")
public class MyServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    public Feed[] feeds = new Feed[10]; 
    public int j=0;
    public boolean isTextNode(Node n){
        return n.getNodeName().equals("#text");
    }
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = request.getParameter("url");
        PrintWriter out = response.getWriter();
        String title = "";
        RSSFeedParser parser = new RSSFeedParser(url);
        Feed feed = parser.readFeed();
        feeds[j]=feed;
        j++;
        request.setAttribute("feed", feeds);
        request.getRequestDispatcher("index.jsp").forward(request, response);
        String site = new String("http://localhost:8080/rss_reader/");
        response.setStatus(response.SC_MOVED_TEMPORARILY);
        response.setHeader("Location", site);   
    	        
    }
    
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
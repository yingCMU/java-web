package servelets;
/*
* Licensed to the Apache Software Foundation (ASF) under one or more
* contributor license agreements.  See the NOTICE file distributed with
* this work for additional information regarding copyright ownership.
* The ASF licenses this file to You under the Apache License, Version 2.0
* (the "License"); you may not use this file except in compliance with
* the License.  You may obtain a copy of the License at
*
*     http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ResourceBundle;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import socket.SocketClientConstants;
import client.CarModelOptionsIO;
import client.DefaultSocketClient;

/**
 * The simplest possible servlet.
 *
 * @author Ying Li
 */

public class CreateModelServelet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
        throws IOException, ServletException
    {
    	String file = request.getParameter("file");
    	response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        DefaultSocketClient client = new DefaultSocketClient("127.0.0.1", SocketClientConstants.AUTO_PORT);
		client.openConnection();
		
		
        CarModelOptionsIO modelIO= new CarModelOptionsIO(client);
		boolean ret = modelIO.loadModelToServer(file);
		String res;
		if(ret)
			res = file + " uploaded to server";
		else
			res = "error  uploading ";
		client.closeSession();
        out.println("<html>");
        out.println("<head>");

        out.println("<title>" + res+"</title>");
        out.println("</head>");
        out.println("<body bgcolor=\"white\">");

        // note that all links are created to be relative. this
        // ensures that we can move the web application that this
        // servlet belongs to to a different place in the url
        // tree and not have any harmful side effects.

        // XXX
        // making these absolute till we work out the
        // addition of a PathInfo issue

        out.println("<a href=\"../helloworld.html\">");
        out.println("<img src=\"../images/code.gif\" height=24 " +
                    "width=24 align=right border=0 alt=\"view code\"></a>");
        out.println("<a href=\"../index.html\">");
        out.println("<img src=\"../images/return.gif\" height=24 " +
                    "width=24 align=right border=0 alt=\"return\"></a>");
        out.println("<h1>"+ res+"</h1>");
        out.println("</body>");
        out.println("</html>");
    }
}




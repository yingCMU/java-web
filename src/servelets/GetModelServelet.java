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
import java.util.ArrayList;
import java.util.ResourceBundle;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import project2.model.Automobile;
import socket.SocketClientConstants;
import client.CarModelOptionsIO;
import client.DefaultSocketClient;
import client.SelectCarOption;

/**
 * The simplest possible servlet.
 *
 * @author Ying Li
 */

public class GetModelServelet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
        throws IOException, ServletException
    {	String model = request.getParameter("model");
    	ArrayList<Automobile> lists= (ArrayList<Automobile>)request.getSession().getAttribute("list");
       //so.listModels();
		System.out.println("get model servlet: model: "+lists.get(Integer.parseInt(model)));
		
		request.setAttribute("auto", (Automobile)lists.get(Integer.parseInt(model)));
		request.getSession().setAttribute("index",model);
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/jsp/choice.jsp");
        dispatcher.forward(request, response);
    }
}




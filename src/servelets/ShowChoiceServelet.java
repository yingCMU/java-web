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
import java.util.HashMap;
import java.util.ResourceBundle;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import project2.exceptions.MissingChoiceException;
import project2.exceptions.MissingModelException;
import project2.exceptions.MissingOptionException;
import project2.exceptions.MissingSetException;
import project2.model.Automobile;
import project2.model.OptionSet;
import socket.SocketClientConstants;
import client.DefaultSocketClient;
import client.SelectCarOption;

/**
 * The simplest possible servlet.
 *
 * @author Ying Li
 */

public class ShowChoiceServelet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
        throws IOException, ServletException
    {
    	HttpSession session = request.getSession();
		ArrayList<Automobile> lists=(ArrayList<Automobile>)session.getAttribute("list");
        int index = Integer.parseInt((String) session.getAttribute("index"));
		Automobile auto = lists.get(index);
		HashMap<String,String> choice = new HashMap<String,String>();
		try{
			auto.setOptionChoice(auto.getOpset(), "Fort Knox Gold Clearcoat Metallic");
			auto.setOptionChoice("Transmission", "standard");
			auto.setOptionChoice("Brakes/Traction Control", "ABS");
			auto.setOptionChoice("Side Impact Air Bags", "selected");
			auto.setOptionChoice("Power Moonroof", "selected");
			System.out.println("!!!!total price: "+auto.getTotalPrice());
			}
			catch(MissingModelException e){
			System.err.println(e.getMessage());
				return;
				
			} catch (MissingSetException e) {
				System.err.println(e.getMessage());
				return;
			} catch (MissingChoiceException e) {
				System.err.println(e.getMessage());
				return;
			} catch (MissingOptionException e) {
				System.err.println(e.getMessage());
				return;
			}
			
		//System.out.println("session lists->"+lists);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/jsp/showChoice.jsp");
        dispatcher.forward(request, response);
    }
}




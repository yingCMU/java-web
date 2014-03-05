<%@ page language="java" %>
<HTML>
<HEAD><TITLE>DynamicForm</TITLE></HEAD>
<BODY>
<CENTER>
<H3>Basic Car Choice</H3>
<FORM METHOD="POST">
<%
    int count = 0;
    try { count = Integer.parseInt("2"); }
    catch (Throwable t) { }
%>
<P>
<INPUT TYPE="TEXT"   NAME="fileName" LENGTH="20">
<INPUT TYPE="SUBMIT" NAME="command" VALUE="Load">
<INPUT TYPE="SUBMIT" NAME="command" VALUE="Save">
<BR><!-- VARIABLE NAME="io_error" -->
<P>
<INPUT TYPE="SUBMIT" NAME="command" VALUE="Append New Row">
<INPUT TYPE="SUBMIT" NAME="command" VALUE="Delete Selected Rows">
<INPUT TYPE="SUBMIT" NAME="command" VALUE="Undo">
<P>
<INPUT TYPE="HIDDEN" NAME="rowArray.length" VALUE="<%=count%>">
<TABLE BORDER="1" CELLPADDING="3" CELLSPACING="1">
    <TR>
        <TH>Selected</TH>
        <TH>Text</TH>
        <TH>Combo</TH>
    </TR>
<%  for (int i = 0; i < count; i++) { %>
    <TR>
        <TD>
            <CENTER>
            <INPUT TYPE="CHECKBOX" NAME="rowArray.<%=i%>.selected">
            </CENTER>
        </TD>
        <TD>
            <INPUT TYPE="TEXT" NAME="rowArray.<%=i%>.text" LENGTH="30">
        </TD>
        <TD>
            <SELECT NAME="rowArray.<%=i%>.combo" SIZE="1">
                <OPTION VALUE=""></OPTION>
                <OPTION VALUE="1">Item 1</OPTION>
                <OPTION VALUE="2">Item 2</OPTION>
                <OPTION VALUE="3">Item 3</OPTION>
            </SELECT>
        </TD>
    </TR>
<%  } %>
</TABLE>
<bean:message key="label.common.html.select.name" /> :
<html:select property="year">
    <html:option value="">-- None --</html:option>
	<html:option value="1980">1980</html:option>
	<html:option value="1981">1981</html:option>
	<html:option value="1982">1982</html:option>
	<html:option value="1983">1983</html:option>
	<html:option value="1984">1984</html:option>
	<html:option value="1985">1985</html:option>
</html:select>
</div>
</FORM>
<!-- VARIABLE NAME="[ERROR_MESSAGE]" -->
<!-- VARIABLE NAME="[ERROR_MESSAGE.fileName]" -->
<%  for (int i = 0; i < count; i++) { %>
    <!-- VARIABLE NAME="[ERROR_MESSAGE.rowArray.<%=i%>.selected]" -->
    <!-- VARIABLE NAME="[ERROR_MESSAGE.rowArray.<%=i%>.text]" -->
    <!-- VARIABLE NAME="[ERROR_MESSAGE.rowArray.<%=i%>.combo]" -->
<%  } %>
</CENTER>
</BODY>
</HTML>
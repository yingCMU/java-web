<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
 
<html>
<head>
</head>
<body>
<h1>Struts html:select example</h1>
 
<html:form action="/Select">
 
<html:messages id="err_name" property="common.select.err">
<div style="color:red">
	<bean:write name="err_name" />
</div>
</html:messages>
 
<div style="padding:16px">
 
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
 
<div style="padding:16px">
	<div style="float:left;padding-right:8px;">
		<html:submit>
                   <bean:message key="label.common.html.select.button.submit" />
                </html:submit>
	</div>
	<html:reset>
           <bean:message key="label.common.html.select.button.reset" />
        </html:reset>
</div>
 
</html:form>
 
</body>
</html>
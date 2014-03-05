<%@ page import="project2.model.*"%> 
<script> 
function jsFunction() {
var sel = document.getElementById("item"); 
var sv = sel.options[sel.selectedIndex].value; 

alert(sv);
//request.setAttribute("auto", sel.selectedIndex);
};
function sbFunc(){
	var sel = document.getElementById("item"); 
	var sv = sel.options[sel.selectedIndex].value; 
	alert(sv);
	//request.setAttribute("auto", sv);

};
</script> 
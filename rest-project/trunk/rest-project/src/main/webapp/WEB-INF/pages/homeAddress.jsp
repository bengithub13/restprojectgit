<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<h2>Spring MVC Multiple Row Form Submit example</h2>
<%@ page isELIgnored="false" %>
    <title>Spring 3 MVC Multipe Row Submit - viralpatel.net</title>
 
 <!-- http://www.dineshonjava.com/2013/10/jstl-foreach-tag.html#.VTstCpNQ1WE -->
<h2>Show Addresses</h2>     
<table width="50%">        
<c:forEach items="${addressesObject.homeAddresses}" var="address" >
        
        
    <tbody><tr>
        <th>street</th>
        <th>zipcode</th>
    </tr>
    <tr>
            <td>${address.street}</td>
            <td>${address.zipCode}</td>
        </tr>
     </c:forEach>
</tbody></table>    
<br>
<input value="Back" onclick="javascript:history.back()" type="button">
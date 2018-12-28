<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<h3 id="screenTitle">Result</h3>

<ul>
<c:forEach items="${pageContext.response.headerNames}" var="name">
  <li>${name} = ${pageContext.response.getHeader(name)}</li>
</c:forEach>
</ul>


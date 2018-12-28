<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title>Spring Security HeaderWriter Sample</title>
</head>
<body>
  <tiles:insertAttribute name="header" />
  <div class="container">
    <tiles:insertAttribute name="body" />
  </div>
  <tiles:insertAttribute name="footer" />
</body>
</html>

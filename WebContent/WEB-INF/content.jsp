<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Calculator</title>
<jsp:include page="CSS/bootstrap.jsp"></jsp:include>
<jsp:include page="CSS/bootstrapmin.jsp"></jsp:include>
<jsp:include page="CSS/dashboard.jsp"></jsp:include>
<jsp:include page="CSS/style.jsp"></jsp:include>
<jsp:include page="CSS/bootstrapjs.jsp"></jsp:include>
<jsp:include page="CSS/bootstrapminjs.jsp"></jsp:include>
<jsp:include page="CSS/set2.jsp"></jsp:include>
<jsp:include page="CSS/demo.jsp"></jsp:include>
<jsp:include page="CSS/normalize.jsp"></jsp:include>
</head>
<body>
	<nav class="navbar navbar-inverse navbar-fixed-top">
      <div class="container-fluid">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="content">Calculator</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
          <ul class="nav navbar-nav navbar-right">
            <li class="hidden-lg hidden-md hidden-sm"><a href="annuite">annuite</a></li>
            <li class="hidden-lg hidden-md hidden-sm"><a href="capital">capital</a></li>
            <li class="hidden-lg hidden-md hidden-sm"><a href="duree">duree</a></li>
            <li class="hidden-lg hidden-md hidden-sm"><a href="content">content</a></li>
          </ul>
        </div>
      </div>
    </nav>

    <div class="container-fluid">
      <div class="row">
        <div class="col-sm-3 col-md-2 sidebar">
          <ul class="nav nav-sidebar">
            <li ><a href="capital">Calcule Capital <span class="sr-only">(current)</span></a></li>
            <li><a href="duree">Calcule Duree</a></li>
            <li><a href="annuite">Calcule Annuite</a></li>
          </ul>
          <ul class="nav nav-sidebar">
            <li class="active"><a href="content">List des calcules</a></li>
          </ul>
        </div>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
          <h1 class="page-header">Content :</h1>
          <div class="table-responsive">
            <table class="table table-striped">
              <thead>
                <tr>
                  <th>#</th>
                  <th>Duree</th>
                  <th>Taux</th>
                  <th>Annuite</th>
                  <th>Capitale</th>
                </tr>
              </thead>
              <tbody>
                <tr>
                <c:forEach var="data" items="${ datas }">
                  <td><c:out value="${ data.id }"></c:out></td>
                  <td><c:out value="${ data.duree }"></c:out></td>
                  <td><c:out value="${ data.taux }"></c:out></td>
                  <td><c:out value="${ data.annuite }"></c:out></td>
                  <td><c:out value="${ data.capitale }"></c:out></td>
                </tr>
                </c:forEach>
              </tbody>
            </table>
          </div>
        </div>
      </div>
    </div>
    
    
<jsp:include page="js/classie.jsp"></jsp:include>
<script>
			(function() {
				// trim polyfill : https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/String/Trim
				if (!String.prototype.trim) {
					(function() {
						// Make sure we trim BOM and NBSP
						var rtrim = /^[\s\uFEFF\xA0]+|[\s\uFEFF\xA0]+$/g;
						String.prototype.trim = function() {
							return this.replace(rtrim, '');
						};
					})();
				}

				[].slice.call( document.querySelectorAll( 'input.input__field' ) ).forEach( function( inputEl ) {
					// in case the input is already filled..
					if( inputEl.value.trim() !== '' ) {
						classie.add( inputEl.parentNode, 'input--filled' );
					}

					// events:
					inputEl.addEventListener( 'focus', onInputFocus );
					inputEl.addEventListener( 'blur', onInputBlur );
				} );

				function onInputFocus( ev ) {
					classie.add( ev.target.parentNode, 'input--filled' );
				}

				function onInputBlur( ev ) {
					if( ev.target.value.trim() === '' ) {
						classie.remove( ev.target.parentNode, 'input--filled' );
					}
				}
			})();
		</script>
		
    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
</body>
</html>
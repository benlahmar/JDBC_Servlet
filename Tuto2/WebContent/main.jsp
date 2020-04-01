<%@page import="com.model.User"%>
<%@page import="com.model.Produit"%>
<%@page import="java.util.List"%>
<%@page import="com.dao.ProduitDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%!
ProduitDao pm=new ProduitDao();
%>
<%
User u=(User)session.getAttribute("user");
%>
    <jsp:include page="header.jsp"></jsp:include>
    <jsp:include page="sidebar.jsp"></jsp:include>
      <!-- Content Wrapper. Contains page content -->
      <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
          <h1>
            Page Header
            <small>Optional description</small>
          </h1>
          <ol class="breadcrumb">
            <li><a href="#"><i class="fa fa-dashboard"></i> Level</a></li>
            <li class="active">Here</li>
          </ol>
        </section>
<%

String dsg="";
double prix=0;
int qte=0;
String des="";
String action="Ajouter";
int id=0;
if(request.getParameter("op")!=null)
{
	if(request.getParameter("op").equals("edit"))
	{
		 id= Integer.parseInt(request.getParameter("id"));
		Produit p=pm.findProduitById(id);
		dsg=p.getDesignation();
		prix=p.getPrix();
		qte=p.getQuantite();
		des=p.getDescrition();
		action="Modifier";
		
	}
}
%>
        <!-- Main content -->
        <section class="content">

          <!-- Your Page Content Here -->
          <div class="row">
          <%
         List<Produit> ps=pm.allproduit();
          for(Produit p: ps)
          {
          %>
         
          <div class="col-lg-3 col-xs-6">
              <!-- small box -->
              <div class=" box box-info box-solid">
              <div class="box-header with-border">
                  <h3 class="box-title">Removable</h3>
                 <div class="box-tools pull-right">
                  <div class="btn btn-box-tool">
                    <button class="btn btn-box-tool" data-widget="remove"><i class="fa fa-times"></i></button>
                  </div><!-- /.box-tools -->
                  <% if(u.getRole().equalsIgnoreCase("admin")) {%>
                  <div class="btn-group ">
                      <button class="btn btn-box-tool dropdown-toggle" data-toggle="dropdown">
                      <i class="fa fa-wrench"></i></button>
                      <ul class="dropdown-menu" role="menu">
                        <li><a href="?op=edit&id=<%=p.getId()%>">Modifier</a></li>
                        <li><a href="serve1?id=<%=p.getId()%>">delete</a></li>
                        <li><a href="#">Something else here</a></li>
                        <li class="divider"></li>
                        <li><a href="#">Separated link</a></li>
                      </ul>
                    </div>
                    <%} %>
                    </div>
                </div>
              <div class="box-body">
              <div class="small-box bg-aqua">
                <div class="inner">
                  <h3><%=p.getPrix() %></h3>
                  <p><%=p.getDesignation() %></p>
                  
                </div>
                <div class="icon">
                  <i class="fa fa-shopping-cart"></i>
                </div>
                <a href="#" class="small-box-footer">
                  More info <i class="fa fa-arrow-circle-right"></i>
                </a>
              </div>
            </div>
            </div>
            </div>
            <%} %>
		</div>
		<div class="row">
		
		<div class="col-md-6">
		<div class="box box-info">
                <div class="box-header with-border">
                  <h3 class="box-title">Horizontal Form</h3>
                </div><!-- /.box-header -->
                <!-- form start -->
                <form class="form-horizontal" action="serve1" method="post">
                  <div class="box-body">
                  <div class="form-group">
                      <label for="inputPassword3" class="col-sm-2 control-label">Id</label>
                      <div class="col-sm-10">
                        <input type="number" readonly="readonly" value="<%=id %>" name="id" class="form-control" id="inputPassword3" placeholder="Password">
                      </div>
                    </div>
                    
                    <div class="form-group">
                      <label for="inputEmail3" class="col-sm-2 control-label">Desigbnation</label>
                      <div class="col-sm-10">
                        <input type="text" name="desg" value="<%=dsg %>" class="form-control" id="inputEmail3" placeholder="Email">
                      </div>
                    </div>
                    <div class="form-group">
                      <label for="inputPassword3" class="col-sm-2 control-label">Prix</label>
                      <div class="col-sm-10">
                        <input type="text" name="prix" value="<%=prix %>" class="form-control" id="inputPassword3" placeholder="Password">
                      </div>
                    </div>
                     <div class="form-group">
                      <label for="inputPassword3" class="col-sm-2 control-label">Quantite</label>
                      <div class="col-sm-10">
                        <input type="number" name="qte" value="<%=qte %>" class="form-control" id="inputPassword3" placeholder="Password">
                      </div>
                    </div>
                     <div class="form-group">
                      <label for="inputPassword3" class="col-sm-2 control-label">Description</label>
                      <div class="col-sm-10">
                        <input type="text" name="desc" value="<%=des %>" class="form-control" id="inputPassword3" placeholder="Password">
                      </div>
                    </div>
                    
                    
                  </div><!-- /.box-body -->
                  <div class="box-footer">
                    <button type="reset" class="btn btn-default">Cancel</button>
                    <button type="submit" class="btn btn-info pull-right" name="action" value="<%=action %>">Add</button>
                  </div><!-- /.box-footer -->
                </form>
              </div>
		</div>
		</div>
        </section><!-- /.content -->
      </div><!-- /.content-wrapper -->

      <!-- Main Footer -->
      <jsp:include page="footer.jsp"></jsp:include>
      <jsp:include page="controlesidebar.jsp"></jsp:include>
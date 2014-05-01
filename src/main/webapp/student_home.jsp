<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ page import="com.cuit.exam.utils.LoginUserUtil" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE HTML>
<html>
<%@ include file="student_base_page.jsp" %>
</head>

<body>
<!-- section header -->
<header class="header fixed affix " data-spy="affix" data-offset-top="0">
    <!--nav bar helper-->
    <div class="navbar-helper">
        <div class="row-fluid">
            <!--panel site-name-->
            <div class="span4">
                <div class="panel-sitename">
                    <h2><a href="index.html"><span
                            class="color-teal"><%=LoginUserUtil.getLoginUser().getUserName()%></span>欢迎你</a></h2>
                </div>
            </div>
            <!--/panel name-->

            <div class="span6">
                <!--panel search-->
                <div class="panel-search">
                </div>
                <!--/panel search-->
            </div>
            <div class="span4">
                <!--panel button ext-->
                <div class="panel-ext">
                </div>
                <!--panel button ext-->
            </div>
        </div>
    </div>
    <!--/nav bar helper-->
</header>

<!-- section content -->
<section class="section">
<div class="row-fluid">
<!-- span side-left -->
<div class="span1">
    <!--side bar-->
    <aside class="side-left">
        <ul class="sidebar">
            <li>
                <a href="index.html" title="dashboard">
                    <div class="helper-font-24">
                        <i class="icofont-dashboard"></i>
                    </div>
                    <span class="sidebar-text">Dashboard</span>
                </a>
            </li>
            <li>
                <a href="interface.html" title="interface">
                    <div class="helper-font-24">
                        <i class="icofont-magnet"></i>
                    </div>
                    <span class="sidebar-text">Interface</span>
                </a>
            </li>
            <li>
                <a href="form.html" title="form">
                    <div class="badge badge-important">3</div>
                    <div class="helper-font-24">
                        <i class="icofont-edit"></i>
                    </div>
                    <span class="sidebar-text">Form</span>
                </a>
                <ul class="sub-sidebar-form corner-top shadow-white">
                    <li class="title muted">Quick Upload</li>
                    <li>
                        <input type="file" data-form="uniform" onchange="alert('your progres uploading file...')"/>
                    </li>
                    <li class="divider"></li>
                    <li>
                        <a href="form.html" title="form element" class="corner-all">
                            <i class="icofont-file"></i>
                            <span class="sidebar-text">Form Element</span>
                        </a>
                    </li>
                    <li class="divider"></li>
                    <li>
                        <a href="code_editor.html" title="code editor" class="corner-all">
                            <i class="icofont-book"></i>
                            <span class="sidebar-text">Code Editor</span>
                        </a>
                    </li>
                    <li>
                        <a href="gallery.html" title="gallery" class="corner-all">
                            <i class="icofont-picture"></i>
                            <span class="sidebar-text">Gallery</span>
                        </a>
                    </li>
                </ul>
            </li>
            <li>
                <a href="charts.html" title="charts">
                    <div class="helper-font-24">
                        <i class="icofont-bar-chart"></i>
                    </div>
                    <span class="sidebar-text">charts</span>
                </a>
            </li>
            <li>
                <a href="tables.html" title="table">
                    <div class="helper-font-24">
                        <i class="icofont-table"></i>
                    </div>
                    <span class="sidebar-text">Tables</span>
                </a>
            </li>
            <li class="active">
                <a href="grids.html" title="grids">
                    <div class="helper-font-24">
                        <i class="icofont-columns"></i>
                    </div>
                    <span class="sidebar-text">Grids</span>
                </a>
            </li>
            <li>
                <a href="icons.html" title="icons">
                    <div class="helper-font-24">
                        <i class="icofont-star"></i>
                    </div>
                    <span class="sidebar-text">Icons</span>
                </a>
            </li>
            <li>
                <a href="widgets.html" title="widgets">
                    <div class="helper-font-24">
                        <i class="icofont-reorder"></i>
                    </div>
                    <span class="sidebar-text">Widgets</span>
                </a>
            </li>
            <li>
                <a href="#" title="more">
                    <div class="badge badge-important">5</div>
                    <div class="helper-font-24">
                        <i class="icofont-th-large"></i>
                    </div>
                    <span class="sidebar-text">More</span>
                </a>
                <ul class="sub-sidebar corner-top shadow-silver-dark">
                    <li>
                        <a href="404.html" title="not found">
                            <div class="helper-font-24">
                                <i class="icofont-warning-sign"></i>
                            </div>
                            <span class="sidebar-text">404</span>
                        </a>
                    </li>
                    <li>
                        <a href="login.html" title="login">
                            <div class="helper-font-24">
                                <i class="icofont-lock"></i>
                            </div>
                            <span class="sidebar-text">Login</span>
                        </a>
                    </li>
                    <li>
                        <a href="invoice.html" title="invoice">
                            <div class="helper-font-24">
                                <i class="icofont-barcode"></i>
                            </div>
                            <span class="sidebar-text">Invoice</span>
                        </a>
                    </li>
                    <li>
                        <a href="pricing.html" title="pricing table">
                            <div class="helper-font-24">
                                <i class="icofont-briefcase"></i>
                            </div>
                            <span class="sidebar-text">Pricing</span>
                        </a>
                    </li>
                    <li class="divider"></li>
                    <li>
                        <a href="bonus-page/resume/index.html" title="resume">
                            <div class="helper-font-24">
                                <i class="icofont-user"></i>
                            </div>
                            <span class="sidebar-text">Resume</span>
                        </a>
                    </li>
                </ul>
            </li>
        </ul>
    </aside>
    <!--/side bar -->
</div>
<!-- span side-left -->

<!-- span content -->
<div class="span11">
<!-- content -->
<div class="content">
<!-- content-breadcrumb -->
<div class="content-breadcrumb" style="top: 8px;position: relative;">

    <!--/breadcrumb-nav-->

    <!--breadcrumb-->
    <ul class="breadcrumb">
        <li><a href="index.html"><i class="icofont-home"></i> Dashboard</a> <span class="divider">&rsaquo;</span></li>
        <li><a href="grids.html">Grids</a> <span class="divider">&rsaquo;</span></li>
        <li class="active">Data elements</li>
    </ul>
    <!--/breadcrumb-->
</div>
<!-- /content-breadcrumb -->

<!-- content-body -->
<div class="content-body">
<!-- grids -->
<!-- span12-->
<div class="row-fluid">
    <div class="span12">
        <div class="box corner-all">
            <div class="box-header grd-white">
                <div class="header-control">
                    <a data-box="collapse"><i class="icofont-caret-up"></i></a>
                    <a data-box="close" data-hide="bounceOutRight">&times;</a>
                </div>
                <span>Span12</span>
            </div>
            <div class="box-body">
                <p>Lorem ipsum dolor sit amet, natoque per at morbi at vestibulum leo, velit non, curabitur ac est.
                    Donec sit mollis imperdiet at tristique dapibus, qui vel in at fusce congue, mi arcu fusce, lacus
                    vitae diam aliquam vel sed curabitur, auctor libero sed libero lectus pellentesque. Et sagittis ut
                    vel dolor nullam proin, porta et morbi turpis vestibulum massa, ligula vestibulum nascetur wisi sed
                    pharetra sem, lorem ipsam. Purus deserunt dignissim imperdiet, orci arcu felis, a aliquam sed.</p>
            </div>
        </div>
    </div>
</div>
<!-- span12-->

<!-- nested-->
<div class="row-fluid">
    <div class="span12">
        <div class="box corner-all">
            <div class="box-header grd-white">
                <div class="header-control">
                    <a data-box="collapse"><i class="icofont-caret-up"></i></a>
                    <a data-box="close" data-hide="bounceOutRight">&times;</a>
                </div>
                <span>Nested</span>
            </div>
            <div class="box-body">
                <div class="row-fluid">
                    <div class="span6">
                        <div class="box corner-all">
                            <div class="box-header grd-white">
                                <div class="header-control">
                                    <a data-box="collapse"><i class="icofont-caret-up"></i></a>
                                    <a data-box="close" data-hide="bounceOutRight">&times;</a>
                                </div>
                                <span>Span6</span>
                            </div>
                            <div class="box-body">
                                <p>Lorem ipsum dolor sit amet, natoque per at morbi at vestibulum leo, velit non,
                                    curabitur ac est. Donec sit mollis imperdiet at tristique dapibus, qui vel in at
                                    fusce congue, mi arcu fusce, lacus vitae diam aliquam vel sed curabitur, auctor
                                    libero sed libero lectus pellentesque. Et sagittis ut vel dolor nullam proin, porta
                                    et morbi turpis vestibulum massa, ligula vestibulum nascetur wisi sed pharetra sem,
                                    lorem ipsam. Purus deserunt dignissim imperdiet, orci arcu felis, a aliquam sed.</p>
                            </div>
                        </div>
                    </div>
                    <div class="span6">
                        <div class="box corner-all">
                            <div class="box-header grd-white">
                                <div class="header-control">
                                    <a data-box="collapse"><i class="icofont-caret-up"></i></a>
                                    <a data-box="close" data-hide="bounceOutRight">&times;</a>
                                </div>
                                <span>Span6</span>
                            </div>
                            <div class="box-body">
                                <p>Lorem ipsum dolor sit amet, natoque per at morbi at vestibulum leo, velit non,
                                    curabitur ac est. Donec sit mollis imperdiet at tristique dapibus, qui vel in at
                                    fusce congue, mi arcu fusce, lacus vitae diam aliquam vel sed curabitur, auctor
                                    libero sed libero lectus pellentesque. Et sagittis ut vel dolor nullam proin, porta
                                    et morbi turpis vestibulum massa, ligula vestibulum nascetur wisi sed pharetra sem,
                                    lorem ipsam. Purus deserunt dignissim imperdiet, orci arcu felis, a aliquam sed.</p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- nested-->

<!-- span8-->
<div class="row-fluid">
    <div class="span8">
        <div class="box corner-all">
            <div class="box-header grd-white">
                <div class="header-control">
                    <a data-box="collapse"><i class="icofont-caret-up"></i></a>
                    <a data-box="close" data-hide="bounceOutRight">&times;</a>
                </div>
                <span>Span8</span>
            </div>
            <div class="box-body">
                <p>Lorem ipsum dolor sit amet, natoque per at morbi at vestibulum leo, velit non, curabitur ac est.
                    Donec sit mollis imperdiet at tristique dapibus, qui vel in at fusce congue, mi arcu fusce, lacus
                    vitae diam aliquam vel sed curabitur, auctor libero sed libero lectus pellentesque. Et sagittis ut
                    vel dolor nullam proin, porta et morbi turpis vestibulum massa, ligula vestibulum nascetur wisi sed
                    pharetra sem, lorem ipsam. Purus deserunt dignissim imperdiet, orci arcu felis, a aliquam sed.</p>
            </div>
        </div>
    </div>
    <div class="span4">
        <div class="box corner-all">
            <div class="box-header grd-white">
                <div class="header-control">
                    <a data-box="collapse"><i class="icofont-caret-up"></i></a>
                    <a data-box="close" data-hide="bounceOutRight">&times;</a>
                </div>
                <span>Span4</span>
            </div>
            <div class="box-body">
                <p>Lorem ipsum dolor sit amet, natoque per at morbi at vestibulum leo, velit non, curabitur ac est.
                    Donec sit mollis imperdiet at tristique dapibus, qui vel in at fusce congue, mi arcu fusce, lacus
                    vitae diam aliquam vel sed curabitur, auctor libero sed libero lectus pellentesque. Et sagittis ut
                    vel dolor nullam proin, porta et morbi turpis vestibulum massa, ligula vestibulum nascetur wisi sed
                    pharetra sem, lorem ipsam. Purus deserunt dignissim imperdiet, orci arcu felis, a aliquam sed.</p>
            </div>
        </div>
    </div>
</div>
<!-- span8-->

<!-- span6-->
<div class="row-fluid">
    <div class="span6">
        <div class="box corner-all">
            <div class="box-header grd-white">
                <div class="header-control">
                    <a data-box="collapse"><i class="icofont-caret-up"></i></a>
                    <a data-box="close" data-hide="bounceOutRight">&times;</a>
                </div>
                <span>Span6</span>
            </div>
            <div class="box-body">
                <p>Lorem ipsum dolor sit amet, natoque per at morbi at vestibulum leo, velit non, curabitur ac est.
                    Donec sit mollis imperdiet at tristique dapibus, qui vel in at fusce congue, mi arcu fusce, lacus
                    vitae diam aliquam vel sed curabitur, auctor libero sed libero lectus pellentesque. Et sagittis ut
                    vel dolor nullam proin, porta et morbi turpis vestibulum massa, ligula vestibulum nascetur wisi sed
                    pharetra sem, lorem ipsam. Purus deserunt dignissim imperdiet, orci arcu felis, a aliquam sed.</p>
            </div>
        </div>
    </div>
    <div class="span6">
        <div class="box corner-all">
            <div class="box-header grd-white">
                <div class="header-control">
                    <a data-box="collapse"><i class="icofont-caret-up"></i></a>
                    <a data-box="close" data-hide="bounceOutRight">&times;</a>
                </div>
                <span>Span6</span>
            </div>
            <div class="box-body">
                <p>Lorem ipsum dolor sit amet, natoque per at morbi at vestibulum leo, velit non, curabitur ac est.
                    Donec sit mollis imperdiet at tristique dapibus, qui vel in at fusce congue, mi arcu fusce, lacus
                    vitae diam aliquam vel sed curabitur, auctor libero sed libero lectus pellentesque. Et sagittis ut
                    vel dolor nullam proin, porta et morbi turpis vestibulum massa, ligula vestibulum nascetur wisi sed
                    pharetra sem, lorem ipsam. Purus deserunt dignissim imperdiet, orci arcu felis, a aliquam sed.</p>
            </div>
        </div>
    </div>
</div>
<!-- span6-->

<!-- span4-->
<div class="row-fluid">
    <div class="span4">
        <div class="box corner-all">
            <div class="box-header grd-white">
                <div class="header-control">
                    <a data-box="collapse"><i class="icofont-caret-up"></i></a>
                    <a data-box="close" data-hide="bounceOutRight">&times;</a>
                </div>
                <span>Span4</span>
            </div>
            <div class="box-body">
                <p>Lorem ipsum dolor sit amet, natoque per at morbi at vestibulum leo, velit non, curabitur ac est.
                    Donec sit mollis imperdiet at tristique dapibus, qui vel in at fusce congue, mi arcu fusce, lacus
                    vitae diam aliquam vel sed curabitur, auctor libero sed libero lectus pellentesque. Et sagittis ut
                    vel dolor nullam proin, porta et morbi turpis vestibulum massa, ligula vestibulum nascetur wisi sed
                    pharetra sem, lorem ipsam. Purus deserunt dignissim imperdiet, orci arcu felis, a aliquam sed.</p>
            </div>
        </div>
    </div>
    <div class="span4">
        <div class="box corner-all">
            <div class="box-header grd-white">
                <div class="header-control">
                    <a data-box="collapse"><i class="icofont-caret-up"></i></a>
                    <a data-box="close" data-hide="bounceOutRight">&times;</a>
                </div>
                <span>Span4</span>
            </div>
            <div class="box-body">
                <p>Lorem ipsum dolor sit amet, natoque per at morbi at vestibulum leo, velit non, curabitur ac est.
                    Donec sit mollis imperdiet at tristique dapibus, qui vel in at fusce congue, mi arcu fusce, lacus
                    vitae diam aliquam vel sed curabitur, auctor libero sed libero lectus pellentesque. Et sagittis ut
                    vel dolor nullam proin, porta et morbi turpis vestibulum massa, ligula vestibulum nascetur wisi sed
                    pharetra sem, lorem ipsam. Purus deserunt dignissim imperdiet, orci arcu felis, a aliquam sed.</p>
            </div>
        </div>
    </div>
    <div class="span4">
        <div class="box corner-all">
            <div class="box-header grd-white">
                <div class="header-control">
                    <a data-box="collapse"><i class="icofont-caret-up"></i></a>
                    <a data-box="close" data-hide="bounceOutRight">&times;</a>
                </div>
                <span>Span4</span>
            </div>
            <div class="box-body">
                <p>Lorem ipsum dolor sit amet, natoque per at morbi at vestibulum leo, velit non, curabitur ac est.
                    Donec sit mollis imperdiet at tristique dapibus, qui vel in at fusce congue, mi arcu fusce, lacus
                    vitae diam aliquam vel sed curabitur, auctor libero sed libero lectus pellentesque. Et sagittis ut
                    vel dolor nullam proin, porta et morbi turpis vestibulum massa, ligula vestibulum nascetur wisi sed
                    pharetra sem, lorem ipsam. Purus deserunt dignissim imperdiet, orci arcu felis, a aliquam sed.</p>
            </div>
        </div>
    </div>
</div>
<!-- span4-->

<!-- span3-->
<div class="row-fluid">
    <div class="span3">
        <div class="box corner-all">
            <div class="box-header grd-white">
                <div class="header-control">
                    <a data-box="collapse"><i class="icofont-caret-up"></i></a>
                    <a data-box="close" data-hide="bounceOutRight">&times;</a>
                </div>
                <span>Span3</span>
            </div>
            <div class="box-body">
                <p>Lorem ipsum dolor sit amet, natoque per at morbi at vestibulum leo, velit non, curabitur ac est.
                    Donec sit mollis imperdiet at tristique dapibus, qui vel in at fusce congue, mi arcu fusce, lacus
                    vitae diam aliquam vel sed curabitur, auctor libero sed libero lectus pellentesque.</p>
            </div>
        </div>
    </div>
    <div class="span3">
        <div class="box corner-all">
            <div class="box-header grd-white">
                <div class="header-control">
                    <a data-box="collapse"><i class="icofont-caret-up"></i></a>
                    <a data-box="close" data-hide="bounceOutRight">&times;</a>
                </div>
                <span>Span3</span>
            </div>
            <div class="box-body">
                <p>Lorem ipsum dolor sit amet, natoque per at morbi at vestibulum leo, velit non, curabitur ac est.
                    Donec sit mollis imperdiet at tristique dapibus, qui vel in at fusce congue, mi arcu fusce, lacus
                    vitae diam aliquam vel sed curabitur, auctor libero sed libero lectus pellentesque.</p>
            </div>
        </div>
    </div>
    <div class="span3">
        <div class="box corner-all">
            <div class="box-header grd-white">
                <div class="header-control">
                    <a data-box="collapse"><i class="icofont-caret-up"></i></a>
                    <a data-box="close" data-hide="bounceOutRight">&times;</a>
                </div>
                <span>Span3</span>
            </div>
            <div class="box-body">
                <p>Lorem ipsum dolor sit amet, natoque per at morbi at vestibulum leo, velit non, curabitur ac est.
                    Donec sit mollis imperdiet at tristique dapibus, qui vel in at fusce congue, mi arcu fusce, lacus
                    vitae diam aliquam vel sed curabitur, auctor libero sed libero lectus pellentesque.</p>
            </div>
        </div>
    </div>
    <div class="span3">
        <div class="box corner-all">
            <div class="box-header grd-white">
                <div class="header-control">
                    <a data-box="collapse"><i class="icofont-caret-up"></i></a>
                    <a data-box="close" data-hide="bounceOutRight">&times;</a>
                </div>
                <span>Span3</span>
            </div>
            <div class="box-body">
                <p>Lorem ipsum dolor sit amet, natoque per at morbi at vestibulum leo, velit non, curabitur ac est.
                    Donec sit mollis imperdiet at tristique dapibus, qui vel in at fusce congue, mi arcu fusce, lacus
                    vitae diam aliquam vel sed curabitur, auctor libero sed libero lectus pellentesque.</p>
            </div>
        </div>
    </div>
</div>
<!-- span3-->

<!--/grids-->
</div>
<!--/content-body -->
</div>
<!-- /content -->
</div>
<!-- /span content -->

</div>
</section>

<!-- section footer -->
<footer>
    <a rel="to-top" href="#top"><i class="icofont-circle-arrow-up"></i></a>
</footer>
</body>
</html>

/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.68
 * Generated at: 2022-12-02 09:07:18 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views.reservation;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class insertReservation_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP들은 오직 GET, POST 또는 HEAD 메소드만을 허용합니다. Jasper는 OPTIONS 메소드 또한 허용합니다.");
        return;
      }
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>୧(๑•̀ᗝ•́)૭</title>\r\n");
      out.write("<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js\"></script>\r\n");
      out.write("<script src=\"https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.min.js\"></script>\r\n");
      out.write("<link href=\"https://fonts.googleapis.com/css2?family=Jua&display=swap\" rel=\"stylesheet\">\r\n");
      out.write("<style>\r\n");
      out.write("    body { background-color : #F6F6F6;}\r\n");
      out.write("    /* 전체 컨테이너 */\r\n");
      out.write("	#container{ width: 100%; display: inline-block; text-align: center;}\r\n");
      out.write("	\r\n");
      out.write("	\r\n");
      out.write("	\r\n");
      out.write("	+\r\n");
      out.write("	#r_arrow { width : 10px; height : 15px; margin-right : 15px; margin-left : 15px;}\r\n");
      out.write("	#p_location { width : 100%; height : 50px; text-align : center; font-weight : bold; color:#848484; background-color :#d2d2d2;\r\n");
      out.write("	  margin-top : 15px; margin-bottom : 15px; font-size : 1.1em; border-top : 2px solid orange; border-bottom : 2px solid orange;\r\n");
      out.write("	}\r\n");
      out.write("	\r\n");
      out.write("    /* 페이지 제목 */\r\n");
      out.write("    #page_name{ width: 1000px; display: inline-block; font-family: 'Jua'; font-size: xx-large; \r\n");
      out.write("        text-align: left; margin-top: 20px;}\r\n");
      out.write("    /* 내용부분 전체 */\r\n");
      out.write("    #info_div{ width: 1000px; display: inline-block;}\r\n");
      out.write("    /* 항공기 정보 */\r\n");
      out.write("    #f_info{ width: 1000px; height: 300px; border: 1px solid black; border-radius: 3px; margin-bottom: 30px;}\r\n");
      out.write("    #personnal{ font-family: \"Jua\"; text-align: left;}\r\n");
      out.write("    #person_img{width: 20px; height: 20px;}\r\n");
      out.write("    #f_info{ text-align: left; position: relative;}\r\n");
      out.write("    #f_info_img{position: relative;}\r\n");
      out.write("    #f_info p{ font-family: \"Jua\";}\r\n");
      out.write("    #airplane{width: 150px; height: 150px; position: absolute; top: 75px; left: 75px;}\r\n");
      out.write("    #arrow{ width: 75px; height: 75px; position: absolute; top: 105px; left: 290px;}\r\n");
      out.write("    #arrow_text1{ position: absolute; top:70px; left: 290px;}\r\n");
      out.write("    #arrow_text2{ position: absolute; top:160px; left: 320px;}\r\n");
      out.write("    #f_info_con{ width: 560px; height: 150px; position: absolute;\r\n");
      out.write("        top: 50px; right: 0; font-family: 'Jua'; font-size: large;}\r\n");
      out.write("    /* 정보 받아올 항목 */\r\n");
      out.write("    #f_info_con_up{ width: 100%; height: 50%;  position: relative;}\r\n");
      out.write("    #f_info_con_down{ width: 100%; height: 50%; position: relative; margin-top: 50px;}\r\n");
      out.write("\r\n");
      out.write("    #from_eng{ position: absolute; top:0px; left: 0px;}\r\n");
      out.write("    #from_kor{ position: absolute; top:0px; left: 40px;}\r\n");
      out.write("    #from_arrow{ position: absolute; top:-5px; left: 170px;}\r\n");
      out.write("    #to_eng{ position: absolute; top:0px; left: 230px;}\r\n");
      out.write("    #to_kor{ position: absolute; top:0px; left: 270px;}\r\n");
      out.write("    #from_date{ position: absolute; top:40px; left: 0px;}\r\n");
      out.write("    #from_time{ position: absolute; top:36px; left: 130px;}\r\n");
      out.write("    #plain_name{ position: absolute; top:40px; left: 290px;}\r\n");
      out.write("    #seat_lv{ position: absolute; top:40px; left: 400px;}\r\n");
      out.write("\r\n");
      out.write("    #from_eng2{ position: absolute; top:0px; left: 0px;}\r\n");
      out.write("    #from_kor2{ position: absolute; top:0px; left: 40px;}\r\n");
      out.write("    #from_arrow2{ position: absolute; top:-5px; left: 170px;}\r\n");
      out.write("    #to_eng2{ position: absolute; top:0px; left: 230px;}\r\n");
      out.write("    #to_kor2{ position: absolute; top:0px; left: 270px;}\r\n");
      out.write("    #from_date2{ position: absolute; top:40px; left: 0px;}\r\n");
      out.write("    #from_time2{ position: absolute; top:36px; left: 130px;}\r\n");
      out.write("    #plain_name2{ position: absolute; top:40px; left: 290px;}\r\n");
      out.write("    #seat_lv2{ position: absolute; top:40px; left: 400px;}\r\n");
      out.write("\r\n");
      out.write("    #personnal_data{width: 1000px; display: inline-block; }\r\n");
      out.write("    .person_data p{font-family: \"Jua\"; text-align: left; font-size: larger;}\r\n");
      out.write("    .person_data input[type=text]{ width: 350px; height: 50px; border: none; border-bottom: 1px solid black;\r\n");
      out.write("         background: none; font-size: larger; outline: none;}\r\n");
      out.write("    .person_data input[type=button]{ width: 170px; height: 40px;}\r\n");
      out.write("    \r\n");
      out.write("    .person_data{ width: 1000px; height: 370px; margin-bottom: 30px; background-color: #dcdcdc; position: relative;}\r\n");
      out.write("    .name_f_p{ position: absolute; top: 20px; left: 50px;}\r\n");
      out.write("    .name_f{ position: absolute; top: 60px; left: 50px;}\r\n");
      out.write("    .name_p{ position: absolute; top: 20px; left: 550px;}\r\n");
      out.write("    .name{ position: absolute; top: 60px; left: 550px;}\r\n");
      out.write("    .ph_p{ position: absolute; top: 130px; left: 50px;}\r\n");
      out.write("    .ph{ position: absolute; top: 170px; left: 50px;}\r\n");
      out.write("    .birthday_p{ position: absolute; top: 130px; left: 550px;}\r\n");
      out.write("    .birthday{ position: absolute; top: 170px; left: 550px;}\r\n");
      out.write("    .gender_p{ position: absolute; top: 240px; left: 50px; }\r\n");
      out.write("    .male{ position: absolute; top: 290px; left: 50px; border: none; font-family: 'Jua';}\r\n");
      out.write("    .female{ position: absolute; top: 290px; left: 230px; border: none; font-family: 'Jua';}\r\n");
      out.write("    #btn_submit{ width: 350px; height: 40px; position: absolute; top: 290px; left: 550px;\r\n");
      out.write("        background-color: #ff5000; border: none; border-radius: 3px; color: white;\r\n");
      out.write("         font-family: 'Jua'; font-size: larger;} \r\n");
      out.write("\r\n");
      out.write("</style>\r\n");
      out.write("<script>\r\n");
      out.write("   $(document).ready(function(){\r\n");
      out.write("	   let personnal_data = \"<form action='/reservation/insertReservation.do' method='post'>\";\r\n");
      out.write("       let personnal_num = (Number)($(\"#personnal_num\").html());\r\n");
      out.write("       personnal_data += \"<input type='hidden' name='reserve_info' id='reserve_info' value='");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${reserve_info }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("'>\"\r\n");
      out.write("      \r\n");
      out.write("       \r\n");
      out.write("       for(let i = 1; i <= personnal_num; i++){\r\n");
      out.write("    	   personnal_data += \"<div class='person_data'>\";\r\n");
      out.write("           personnal_data += \"<p class='name_f_p'>성(영문)</p><input type='text' name='firstName\" + i + \"' class='name_f' value='");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${reserve_info.firstName1}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("' readonly>\"\r\n");
      out.write("           personnal_data += \"<p class='name_p'>이름(영문)</p><input type='text' name='lastName\" + i + \"' class='name' value='' readonly>\"\r\n");
      out.write("           personnal_data += \"<p class='ph_p'>연락처</p><input type='text' name='phone\" + i + \"' class='ph' value='");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${reserve_info.phone1}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("' readonly>\"\r\n");
      out.write("           personnal_data += \"<p class='birthday_p'>생년월일(YYYY-MM-DD)</p><input type='text' name='birthDate\" + i + \"' class='birthday' value='");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${reserve_info.birthDate1}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("' readonly>\"\r\n");
      out.write("           personnal_data += \"<p class='gender_p'>성별</p><input type='button' id='male\" + i + \"' class='male' value='남성'> <input type='button' id='female\" + i + \"' class='female' value='여성'> \"\r\n");
      out.write("           personnal_data += \"<input type='hidden' id='gender\" + i + \"' name='gender\" + i + \"' value='남성'>\"\r\n");
      out.write("       \r\n");
      out.write("           if(i == personnal_num){\r\n");
      out.write("        	   personnal_data += \"<input type='hidden' id='asdf' name='fwd_flight_id' value='");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${reserve_info.fwd_flight_id }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("'>\"\r\n");
      out.write("               personnal_data += \"<input type='hidden' name='fwd_seat_id' value='");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${reserve_info.fwd_seat_id  }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("'>\"\r\n");
      out.write("               personnal_data += \"<input type='hidden' name='fwd_departTime' value='");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${reserve_info.fwd_seat_id }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("'>\"\r\n");
      out.write("               personnal_data += \"<input type='hidden' name='fwd_arrivalTime' value='");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${reserve_info.fwd_arrivalTime }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("'>\"\r\n");
      out.write("               personnal_data += \"<input type='hidden' name='fwd_date' value='");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${reserve_info.fwd_date }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("'>\"\r\n");
      out.write("               personnal_data += \"<input type='hidden' name='fwd_depart_airportName' value='");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${reserve_info.fwd_depart_airportName }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("'>\"\r\n");
      out.write("               personnal_data += \"<input type='hidden' name='fwd_depart_airportCode' value='");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${reserve_info.fwd_depart_airportCode }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("'>\"\r\n");
      out.write("               personnal_data += \"<input type='hidden' name='fwd_arrived_airportName' value='");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${reserve_info.fwd_arrived_airportName }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("'>\"\r\n");
      out.write("               personnal_data += \"<input type='hidden' name='fwd_arrived_airportCode' value='");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${reserve_info.fwd_arrived_airportCode }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("'>\"\r\n");
      out.write("               personnal_data += \"<input type='hidden' name='fwd_depart_datetime' value='");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${reserve_info.fwd_depart_datetime}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("'>\"\r\n");
      out.write("               personnal_data += \"<input type='hidden' name='fwd_arrival_datetime' value='");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${reserve_info.fwd_arrival_datetime}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("'>\"\r\n");
      out.write("               \r\n");
      out.write("               personnal_data += \"<input type='hidden' name='bwd_flight_id' value='");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${reserve_info.bwd_flight_id }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("'>\"\r\n");
      out.write("               personnal_data += \"<input type='hidden' name='bwd_seat_id' value='");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${reserve_info.bwd_seat_id  }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("'>\"\r\n");
      out.write("               personnal_data += \"<input type='hidden' name='bwd_departTime' value='");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${reserve_info.bwd_departTime }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("'>\"\r\n");
      out.write("               personnal_data += \"<input type='hidden' name='bwd_arrivalTime' value='");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${reserve_info.bwd_arrivalTime }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("'>\"\r\n");
      out.write("               personnal_data += \"<input type='hidden' name='bwd_date' value='");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${reserve_info.bwd_date }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("'>\"\r\n");
      out.write("               personnal_data += \"<input type='hidden' name='bwd_depart_airportName' value='");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${reserve_info.bwd_depart_airportName }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("'>\"\r\n");
      out.write("               personnal_data += \"<input type='hidden' name='bwd_depart_airportCode' value='");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${reserve_info.bwd_depart_airportCode }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("'>\"\r\n");
      out.write("               personnal_data += \"<input type='hidden' name='bwd_arrived_airportName' value='");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${reserve_info.bwd_arrived_airportName }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("'>\"\r\n");
      out.write("               personnal_data += \"<input type='hidden' name='bwd_arrived_airportCode' value='");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${reserve_info.bwd_arrived_airportCode }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("'>\"\r\n");
      out.write("               personnal_data += \"<input type='hidden' name='bwd_depart_datetime' value='");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${reserve_info.bwd_depart_datetime}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("'>\"\r\n");
      out.write("               personnal_data += \"<input type='hidden' name='bwd_arrival_datetime' value='");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${reserve_info.bwd_arrival_datetime}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("'>\"\r\n");
      out.write("               personnal_data += \"<input type='hidden' name='passengerCnt' value='\" + i + \"'>\"\r\n");
      out.write("			   \r\n");
      out.write("               personnal_data += \"<input type='submit' id='btn_submit' value='예약하기'>\"\r\n");
      out.write("               personnal_data += \"</form></div>\"\r\n");
      out.write("           }\r\n");
      out.write("           else{\r\n");
      out.write("               personnal_data += \"</div>\"\r\n");
      out.write("           }\r\n");
      out.write("       }\r\n");
      out.write("       \r\n");
      out.write("       console.log(personnal_data);\r\n");
      out.write("       \r\n");
      out.write("       $(\"#personnal_data\").html(personnal_data);\r\n");
      out.write("       \r\n");
      out.write("       const aaaaaa = $(\"#reserve_info\").val();\r\n");
      out.write("       console.log(JSON.parse(aaaaaa));\r\n");
      out.write("\r\n");
      out.write("   })\r\n");
      out.write("</script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("    ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/header.jsp", out, false);
      out.write("\r\n");
      out.write("	<div id=\"container\">\r\n");
      out.write("		<div id=\"p_location\">\r\n");
      out.write("			<div style=\"display: inline-block;text-align:left; width:1070px; margin-top : 14px;\">\r\n");
      out.write("				<span>홈<img id=\"r_arrow\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/resources/images/r_arrow.png\">항공권 예매<img id=\"r_arrow\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/resources/images/r_arrow.png\">탑승자정보입력</span>\r\n");
      out.write("			</div>\r\n");
      out.write("		</div>\r\n");
      out.write("        <div id=\"page_name\">탑승자 정보 입력</div>\r\n");
      out.write("        <br><br>\r\n");
      out.write("\r\n");
      out.write("        <div id=\"info_div\">\r\n");
      out.write("            <div id=\"personnal\"><img id=\"person_img\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/resources/images/person.png\"> 성인 <a id=\"personnal_num\">1</a>명</div>\r\n");
      out.write("            <div id=\"f_info\">\r\n");
      out.write("                <div id=\"f_info_img\">\r\n");
      out.write("                    <p id=\"arrow_text1\">가는편</p>\r\n");
      out.write("                    <img id=\"airplane\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/resources/images/airplane.png\">\r\n");
      out.write("                    <img id=\"arrow\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/resources/images/arrow_double.png\">\r\n");
      out.write("                    <p id=\"arrow_text2\">오는편</p>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div id=\"f_info_con\">\r\n");
      out.write("                    <div id=\"f_info_con_up\">\r\n");
      out.write("                        <div id=\"from_eng\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${reserve_info.fwd_depart_airportCode }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("</div>\r\n");
      out.write("                        <div id=\"from_kor\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${reserve_info.fwd_depart_airportName }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("</div>\r\n");
      out.write("                        <div id=\"from_arrow\">▶</div>\r\n");
      out.write("                        <div id=\"to_eng\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${reserve_info.fwd_arrived_airportCode }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("</div>\r\n");
      out.write("                        <div id=\"to_kor\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${reserve_info.fwd_arrived_airportName }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("</div>\r\n");
      out.write("                        <div id=\"from_date\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${reserve_info.fwd_date }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("</div>\r\n");
      out.write("                        <div id=\"from_time\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${reserve_info.fwd_departTime }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write(' ');
      out.write('~');
      out.write(' ');
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${reserve_info.fwd_arrivalTime }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("</div>\r\n");
      out.write("                        <div id=\"plain_name\">KE704</div>\r\n");
      out.write("                        <div id=\"seat_lv\">일반석</div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div id=\"f_info_con_down\">\r\n");
      out.write("                        <div id=\"from_eng2\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${reserve_info.bwd_depart_airportCode }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("</div>\r\n");
      out.write("                        <div id=\"from_kor2\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${reserve_info.bwd_depart_airportName }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("</div>\r\n");
      out.write("                        <div id=\"from_arrow2\">▶</div>\r\n");
      out.write("                        <div id=\"to_eng2\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${reserve_info.bwd_arrived_airportCode }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("</div>\r\n");
      out.write("                        <div id=\"to_kor2\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${reserve_info.bwd_arrived_airportName }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("</div>\r\n");
      out.write("                        <div id=\"from_date2\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${reserve_info.bwd_date }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("</div>\r\n");
      out.write("                        <div id=\"from_time2\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${reserve_info.bwd_departTime }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write(' ');
      out.write('~');
      out.write(' ');
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${reserve_info.bwd_arrivalTime }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("</div>\r\n");
      out.write("                        <div id=\"plain_name2\">KE704</div>\r\n");
      out.write("                        <div id=\"seat_lv2\">일반석</div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("        <div id=\"personnal_data\">\r\n");
      out.write("           \r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("	</div>\r\n");
      out.write("    ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/footer.jsp", out, false);
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}

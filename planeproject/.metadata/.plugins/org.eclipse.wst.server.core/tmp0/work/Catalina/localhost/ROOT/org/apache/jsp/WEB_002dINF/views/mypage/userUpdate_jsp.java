/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.68
 * Generated at: 2022-12-15 12:50:10 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views.mypage;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class userUpdate_jsp extends org.apache.jasper.runtime.HttpJspBase
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
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP?????? ?????? GET, POST ?????? HEAD ??????????????? ???????????????. Jasper??? OPTIONS ????????? ?????? ???????????????.");
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
      out.write("<title>??????????????????</title>\r\n");
      out.write("<script src=\"https://code.jquery.com/jquery-latest.min.js\"></script>\r\n");
      out.write("<style>\r\n");
      out.write("	body { background-color : #F6F6F6;}\r\n");
      out.write("	\r\n");
      out.write("	#r_arrow { width : 10px; height : 15px; margin-right : 15px; margin-left : 15px;}\r\n");
      out.write("	#join_img { width : 30px; height : 30px; margin-bottom : 40px; margin-right : 124px;}\r\n");
      out.write("	\r\n");
      out.write("	#p_location { \r\n");
      out.write("		width : 100%;\r\n");
      out.write("		height : 50px;\r\n");
      out.write("		text-align : center;\r\n");
      out.write("		font-weight : bold;\r\n");
      out.write("		color:#848484; \r\n");
      out.write("		background-color :#d2d2d2; \r\n");
      out.write("		margin-top : 15px; \r\n");
      out.write("		margin-bottom : 15px; \r\n");
      out.write("		font-size : 1.1em;\r\n");
      out.write("		border-top : 2px solid orange;\r\n");
      out.write("		border-bottom : 2px solid orange;\r\n");
      out.write("	}\r\n");
      out.write("		\r\n");
      out.write("	.form-wrapper {\r\n");
      out.write("		display: flex;\r\n");
      out.write("		flex-direction: column;\r\n");
      out.write("		justify-content: center;\r\n");
      out.write("		align-items: center;\r\n");
      out.write("		margin-top : 20px;\r\n");
      out.write("		margin-bottom : 30px;\r\n");
      out.write("	}\r\n");
      out.write("	\r\n");
      out.write("	#updateForm {\r\n");
      out.write("		width: 400px;\r\n");
      out.write("		text-align: center;\r\n");
      out.write("	}\r\n");
      out.write("	\r\n");
      out.write("	#updateForm .label-wrapper {\r\n");
      out.write("		margin-top: 20px;\r\n");
      out.write("		display: flex;\r\n");
      out.write("		justify-content: space-between;\r\n");
      out.write("		align-items: center;\r\n");
      out.write("	}\r\n");
      out.write("	\r\n");
      out.write("	#updateForm input {\r\n");
      out.write("		width: 100%;\r\n");
      out.write("		height: 25px;\r\n");
      out.write("		border: 0px;\r\n");
      out.write("		background-color : #F6F6F6;\r\n");
      out.write("	}\r\n");
      out.write("	\r\n");
      out.write("	#updateForm div {\r\n");
      out.write("		display: flex;\r\n");
      out.write("		align-items: center;\r\n");
      out.write("	}\r\n");
      out.write("	\r\n");
      out.write("	#btnIdCheck {\r\n");
      out.write("		width: 50px;\r\n");
      out.write("		height: 25px;\r\n");
      out.write("		border-radius: 0; \r\n");
      out.write("		border : 0px; \r\n");
      out.write("		background-color: #787878; \r\n");
      out.write("		color: white;\r\n");
      out.write("		margin-left: 55px;\r\n");
      out.write("	}\r\n");
      out.write("\r\n");
      out.write("	#btnUpdate { width: 400px; height: 50px; border-radius: 4px; border : 0px; background-color: #787878; color: white; font-size: 1.0em; margin-top: 10px;}\r\n");
      out.write("\r\n");
      out.write("	.label-wrapper { margin-bottom: 10px;}\r\n");
      out.write("</style>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("	");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/header.jsp", out, false);
      out.write("\r\n");
      out.write("	<div id=\"p_location\">\r\n");
      out.write("		<div style=\"display: inline-block;text-align:left; width:1070px; margin-top : 14px;\">\r\n");
      out.write("			<span>???????????????<img id=\"r_arrow\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/resources/images/r_arrow.png\">???????????? ??????</span>\r\n");
      out.write("		</div>\r\n");
      out.write("	</div>\r\n");
      out.write("	<div class=\"form-wrapper\">\r\n");
      out.write("		<form id=\"updateForm\" action=\"/Account/updateInfo.do\" method=\"post\">\r\n");
      out.write("			<input type=\"hidden\" id=\"updateMsg\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${updateMsg}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\">\r\n");
      out.write("			<div>\r\n");
      out.write("				<img id=\"join_img\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/resources/images/join.png\">\r\n");
      out.write("				<h2 style=\"margin-bottom : 60px; margin-left : -30px;\">???????????? ??????</h2>\r\n");
      out.write("			</div>\r\n");
      out.write("			<div class=\"label-wrapper\" style=\"margin-bottom : 65px; margin-top : -10px; margin-left : 165px; font-size : 1.1em;\">\r\n");
      out.write("				<label for=\"fullName\"><strong>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${loginUser.fullName}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("???</strong></label>\r\n");
      out.write("			</div>\r\n");
      out.write("			<input type=\"hidden\" id=\"userId\" name=\"userId\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${loginUser.userId}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\">\r\n");
      out.write("			<div class=\"label-wrapper\">\r\n");
      out.write("				<label for=\"currentPassword\">?????? ????????????</label>\r\n");
      out.write("			</div>\r\n");
      out.write("			<input type=\"password\" id=\"currentPassword\" name=\"currentPassword\" required>\r\n");
      out.write("			<hr>\r\n");
      out.write("			<p id=\"currentMsg\"></p>\r\n");
      out.write("			<div class=\"label-wrapper\">\r\n");
      out.write("				<label for=\"password\">????????? ????????????</label>\r\n");
      out.write("			</div>\r\n");
      out.write("			<input type=\"password\" id=\"password\" name=\"password\" required>\r\n");
      out.write("			<hr>\r\n");
      out.write("			<p id=\"pwValidation\" style=\"color: red; font-size: 0.8rem;\">\r\n");
      out.write("				??????????????? ?????????, ??????, ???????????? ????????? 9?????? ???????????? ??????????????????.\r\n");
      out.write("			</p>\r\n");
      out.write("			<div class=\"label-wrapper\">\r\n");
      out.write("				<label for=\"passwordCheck\">???????????? ??????</label>\r\n");
      out.write("			</div>\r\n");
      out.write("			<input type=\"password\" id=\"passwordCheck\" name=\"passwordCheck\" required>\r\n");
      out.write("			<hr>\r\n");
      out.write("			<p id=\"pwCheckResult\" style=\"font-size: 0.8rem;\"></p>\r\n");
      out.write("			<div class=\"label-wrapper\">\r\n");
      out.write("				<label for=\"lastName\">???</label>\r\n");
      out.write("			</div>\r\n");
      out.write("			<input type=\"text\" id=\"lastName\" name=\"lastName\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${loginUser.lastName}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\">\r\n");
      out.write("			<hr>\r\n");
      out.write("			<div class=\"label-wrapper\">\r\n");
      out.write("				<label for=\"firstName\">??????</label>\r\n");
      out.write("			</div>\r\n");
      out.write("			<input type=\"text\" id=\"firstName\" name=\"firstName\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${loginUser.firstName}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\">\r\n");
      out.write("			<hr>\r\n");
      out.write("			<div class=\"label-wrapper\">\r\n");
      out.write("				<label for=\"birthDate\">????????????</label>\r\n");
      out.write("			</div>\r\n");
      out.write("			<input type=\"date\" id=\"birthDate\" name=\"birthDate\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${loginUser.birthDate}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\" min=\"1900-01-01\" max=\"2022-11-23\">\r\n");
      out.write("			<div class=\"label-wrapper\">\r\n");
      out.write("				<label for=\"phone\">????????????</label>\r\n");
      out.write("			</div>\r\n");
      out.write("			<input type=\"text\" id=\"phone\" name=\"phone\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${loginUser.phone}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\">\r\n");
      out.write("			<hr>\r\n");
      out.write("			<div class=\"label-wrapper\">\r\n");
      out.write("				<label for=\"address\">??????</label>\r\n");
      out.write("			</div>\r\n");
      out.write("			<input type=\"text\" id=\"address\" name=\"address\" size=\"59\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${loginUser.address}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\">\r\n");
      out.write("			<hr>\r\n");
      out.write("			<div style=\"display: block; margin: 20px auto;\">\r\n");
      out.write("				<button type=\"submit\" id=\"btnUpdate\">????????????</button>\r\n");
      out.write("			</div>\r\n");
      out.write("		</form>\r\n");
      out.write("	</div>\r\n");
      out.write("	");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/footer.jsp", out, false);
      out.write("\r\n");
      out.write("	<script>\r\n");
      out.write("		$(function() {\r\n");
      out.write("			\r\n");
      out.write("			//???????????? ?????? ?????? ??? ????????? ??????\r\n");
      out.write("			if($(\"#updateMsg\").val() != \"\" && $(\"#updateMsg\").val() != null) {\r\n");
      out.write("				alert($(\"#updateMsg\").val());\r\n");
      out.write("			}\r\n");
      out.write("			\r\n");
      out.write("			\r\n");
      out.write("			//?????? ??????????????? ??????????????? ???????????? ?????????\r\n");
      out.write("			var currentPwCheck = false;\r\n");
      out.write("			//password??? ????????? ?????? ???????????????(???????????? + ????????? + ?????? 8??????)\r\n");
      out.write("			var pwValidation = false;\r\n");
      out.write("			//password??? ???????????? ???????????????\r\n");
      out.write("			var pwCheck = false;\r\n");
      out.write("			\r\n");
      out.write("			$(\"#pwValidation\").hide();\r\n");
      out.write("			$(\"#pwCheckResult\").hide();\r\n");
      out.write("\r\n");
      out.write("			//???????????? ????????? ??????\r\n");
      out.write("			function validatePassword(character) {\r\n");
      out.write("				return /^(?=.*[a-zA-Z])(?=.*[!@#$%^&*+=-])(?=.*[0-9]).{9,}$/.test(character);\r\n");
      out.write("			}\r\n");
      out.write("			\r\n");
      out.write("			//???????????? ?????????????????? ????????? ??????\r\n");
      out.write("			$(\"#password\").on(\"change\", function() {\r\n");
      out.write("				//???????????? ????????? ??????\r\n");
      out.write("				if(!validatePassword($(\"#password\").val())) {\r\n");
      out.write("					pwValidation = false;\r\n");
      out.write("					$(\"#pwValidation\").show();\r\n");
      out.write("					$(\"#password\").focus();\r\n");
      out.write("				} else {\r\n");
      out.write("					pwValidation = true;\r\n");
      out.write("					$(\"#pwValidation\").hide();\r\n");
      out.write("				}\r\n");
      out.write("				\r\n");
      out.write("				//???????????? ???????????? ????????? ??? ?????? ???????????? ?????????\r\n");
      out.write("				if($(\"#password\").val() == $(\"#passwordCheck\").val()) {\r\n");
      out.write("					pwCheck = true;\r\n");
      out.write("					$(\"#pwCheckResult\").css(\"color\", \"green\");\r\n");
      out.write("					$(\"#pwCheckResult\").text(\"??????????????? ???????????????.\");\r\n");
      out.write("				} else {\r\n");
      out.write("					pwCheck = false;\r\n");
      out.write("					$(\"#pwCheckResult\").css(\"color\", \"red\");\r\n");
      out.write("					$(\"#pwCheckResult\").text(\"??????????????? ???????????? ????????????.\");\r\n");
      out.write("				}\r\n");
      out.write("			});\r\n");
      out.write("			\r\n");
      out.write("			//???????????? ????????? ????????? ??? ???????????? ??????\r\n");
      out.write("			$(\"#passwordCheck\").on(\"change\", function() {\r\n");
      out.write("				$(\"#pwCheckResult\").show();\r\n");
      out.write("				\r\n");
      out.write("				if($(\"#password\").val() == $(\"#passwordCheck\").val()) {\r\n");
      out.write("					pwCheck = true;\r\n");
      out.write("					$(\"#pwCheckResult\").css(\"color\", \"green\");\r\n");
      out.write("					$(\"#pwCheckResult\").text(\"??????????????? ???????????????.\");\r\n");
      out.write("				} else {\r\n");
      out.write("					pwCheck = false;\r\n");
      out.write("					$(\"#pwCheckResult\").css(\"color\", \"red\");\r\n");
      out.write("					$(\"#pwCheckResult\").text(\"??????????????? ???????????? ????????????.\");\r\n");
      out.write("				}\r\n");
      out.write("			});\r\n");
      out.write("			\r\n");
      out.write("			//???????????? ?????? ??????\r\n");
      out.write("			$(\"#updateForm\").on(\"submit\", function(e) {\r\n");
      out.write("				\r\n");
      out.write("				//???????????? ????????? ????????? ????????? ???\r\n");
      out.write("				if(!pwValidation) {\r\n");
      out.write("					alert(\"??????????????? ?????????, ??????, ???????????? ????????? 9?????? ???????????? ???????????????.\");\r\n");
      out.write("					$(\"#password\").focus();\r\n");
      out.write("					e.preventDefault();\r\n");
      out.write("					return;\r\n");
      out.write("				}\r\n");
      out.write("				\r\n");
      out.write("				//??????????????? ???????????? ????????? ???????????? ?????? ???\r\n");
      out.write("				if(!pwCheck) {\r\n");
      out.write("					alert(\"??????????????? ???????????? ????????????.\");\r\n");
      out.write("					$(\"#passwordCheck\").focus();\r\n");
      out.write("					e.preventDefault();\r\n");
      out.write("					return;\r\n");
      out.write("				}\r\n");
      out.write("				\r\n");
      out.write("				//?????? ???????????? ???????????? ?????? ???\r\n");
      out.write("				if(!currentPwCheck) {\r\n");
      out.write("					alert(\"?????? ??????????????? ???????????? ????????????.\");\r\n");
      out.write("					$(\"#currentPassword\").focus();\r\n");
      out.write("					e.preventDefault();\r\n");
      out.write("					return;\r\n");
      out.write("				}\r\n");
      out.write("			});\r\n");
      out.write("			\r\n");
      out.write("			//?????? ???????????? ??????\r\n");
      out.write("			$(\"#currentPassword\").on(\"change\", function() {\r\n");
      out.write("				$.ajax({\r\n");
      out.write("					url: \"/Account/currentPwdCheck.do\",\r\n");
      out.write("					type: 'post',\r\n");
      out.write("					data: {\r\n");
      out.write("						userId: $(\"#userId\").val() ,\r\n");
      out.write("						currentPassword: $(\"#currentPassword\").val() \r\n");
      out.write("					},\r\n");
      out.write("					success: function(obj) {\r\n");
      out.write("						if(obj == 'pwdOk') {\r\n");
      out.write("							currentPwCheck = true;\r\n");
      out.write("							$(\"#currentMsg\").text(\"??????????????? ??????????????????.\").css(\"color\",\"green\");\r\n");
      out.write("						} else {\r\n");
      out.write("							currentPwCheck = false;\r\n");
      out.write("							$(\"#currentMsg\").text(\"??????????????? ?????? ??????????????????.\").css(\"color\",\"red\");\r\n");
      out.write("						}\r\n");
      out.write("					},\r\n");
      out.write("					error: function(e) {\r\n");
      out.write("						console.log(e);\r\n");
      out.write("					}\r\n");
      out.write("				});\r\n");
      out.write("			});\r\n");
      out.write("		});\r\n");
      out.write("	</script>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
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

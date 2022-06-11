package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("    <title>WIFI-airdrop</title>\n");
      out.write("    <link rel=\"stylesheet\" href=\"css/main.css\">\n");
      out.write("    <link rel=\"stylesheet\" href=\"css/font.css\">\n");
      out.write("    <script src=\"js/clipboard.min.js\"></script>\n");
      out.write("</head>\n");
      out.write("\n");
      out.write("<body>\n");

    String clipBoard= (String) application.getAttribute("clipBoard");

      out.write("\n");
      out.write("<div class=\"_1nK53-\"><img src=\"res/swufelogo.png\" alt=\"logo\" class=\"_3jtTy3\">\n");
      out.write("    <div class=\"_1nX2tW _1x8lgF\">仿airdrop传输</div>\n");
      out.write("    <div class=\"_3bzYjy\"><span class=\"_1nX2tW _1x8lgF\">发送文件</span></div>\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("<div class=\"_2KMkak\">\n");
      out.write("    <div class=\"_8bl-qe\">\n");
      out.write("        <div class=\"_3AsA1Y\">\n");
      out.write("            <div class=\"MQm7zy\">上传文件</div>\n");
      out.write("        </div>\n");
      out.write("        <form action=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/upload.do\" enctype=\"multipart/form-data\" method=\"post\">\n");
      out.write("            <div class=\"_2NI-Bu\">\n");
      out.write("                <div class=\"_38jnea\">\n");
      out.write("                    <input type=\"text\" class=\"_1ItMl6 _2iTtOQ\" id=\"txtFile\" name=\"txtFile\" value=\"\" />\n");
      out.write("                    <input type=\"button\" class=\"_1efWOZ _3WTb49\" value=\"开始上传\" onclick=\"checkFile()\" />\n");
      out.write("                    <input type=\"file\" class=\"input_file\" id=\"file1\" style=\"display:none\"  name=\"file1\" onchange=\"document.getElementById('txtFile').value=this.value\" />\n");
      out.write("\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            <input type=\"submit\" class=\"_1efWOZ _3WTb49\">\n");
      out.write("            <input type=\"reset\" class=\"_1efWOZ _3WTb49\">\n");
      out.write("        </form>\n");
      out.write("    </div>\n");
      out.write("    <div class=\"_8bl-qe\">\n");
      out.write("        <div class=\"_3AsA1Y\">\n");
      out.write("            <div class=\"MQm7zy\">复制粘贴面板</div>\n");
      out.write("        </div>\n");
      out.write("        <div class=\"_2NI-Bu\">\n");
      out.write("            <div class=\"_38jnea\">\n");
      out.write("                    <textarea class=\"_1ItMl6 _2iTtOQ\" id=\"clipboard2\" name=\"content2\" style=\"resize:none\" >");

                        if (clipBoard != null) {
                            out.print(clipBoard);
                        }
                    
      out.write("</textarea>\n");
      out.write("\n");
      out.write("            </div>\n");
      out.write("            <div  class=\"_38jnea\">\n");
      out.write("                <button class=\"btn\" data-clipboard-target=\"#clipboard2\">复制</button>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("</div>\n");
      out.write("<script>\n");
      out.write("    var clipboard = new ClipboardJS('.btn');\n");
      out.write("    clipboard.on('success', function (e) {\n");
      out.write("        alert(\"复制成功！\");\n");
      out.write("    });\n");
      out.write("    clipboard.on('error', function (e) {\n");
      out.write("        alert(\"复制失败！\")\n");
      out.write("    });\n");
      out.write("</script>\n");
      out.write("<script type=\"text/javascript\">\n");
      out.write("    function checkFile(){\n");
      out.write("        document.getElementById(\"file1\").click();\n");
      out.write("    }\n");
      out.write("</script>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<form method=post action=\"process.jsp\" id=\"clipboard_form\">\n");
      out.write("    <input type=\"hidden\" id=\"clipboard\" rows=\"10\" cols=\"30\"  name=\"content\" type =\"hidden\" value=\"");
if(clipBoard!=null) {out.print(clipBoard);}
      out.write("\">\n");
      out.write("</form>\n");
      out.write("\n");
      out.write("<script type=\"text/javascript\">\n");
      out.write("    function copyToClipboard(text,callback) {\n");
      out.write("        // 实现复制方法一：\n");
      out.write("        if (navigator.clipboard) {\n");
      out.write("            navigator.clipboard.writeText(text);\n");
      out.write("            callback && callback(true);\n");
      out.write("            return;\n");
      out.write("        }\n");
      out.write("        // 实现复制方法二：\n");
      out.write("        var copyInput = document.getElementById('COPY_INPUT');\n");
      out.write("        if (!copyInput) {\n");
      out.write("            copyInput = document.createElement('input');\n");
      out.write("            copyInput.setAttribute('id', 'COPY_INPUT');\n");
      out.write("            copyInput.style.position = 'fixed';\n");
      out.write("            copyInput.style.left = '-100%';\n");
      out.write("            copyInput.style.top = '0';\n");
      out.write("            copyInput.style.zIndex = -100;\n");
      out.write("            copyInput.style.opacity = 0;\n");
      out.write("            document.body.appendChild(copyInput);\n");
      out.write("        }\n");
      out.write("        copyInput.value = text;\n");
      out.write("        copyInput.focus();\n");
      out.write("        copyInput.select();\n");
      out.write("        // document.execCommand 可能会被废弃\n");
      out.write("        if (document.execCommand('copy')) {\n");
      out.write("            document.execCommand('copy');\n");
      out.write("        }\n");
      out.write("        copyInput.blur();\n");
      out.write("        callback && callback(true);\n");
      out.write("    }\n");
      out.write("    var x = document.getElementById(\"clipboard2\").innerHTML;\n");
      out.write("    if (x != null || x != \"\") {\n");
      out.write("        // alert(x);\n");
      out.write("        copyToClipboard(x);\n");
      out.write("    }\n");
      out.write("</script>\n");
      out.write("<script type=\"text/javascript\">\n");
      out.write("    document.addEventListener('copy',function(e){\n");
      out.write("        // 获得clipboardData 对象\n");
      out.write("        let clipboardData = e.clipboardData || window.clipboardData;\n");
      out.write("        var form=document.getElementById(\"clipboard_form\");\n");
      out.write("        // 如果 未复制或者未剪切，直接 return\n");
      out.write("        if(!clipboardData) return ;\n");
      out.write("        // 获得 Selection 对象 表示用户选择的文本范围或光标的当前位置。\n");
      out.write("        // 将用户输入的剪切或者复制的文本转化为字符串\n");
      out.write("        let text = window.getSelection().toString();\n");
      out.write("        if(text){\n");
      out.write("            // 如果文本存在，首先取消默认行为\n");
      out.write("            e.preventDefault();\n");
      out.write("            console.log(\"可以获取\",text);\n");
      out.write("            document.getElementById(\"clipboard\").value=text;\n");
      out.write("            alert('复制成功');\n");
      out.write("            form.submit();\n");
      out.write("        }\n");
      out.write("    })\n");
      out.write("</script>\n");
      out.write("\n");
      out.write("\n");
      out.write("</body>\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}

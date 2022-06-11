package com.swufe.servlet;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.ProgressListener;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.UUID;

public class FileServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // �ж��ϴ����ļ���ͨ�����Ǵ��ļ��ı�
        if (!ServletFileUpload.isMultipartContent(request)) {
            return;//��ֹ��������,˵������һ����ͨ�ı�,ֱ�ӷ���
        }
        //�����ϴ��ļ��ı���·��,������WEB-INF·����,��ȫ,�û��޷�ֱ�ӷü��ϴ����ļ�;
        String uploadPath =this.getServletContext().getRealPath("/WEB-INF/upload");
        File uploadFile = new File(uploadPath);
        if (!uploadFile.exists()){
            uploadFile.mkdir(); //�������Ŀ¼
        }
        //���棬��ʱ�ļ�
        //��ʱ·���������ļ�������Ԥ�ڵĴ�С�����ǾͰ�������һ����ʱ�ļ��У��������Զ�ɾ�������������û�תΪ����
        String tmpPath = this.getServletContext().getRealPath("/WEB-INF/tmp");
        File tmpFile = new File(tmpPath);
        if (!tmpFile.exists()) {
            tmpFile.mkdir();//���������ʱĿ¼
        }

        // �����ϴ����ļ�,һ�㶼��Ҫͨ��������ȡ,���ǿ���ʹ�� request.getInputstream(),ԭ��̬���ļ��ϴ�����ȡ,ʮ���鷳
        // ���ǽ���ʹ�� Apache���ļ��ϴ������ʵ��, common-fileupload,����Ҫ������commons-io���;
        try {
            // 1������DiskFileItemFactory���󣬴����ļ�·�����ߴ�С����
            DiskFileItemFactory factory = getDiskFileItemFactory(tmpFile);

            // 2����ȡServletFileUpload
            ServletFileUpload upload = getServletFileUpload(factory);

            // 3�������ϴ��ļ�
            // ��ǰ�������������װ��FileItem������Ҫ��ServletFileUpload�����л�ȡ
            String msg = uploadParseRequest(upload, request, uploadPath);

            // Servlet����ת����Ϣ
            System.out.println(msg);
            if(msg.equals("�ļ��ϴ��ɹ�!")) {
                // Servlet����ת����Ϣ
                request.setAttribute("msg",msg);
                request.getRequestDispatcher("info.jsp").forward(request, response);
            }else {
                msg ="���ϴ��ļ�";
                request.setAttribute("msg",msg);
                //ת��
                request.getRequestDispatcher("info.jsp").forward(request, response);
            }

        } catch (FileUploadException e) {
            // TODO �Զ����ɵ� catch ��
            e.printStackTrace();
        }

    }
    // 1������DiskFileItemFactory���󣬴����ļ�·�����ߴ�С����
    /*
     * ͨ�������������һ��������,���ϴ����ļ����������������ʱ��,
     * �����ŵ���ʱ�ļ� factory.setSizeThreshold(1024 *1024);
     * ��������СΪ1M factory.setRepository (file);//��ʱĿ¼�ı���Ŀ¼,��Ҫһ��File
     */
    public static DiskFileItemFactory getDiskFileItemFactory(File file) {
        DiskFileItemFactory factory = new DiskFileItemFactory();
        // ͨ�������������һ��������,���ϴ����ļ����������������ʱ��,�����ŵ���ʱ�ļ���;
        factory.setSizeThreshold(1024 * 1024);// ��������СΪ1M
        factory.setRepository(file);// ��ʱĿ¼�ı���Ŀ¼,��Ҫһ��file
        return factory;
    }
    // 2����ȡServletFileUpload
    public static ServletFileUpload getServletFileUpload(DiskFileItemFactory factory) {
        ServletFileUpload upload = new ServletFileUpload(factory);
        // �����ļ��ϴ�����
        upload.setProgressListener(new ProgressListener() {

            // pBYtesRead:�Ѷ�ȡ�����ļ���С
            // pContextLength:�ļ���С
            public void update(long pBytesRead, long pContentLength, int pItems) {
                System.out.println("�ܴ�С��" + pContentLength + "���ϴ���" + pBytesRead);
            }
        });

        // ������������
        upload.setHeaderEncoding("UTF-8");
        // ���õ����ļ������ֵ
        upload.setFileSizeMax(1024 * 1024 * 10);
        // �����ܹ��ܹ��ϴ��ļ��Ĵ�С
        // 1024 = 1kb * 1024 = 1M * 10 = 10��
        upload.setSizeMax(1024*1024*10);

        return upload;
    }
    // 3�������ϴ��ļ�
    //��ǰ�������������װ��FileItem������Ҫ��ServletFileUpload�����л�ȡ
    public static String uploadParseRequest(ServletFileUpload upload, HttpServletRequest request, String uploadPath)
            throws FileUploadException, IOException {

        String msg = "";

        // ��ǰ�������������װ��FileItem����
        List<FileItem> fileItems = upload.parseRequest(request);
        for (FileItem fileItem : fileItems) {
            //fileItemÿһ��������
            if (fileItem.isFormField()) {// �ж��ϴ����ļ�����ͨ�ı����Ǵ��ļ��ı�
                // getFieldNameָ����ǰ�˱��ؼ���name;
                String name = fileItem.getFieldName();
                String value = fileItem.getString("UTF-8"); // ��������
                System.out.println(name + ": " + value);
            } else {// �ж������ϴ����ļ�

                // ============�����ļ�==============

                // �õ��ļ���
                String uploadFileName = fileItem.getName();
                System.out.println("�ϴ����ļ���: " + uploadFileName);
                if (uploadFileName.trim().equals("") || uploadFileName == null) {
                    continue;
                }

                // ����ϴ����ļ���/images/girl/paojie.png
                String fileName = uploadFileName.substring(uploadFileName.lastIndexOf("/") + 1);
                // ����ļ��ĺ�׺��
                String fileExtName = uploadFileName.substring(uploadFileName.lastIndexOf(".") + 1);

                /*
                 * ����ļ���׺��fileExtName������������Ҫ�� ��ֱ��return.������,�����û��ļ����Ͳ��ԡ�
                 */

                System.out.println("�ļ���Ϣ[����: " + fileName + " ---�ļ�����" + fileExtName + "]");
                // ����ʹ��UID��Ψһʶ���ͨ����),��֤�ļ���Ψһ
                // 0UID. randomUUID(),�����һ��Ψһʶ���ͨ����;
                String uuidPath = UUID.randomUUID().toString();

                // ================�����ļ����==============

                // �浽��? uploadPath
                // �ļ���ʵ���ڵ�·��realPath
                String realPath = uploadPath + "/" + uuidPath;
                // ��ÿ���ļ�����һ����Ӧ���ļ���
                File realPathFile = new File(realPath);
                if (!realPathFile.exists()) {
                    realPathFile.mkdir();
                }
                // ==============��ŵ�ַ���==============


                // ����ļ��ϴ�����
                InputStream inputStream = fileItem.getInputStream();
                // ����һ���ļ������
                // realPath =��ʵ���ļ���;
                // ����һ���ļ�;���Ϻ����ļ�������"/"+uuidFileName
                FileOutputStream fos = new FileOutputStream(realPath + "/" + fileName);
                System.out.println("path:"+realPath + "/" + fileName);
                // ����һ��������
                byte[] buffer = new byte[1024 * 1024];
                // �ж��Ƿ��ȡ���
                int len = 0;
                // �������0˵������������;
                while ((len = inputStream.read(buffer)) > 0) {
                    fos.write(buffer, 0, len);
                }
                // �ر���
                fos.close();
                inputStream.close();

                msg = "�ļ��ϴ��ɹ�!";
                fileItem.delete(); // �ϴ��ɹ�,�����ʱ�ļ�
                //=============�ļ��������=============
            }
        }
        return msg;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
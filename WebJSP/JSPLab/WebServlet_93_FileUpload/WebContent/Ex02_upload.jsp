<%@page import="java.util.Enumeration"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page
  import="com.sun.xml.internal.ws.policy.jaxws.DefaultPolicyResolver"%>
<%@page import="com.oreilly.servlet.multipart.FileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%
  String uploadPath = application.getRealPath("upload");
  // System.out.println(uploadPath);

  // cos.jar가 제공하는 MultipartRequest 객체 사용

  // 업로드 파일에 대한 기본 정보 세팅
  int size = 1024 * 1024 * 10; // 10MB
  String name = "";
  String title = "";
  String filename1 = "";
  String filename2 = "";
  String oriFilename1 = "";
  String oriFilename2 = "";

  MultipartRequest multi = new MultipartRequest(
      request, // 기존에 있는 request 객체의 주소값
      uploadPath, // 실제 저장 경로 
      size, // 최대 파일 사이즈
      "UTF-8", // 인코딩
      new DefaultFileRenamePolicy()); // 파일명 중복 >> 새로운 파일명 ex) a.jpg >> a_1.jpg
  // 여기까지 하면 upload 폴더에 파일이 저장
  // 자료실
  // DB insert 실제 원하는 작업
  // 작성자, 제목, 내용, 조회수, [파일명], 추가적으로 파일 사이즈
  
  name = multi.getParameter("name");
  title = multi.getParameter("title");
  String hid = multi.getParameter("hid");
  Enumeration<String> filenames = multi.getFileNames();
  // input name="filename1" >> filename1
      
  //while (filenames.hasMoreElements()) {
  //  System.out.println(filenames.nextElement());
  //}
  String file2 = (String) filenames.nextElement();
  filename2 = multi.getFilesystemName(file2);
  oriFilename2 = multi.getOriginalFileName(file2);
  // out.print("file2: " + file2);
  // out.print("filename2: " + filename2);
  // out.print("oriFilename2: " + oriFilename2);
  
  String file1 = (String) filenames.nextElement();
  filename1 = multi.getFilesystemName(file1);
  oriFilename1 = multi.getOriginalFileName(file1);
  
  out.print("name: " + name);
  out.print("<br>title: " + title);
  out.print("<br>hid: " + hid);
  out.print("<br>file2: " + file2);
  out.print("<br>filename2: " + filename2);
  out.print("<br>oriFilename2: " + oriFilename2);
  out.print("<br>file1: " + file1);
  out.print("<br>filename1: " + filename1);
  out.print("<br>orifilename1: " + oriFilename1);
  
  // DB에 저장했다고 가정하고
  // DB 연결
  // insert ... values(?,?,?,?,?,?)
  // 목록 보기
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  <form action="Ex03_upload_detail.jsp" method="get" name="filelist">
    <input type="hidden" name="name" value="<%=name%>">
    <input type="hidden" name="title" value="<%=title%>">
    <input type="hidden" name="filename1" value="<%=filename1%>">
    <input type="hidden" name="oriFilename1" value="<%=oriFilename1%>">
    <input type="hidden" name="filename2" value="<%=filename2%>">
    <input type="hidden" name="oriFilename2" value="<%=oriFilename2%>">
    <a href="#" onclick="javascript:filelist.submit()">상세 보기</a>
  </form>
</body>
</html>
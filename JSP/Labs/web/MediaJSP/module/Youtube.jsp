<%@ page contentType="text/html;charset=UTF-8" language="java"  pageEncoding="UTF-8" %>
<div class = "header col-12" >
<h1>HTML &nbsp; <img src="module/images/youtube.png" style="width:50px; height:50px; margin-bottom:10px;" ></img>&nbsp;<b>YouTube</b></h1>
<hr>
</div>

<div class = "article-a">
<p>iFrame 재생</p>
<iframe width="440" height="245" src="https://www.youtube.com/embed/9sFUryyoJCw">
</iframe>
<br>
<br>
<br>


<p>Auto play 재생(<span style="color:red">현재 Chrome에서 막아놓음</span>)</p>
<iframe width="440" height="245" src="https://www.youtube.com/embed/9sFUryyoJCw?autoplay=1" allow="autoplay; encrypted-media";">
</iframe> 
<br>
<br>
<br>
<p>Object 재생</p>
<object width="440" height="245"
data="https://www.youtube.com/embed/9sFUryyoJCw">
</object>
</div>


<div class = "article-b">
<p>Loop</p>
<iframe width="440" height="245" src="https://www.youtube.com/embed/9sFUryyoJCw?playlist=9sFUryyoJCw&loop=1">
</iframe>
<br>
<br>
<br>


<p>Control bar 제거</p>
<iframe width="440" height="245" src="https://www.youtube.com/embed/9sFUryyoJCw?controls=0">
</iframe>
<br>
<br>
<br>
<p>Embed 재생</p>
<embed width="440" height="245"
src="https://www.youtube.com/embed/9sFUryyoJCw">
</div>
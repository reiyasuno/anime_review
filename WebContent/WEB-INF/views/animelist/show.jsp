<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:import url="/WEB-INF/views/layout/app.jsp">
    <c:param name="content">

            <c:if test="${animelist != null}">
                <h2>アニメ　詳細ページ</h2>

                <table>
                    <tbody>
                        <tr>
                            <th>タイトル</th>
                            <td><c:out value="${animelist.title}" /></td>
                        </tr>
                         <tr>
                            <th>ジャンル</th>
                            <td><c:out value="${animelist.genre.name}" /></td>
                        </tr>
                        <tr>
                            <th>カテゴリー</th>
                            <td><c:out value="${animelist.category.name}" /></td>
                        </tr>
                        <tr>
                            <th>あらすじ</th>
                            <td><c:out value="${animelist.summary}" /></td>
                        </tr>
                        <tr>
                        <tr>
                            <th>出演者</th>
                            <td><c:out value="${animelist.cast}" /></td>
                        </tr>
                        <tr>
                            <th>制作会社</th>
                            <td><c:out value="${animelist.company}" /></td>
                        </tr>
                        <tr>
                            <th>スタッフ</th>
                            <td><c:out value="${animelist.staff}" /></td>
                        </tr>
                        <tr>
                            <th>音楽</th>
                            <td><c:out value="${animelist.music}" /></td>
                        </tr>

                    </tbody>
                </table>
            </c:if>


        <p><a href="<c:url value='/animelist/edit?id=${animelist.id}' />">このアニメを編集する</a></p>
        <p><a href="<c:url value='/animelist/index' />">一覧に戻る</a></p>


        <c:choose>
        <c:when test="${errors !=null}">
            <div id="flush_error">
                入力内容にエラーがあります。<br />
                <c:forEach var="error" items="${errors }">
                .<c:out value="${error }" /><br />
                </c:forEach>
            </div>
        </c:when>
        <c:otherwise>
        <hr>
        <div>
            <h3 class="comments">コメント欄</h3>
        </div>
        <hr>
    <c:forEach var="comment" items="${commentlist}" varStatus="status">
        <table id="comment_list" class="comment_cell">
            <tbody>
                <tr>
                 <td>
                        <small><fmt:formatDate value='${comment.comment_date }' pattern='yyyy-MM-dd'/></small>
                </td>
                    <td><c:out value="${comment.name}" /></td>
                </tr>
                <tr>
                    <td colspan="2">
                    <pre> <c:out value="${comment.content}" /></pre>
                    </td>
                <tr>
                    <th>登録日時</th>
                    <td>
                        <fmt:formatDate value="${comment.created_at }" pattern="yyy-MM-dd HH:mm:ss"/>
                    </td>
                </tr>
                <tr>
                    <th>更新日時</th>
                    <td>
                        <fmt:formatDate value="${comment.updated_at }" pattern="yyyy-MM-dd HH:mm:ss"/>
                    </td>
                </tr>
            </tbody>
        </table>
    </c:forEach>

        <div id="pagination">
            （全 ${comment_count} 件）<br />
            <c:forEach var="i" begin="1" end="${((comment_count - 1) / 15) + 1}" step="1">
                <c:choose>
                    <c:when test="${i == page}">
                        <c:out value="${i}" />&nbsp;
                    </c:when>
                    <c:otherwise>
                        <a href="<c:url value='/animelist/show?id=${animelist.id}' />"><c:out value="${i}" /></a>&nbsp;
                    </c:otherwise>
                </c:choose>
            </c:forEach>
        </div>

        <form method="POST" action="<c:url value='/comment/create' />" name="comment_form" onsubmit="return validateFormData()">
            <label for="name">ニックネーム</label><br>
            <input type="text" name="name" value="${comment.name}" />
            <br /><br />

            <label for="content">コメント</label><br>
            <textarea id="text" name="content" cols="45" rows="8"></textarea>

            <input type="hidden" name="_token" value="${_token}" />
            <input type="hidden" name="id" value="${animelist.id}" />
            <br /><br />
            <button type="submit">投稿</button>
        </form>
        <script>
            function validateFormData(){
            	var txtNickName = document.comment_form.name.value;
            	var txtComment = document.comment_form.content.value;

            	if(txtNickName.length === 0 || txtComment.length === 0){
            		alert('ニックネームまたはコメントが入力されていません！');
            		return false;
            	}
            }
        </script>
        </c:otherwise>
    </c:choose>
    </c:param>
</c:import>
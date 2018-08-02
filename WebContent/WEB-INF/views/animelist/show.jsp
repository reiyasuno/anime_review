<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:import url="/WEB-INF/views/layout/app.jsp">
    <c:param name="content">
        <c:choose>
            <c:when test="${animelist != null}">
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


            </c:when>
            <c:otherwise>
                <h2>お探しのデータは見つかりませんでした。</h2>
            </c:otherwise>
        </c:choose>

        <p><a href="<c:url value='/animelist/edit?id=${animelist.id}' />">このアニメを編集する</a></p>
        <p><a href="<c:url value='/animelist/index' />">一覧に戻る</a></p>

    </c:param>
</c:import>
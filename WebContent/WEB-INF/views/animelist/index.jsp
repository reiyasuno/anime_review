<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:import url="/WEB-INF/views/layout/app.jsp">
    <c:param name="content">
        <c:if test="${flush != null}">
            <div id="flush_success">
                <c:out value="${flush}"></c:out>
            </div>
        </c:if>
        <h2>アニメ　一覧</h2>

        <br>
        <c:forEach var="anime" items="${animelist}" varStatus="status">
        <table id="anime_list">
                <tr class="row${status.count % 2 }">
            <tbody>
                <tr>
                    <td colspan="2" class="anime_title link_cell"><a class="title_link" href="<c:url value='/animelist/show?id=${anime.id}' />">${anime.title}</a></td>
                    <th class="genre_name">ジャンル</th>
                    <td class="genre_id">${anime.genre.name}</td>
                    <th class="category_name">カテゴリ</th>
                    <td class="category_id">${anime.category.name}</td>
                </tr>
                <tr>
                    <th colspan="1" rowspan="4" class="anime_summary">あらすじ</th>
                    <td colspan="2" rowspan="4" valign="top" class="anime_summary">${anime.summary}</td>
                    <th class="anime_cast">出演者</th>
                    <td colspan="2" class="anime_cast">${anime.cast}</td>
                </tr>
                <tr>
                    <th class="anime_company">制作会社</th>
                    <td colspan="2" class="anime_company">${anime.company}</td>
                </tr>
                    <tr>
                    <th class="anime_staff">スタッフ</th>
                    <td colspan="2" class="anime_staff">${anime.staff}</td>
                </tr>
                <tr>
                    <th class="anime_music">音楽</th>
                    <td colspan="2" class="anime_music">${anime.music}</td>
                </tr>
            </tbody>
        </table>
        <br>
        </c:forEach>



<div id="pagination">
            （全 ${anime_count} 件）<br />
            <c:forEach var="i" begin="1" end="${((anime_count - 1) / 15) + 1}" step="1">
                <c:choose>
                    <c:when test="${i == page}">
                        <c:out value="${i}" />&nbsp;
                    </c:when>
                    <c:otherwise>
                        <a href="<c:url value='/animelist/index?page=${i}' />"><c:out value="${i}" /></a>&nbsp;
                    </c:otherwise>
                </c:choose>
            </c:forEach>
        </div>
        <p><a href="<c:url value='/animelist/new' />">新規アニメの登録</a></p>

    </c:param>
</c:import>
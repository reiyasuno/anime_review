<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:if test="${errors != null}">
    <div id="flush_error">
        入力内容にエラーがあります。<br />
        <c:forEach var="error" items="${errors}">
            ・<c:out value="${error}" /><br />
        </c:forEach>

    </div>
</c:if>

<label for="title"></label>タイトル<br />
    <textarea name="title">
        <c:out value="${animelist.title }"/>
    </textarea>
<br /><br />

<label for="genre"></label>ジャンル<br />
    <input type="radio" name="genreid" value="1" />SF/ファンタジー
    <input type="radio" name="genreid" value="2" />ロボット/メカ
    <input type="radio" name="genreid" value="3" />アクション/バトル
    <input type="radio" name="genreid" value="4" />コメディ/ギャグ
    <input type="radio" name="genreid" value="5" />恋愛/ラブコメ
    <input type="radio" name="genreid" value="6" />日常/ほのぼの
    <input type="radio" name="genreid" value="7" />スポーツ/競技
    <input type="radio" name="genreid" value="8" />ホラー/サスペンス/推理
    <input type="radio" name="genreid" value="9" />歴史/戦記
    <input type="radio" name="genreid" value="10" />戦争/ミリタリー
    <input type="radio" name="genreid" value="11" />ドラマ/青春
    <input type="radio" name="genreid" value="12" />ショート
    <input type="radio" name="genreid" value="13" />2.5次元舞台
    <input type="radio" name="genreid" value="14" />ライブ/ラジオ/etc
<br /><br />

<label for="category"></label>カテゴリー<br />
    <input type="radio" name="categoryid" value="1" />笑いたいとき
    <input type="radio" name="categoryid" value="2" />泣きたいとき
    <input type="radio" name="categoryid" value="3" />感動したいとき
    <input type="radio" name="categoryid" value="4" />癒されたいとき
    <input type="radio" name="categoryid" value="5" />元気になりたいとき
    <input type="radio" name="categoryid" value="6" />熱くなりたいとき
    <input type="radio" name="categoryid" value="7" />ハラハラしたいとき
    <input type="radio" name="categoryid" value="8" />可愛いキャラを見たいとき
    <input type="radio" name="categoryid" value="9" />イケメンキャラを見たいとき
    <input type="radio" name="categoryid" value="10" />何も考えず観たいとき
<br /><br />

<label for="summary"></label>あらすじ<br />
    <textarea name="summary">
        <c:out value="${animelist.summary }"/>
    </textarea>
<br /><br />

<label for="cast"></label>出演者<br />
    <textarea name="cast">
        <c:out value="${animelist.cast }"/>
    </textarea>
<br /><br />

<label for="company"></label>制作会社<br />
    <textarea name="company">
        <c:out value="${animelist.company }"/>
    </textarea>
<br /><br />

<label for="staff"></label>スタッフ<br />
    <textarea name="staff">
        <c:out value="${animelist.staff }"/>
    </textarea>
<br /><br />

<label for="music"></label>音楽<br />
    <textarea name="music">
        <c:out value="${animelist.music }" />
    </textarea>
<br /><br />

<input type="hidden" name="_token" value="${_token}" />
<button type="submit">登録</button>
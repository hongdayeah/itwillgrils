<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="../header.jsp" %>


    <!-- 본문 시작 performanceList.jsp -->
    <h3>*공연폼*</h3>


	<input type="button" value="공연등록" onclick="location.href='create.do'">

	
	<table>
		<thead>
			<tr>
				<th>이미지</th>
				<th>공연제목</th>
				<th>공연설명</th>
				<th>날짜</th>
				<th>시간</th>
				<th>장소</th>
				<th>공연료</th>
			</tr>
		</thead>				
	
	
	<c:forEach var="dto" items="${list}">
		<tr>
			<td>${dto.per_img}</td>
			<td><a href="#">${dto.per_name}</a></td>
			<td>${dto.per_exp}</td>
			<td>${dto.per_date}</td>
			<td>${dto.per_time}</td>
			<td>${dto.class_code}</td>
			<td>${dto.per_fee}</td>
			
			<td>
                <input type="button" value="수정" onclick="#">
                <input type="button" value="삭제" onclick="#">
            </td>
	
		</tr>
	
	</c:forEach>

	</table>
    <!-- 본문 끝 -->
        
<%@ include file="../footer.jsp" %>



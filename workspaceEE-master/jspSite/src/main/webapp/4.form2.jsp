<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>회원 가입</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
	<h3 align="center">◆◆◆ 회원가입 ◆◆◆</h3>
	<form name="join" method="POST" action="4.join2.jsp">
		<table bgcolor="black" cellspacing="1" cellpadding="5" align="center">
			<tr id="first-tr">
				<th bgcolor="44ff44"><font size="2">아이디</font></th>
				<td bgcolor="white" width="300"><input type="text" size="10"
					name="id" class="TXTFLD"></td>
			</tr>
			<tr>
				<th bgcolor="44ff44"><font size="2">비밀번호</font></th>
				<td bgcolor="white" width="300"><input type="password"
					size="10" name="pass" class="TXTFLD1"></td>
			</tr>
			<tr>
				<th bgcolor="44ff44"><font size="2">비밀번호확인</font></th>
				<td bgcolor="white" width="300"><input type="password"
					size="10" name="repass" class="TXTFLD"></td>
			</tr>
			<tr>
				<th bgcolor="44ff44"><font size="2">이름</font></th>
				<td bgcolor="white" width="300"><input type="text" size="10"
					name="name" class="TXTFLD"></td>
			</tr>
			<tr>
				<th bgcolor="44ff44"><font size="2">주소</font></th>
				<td bgcolor="white" width="300"><input type="text" size="30"
					name="addr" class="TXTFLD"></td>
			</tr>
			<tr>
				<th bgcolor="44ff44"><font size="2">성별</font></th>
				<td bgcolor="white" width="300">
				<input type="radio" name="gender" value="M">
				<font size="2">남자</font> 
				<input type="radio" name="gender" value="F" checked="checked">
				<font size="2">여자</font>
				</td>
			</tr>
			<tr>
				<th bgcolor="44ff44"><font size="2">직업</font></th>
				<td bgcolor="white" width="300">
				<select name="job" size="1">
						<option>학생</option>
						<option value="주부">주부</option>
						<option value="회사원">회사원</option>
						<option value="사장">사장</option>
						<option value="기타">기타</option>
				</select>
				</td>
			</tr>
			<tr>
				<th bgcolor="44ff44"><font size="2">취미</font></th>
				<td bgcolor="white" width="300">
				<input type="checkbox" name="hobby" checked="checked" value="낮잠">낮잠
				<input type="checkbox" name="hobby" value="연애">연애
				<input type="checkbox" name="hobby" value="운동">운동 
				<input type="checkbox" name="hobby" value="사이클">사이클 
				<input type="checkbox" name="hobby" value="기타">기타
				</td>
			</tr>
			<tr>
			<th colspan="2" bgcolor="ff8888">
				<input type="submit" value="가입">
				<input type="reset" value="취소"></th>
			</tr>
		</table>
	</form>
</body>
</html>

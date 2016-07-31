<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script>var ctx = "<%=request.getContextPath()%>"</script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>

<script>
	$(document)
			.ready(
					function() {
						$("#getButton")
								.click(
										function() {

											var myVal = $("#protection_get_id")
													.val();
											var urlToCall = ctx+"/api/words/"
													+ myVal + "/protection";
											//$("#getMessage").text("Protection applied please get file from this link");

											$.get(urlToCall, function(data,
													status) {
												window.open(
														ctx+"/api/getfile/"
																+ data,
														'_blank');
											});

										});
						// *****************************************************************						

						$("#postButton")
								.click(
										function() {

											var postProtectionType = $(
													"#protection_post_id")
													.val();
											var urlToCall = ctx+"/api/words/"
													+ postProtectionType
													+ "/protection";
											$.post(urlToCall, function(data,
													status) {
												window.open(
														ctx+"/api/getfile/"
																+ data,
														'_blank');
											});

										});

						// *****************************************************************						
					});
</script>


</head>
<body>
	<h2>Aspose web Services</h2>
	<h4>File Conversion</h4>
	<form action="<%=request.getContextPath()%>/api/words/convert" method="post"
		enctype="multipart/form-data">
		<p>
			Select any text file: <input type="file" name="file" size="45" /> <input
				type="submit" value="Convert" />
		</p>
	</form>

	<br>
	<hr>

	<h3>Aspose document protection</h3>
	<h4>Add Protection</h4>
	<p>Please choose conversion type from list below to get the
		document with protection. Protection will be added on previously
		converted document</p>
	<select id="protection_get_id">
		<option value="0">Allow Only Revisions</option>
		<option value="1">Allow Only Comments</option>
		<option value="2">Allow Only Form Fields</option>
	</select>
	<input type="button" id="getButton" value="submit" />
	<span id="getMessage"></span>
	<br>
	<hr>

	<h4>Add/Change Protection</h4>
	<p>Please choose conversion type from list below to add protection
		on document along with previously added protections</p>
	<select id="protection_post_id">
		<option value="0">Allow Only Revisions</option>
		<option value="1">Allow Only Comments</option>
		<option value="2">Allow Only Form Fields</option>
	</select>
	<input type="button" id="postButton" name="myButton" value="submit" />
	<br>

</body>
</html>

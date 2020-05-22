	axios的默认 content-type是 application/json,对应java后端的是 @RequestBody 测试不行啊
	
	发送get请求时一般普通就可以
	
	
	发送post请求时
		@RequestParam() --> postman中Params中设置参数即可 application/x-www-form-urlencoded ，不需在body中设置 --> 这种直接在axios中post的url中拼接即可
																												 在axios要使用js中formdata对象作为参数也可
		 
		@RequestBody() --> postman中body设置参数（raw & json & Content-Type:application/json）--> 这种直接在axios中post的url中拼接即可
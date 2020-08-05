### 1 Promise


#### 1.1 是什么
	
	Promise是异步编程的一种解决方案，有3种状态：pending(等状态),fulfiled(成功态),rejected(失败态)；
状态一旦改变，就不会再变。创造promise实例后，他会立即执行。


#### 1.2 用法
	Promise是一个构造对象，自己身上有all、reject(失败)、resolve(成功)等方法，原型上有then、catch等方法
	```
	let p = new Promise((resolve, reject) => {
    //做一些异步操作
    setTimeout(() => {
        console.log('执行完成');
        resolve('我是成功！！');
		}, 2000);
	});
	```
	
	then()
	catch() 保证在resolve的回调总出现异常后不会卡死
	

###   location.reload()
	刷新页面
			
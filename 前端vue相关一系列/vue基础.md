## vue基础

### 我的积累
	#####  .sync修饰符的使用
			https://blog.csdn.net/liushijun_/article/details/92426854
			
### vueX介绍
	
	Vuex是一个专为Vue.js应用程序开发的状态管理模式。
	
	主要包涵4个对象
	
### 路由的介绍(Router)

#### vue文件中的操作（主要为登录等的使用）
	this.$router.push()
		跳转到不同的url，但这个方法会向history栈添加一个记录，点击后退会返回到上一个页面
	
	this.$router.replace()
		同样是跳转到指定的url，但是这个方法不会向history里面添加新的记录，点击返回，会跳
	转到上上一个页面。上一个记录是不存在的。
	
	this.$router.go(n)
		相对于当前页面向前或向后跳转多少个页面,类似 window.history.go(n)。n可为正数可为负
	数。正数返回上一个页面

### 简单介绍
	1 声明式渲染 ---> 一个允许采用简洁的模板语法来声明式地将数据渲染进 DOM 的系统
		使数据和dom建立关联，所有的东西都是响应式的
		{{}}
	
	2 条件与循环 (2个指令)
		v-if
		v-for
		
	3 输入相关
		3.1 this.message.split('').reverse().join('')
		             分成数组  反转数组  将数组组成一个串
		
		3.2 v-model
	
	4 组件化应用构建
		4.1 把一个前端系统比作一个后端系统（勿喷别说没有多线程之类的），组件化就是我们首先将后台系统分成3个模块：
		controller,service及dao（数组库访问），当然这3个模块之间还可以调用更小的模块，来构成一个整体的看着漂
		亮的前端系统
		
		4.2 组件化需要我们熟练一些vue语法
			    主要为 component的使用
				
### 一、vue实例
	
	#### 数据与方法介绍
		1 当一个 Vue 实例被创建时，它将 data 对象中的所有的属性加入到 Vue 的响应式系统中。当这些属性的值发生改变时，视图将会产生“响应”，即匹配更新为新的值。
		注意：只有当实例被创建时就已经存在于data中的属性才是响应式的。
		
		2 Object.freeze() 
		注意这个方法，这个在vue实例变量声明后再使用这个方法“冻”一下，那这个变量就不是可响应的了
		
		3 vue实例暴露的一些vue实例属性（见到哪个我都写上了）
		  vm.$data
		  vm.$el
		  vm.#watch
		  
	#### 生命周期钩子
		new Vue() 新建vue实例 
		
		初始化：包括初始化事件和初始化生命周期
		
		beforeCreate()
		
		初始化：包括数据注入dom和数据校验
		
		created() 一般情况下都在这个方法下添加组件创建之后的动作等
		
		... 略去不懂的，以后补上
		
		beforeMount()
		
		创建vm.$el 并用其替换 "el"
		
		mounted()
		
		到这里挂载完毕（这里有一个循环）
			updated()
			
			虚拟dom重新渲染并应用更新
			
			beforeUpdate()
			
			data被修改
		
		当调用 vm.$destory()
		
		beforeDestory()
		
		解除绑定销毁子组件以及事件监听器
		
		destoryed
		
		销毁完毕
		
### 二、模板语法	
	
	允许开发者声明式地将DOM绑定至底层Vue实例的数据。所有Vue.js 的模板都是合法的 HTML，所以能
被遵循规范的浏览器和 HTML 解析器解析。
	在底层的实现上，Vue 将模板编译成虚拟 DOM 渲染函数。结合响应系统，Vue 能够智能地计算出最少
需要重新渲染多少组件，并把 DOM 操作次数减到最少。
	如果你熟悉虚拟 DOM 并且偏爱 JavaScript 的原始力量，你也可以不用模板，直接写渲染 (render) 
函数，使用可选的 JSX 语法。
	
	#### 1 插值
	1.1 普通文本
		{{}}
		
	1.2 原始html
	
		v-html,只对信任的东西用这个指令，对于需要用户输入的内容决不能使用这个
		
	1.3 Attribute
	
		要使属性作用在html上应使用一些指令
		
		v-bind --> 这个指令会尽量减少不必用的性能浪费
		
		

		
		
	
		
		
{"result":{"Result":"[
			{\"roleId\":\"1\",
			 \"icon\":\"http://p.qpic.cn/pic_wework/1618575548/aaac68b9a6dfb6454de6afe174f674588c42cac8e690620f/0\",
			 \"description\":\"用户信息维护测试1\",
			 \"telephone\":\"18711661231\",
			 \"userName\":\"zhangsan\",
			 \"type\":\"2\",
			 \"userId\":\"0001\",
			 \"password\":\"123456789\",
			 \"createTime\":\"202003090803\",
			 \"nickname\":\"zhangsan1\",
			 \"email\":\"1234567890@qq.com\",
			 \"status\":\"1\"},
			 {\"roleId\":\"1\",
			 \"telephone\":\"17866341233\",
			 \"userName\":\"lisi\",
			 \"type\":\"2\",
			 \"userId\":\"0002\",
			 \"password\":\"222222\",
			 \"createTime\":\"202003090804\",\"nickname\":\"李四\",\"email\":\"1285742633@qq.com\",\"status\":\"1\"},{\"roleId\":\"1\",\"telephone\":\"17866341232\",\"userName\":\"zhangsan2\",\"type\":\"2\",\"userId\":\"0003\",\"password\":\"111111\",\"createTime\":\"202003090805\",\"nickname\":\"张三2\",\"email\":\"1285742634@qq.com\",\"status\":\"1\"},{\"roleId\":\"1\",\"telephone\":\"17866341231\",\"userName\":\"lisi2\",\"type\":\"2\",\"userId\":\"0004\",\"password\":\"111111\",\"createTime\":\"202003090806\",\"nickname\":\"李四2\",\"email\":\"1285742635@qq.com\",\"status\":\"1\"},{\"roleId\":\"1\",\"telephone\":\"17866341230\",\"userName\":\"zhangsan3\",\"type\":\"2\",\"userId\":\"0005\",\"password\":\"111111\",\"createTime\":\"202003090807\",\"nickname\":\"张三3\",\"email\":\"1285742636@qq.com\",\"status\":\"1\"},{\"roleId\":\"1\",\"icon\":\"http://p.qpic.cn/pic_wework/1618575548/aaac68b9a6dfb6454de6afe174f674588c42cac8e690620f/0\",\"description\":\"这是一个测试用户\",\"telephone\":\"18888888888\",\"userName\":\"yuan\",\"type\":\"2\",\"userId\":\"0006\",\"password\":\"123456789\",\"createTime\":\"202003110951\",\"nickname\":\"yuan\",\"email\":\"778899159@163.com\",\"status\":\"1\"},{\"roleId\":\"2\",\"icon\":\"ss\",\"description\":\"ss\",\"telephone\":\"ss\",\"userName\":\"ss\",\"type\":\"2\",\"userId\":\"0007\",\"userToken\":\"\",\"password\":\"ssss\",\"createTime\":\"20200326\",\"nickname\":\"ss\",\"email\":\"ss\",\"status\":\"1\"},{\"roleId\":\"1\",\"icon\":\"435\",\"description\":\"435\",\"telephone\":\"4353\",\"userName\":\"4543\",\"type\":\"1\",\"userId\":\"0009\",\"userToken\":\"\",\"password\":\"4354\",\"createTime\":\"20200326\",\"nickname\":\"453\",\"email\":\"43\",\"status\":\"-1\"},{\"roleId\":\"1\",\"icon\":\"http://djfls.dfd\",\"description\":\"fsfadf\",\"telephone\":\"18231664995\",\"userName\":\"insert1\",\"type\":\"1\",\"userId\":\"0010\",\"userToken\":\"userToken\",\"password\":\"123456\",\"createTime\":\"20200302\",\"nickname\":\"insert1\",\"email\":\"152833@qq.com\",\"status\":\"1\"},{\"roleId\":\"1\",\"icon\":\"http://djfls.dfd\",\"description\":\"fsfadf\",\"telephone\":\"18231664995\",\"userName\":\"insert2\",\"type\":\"1\",\"userId\":\"0011\",\"userToken\":\"userToken\",\"password\":\"123456\",\"createTime\":\"20200302\",\"nickname\":\"insert1\",\"email\":\"152833@qq.com\",\"status\":\"1\"},{\"roleId\":\"\",\"icon\":\"\",\"description\":\"\",\"telephone\":\"\",\"userName\":\"\",\"type\":\"\",\"userId\":\"0012\",\"userToken\":\"\",\"password\":\"\",\"createTime\":\"\",\"nickname\":\"\",\"email\":\"\",\"status\":\"\"},{\"roleId\":\"1\",\"icon\":\"23423\",\"description\":\"2343243\",\"telephone\":\"456465\",\"userName\":\"pageTest\",\"type\":\"1\",\"userId\":\"0013\",\"userToken\":\"\",\"password\":\"111111\",\"createTime\":\"20200327\",\"nickname\":\"pageTest\",\"email\":\"234324\",\"status\":\"1\"},{\"roleId\":\"1\",\"icon\":\"https://ss0.bdstatic.com/94oJfD_bAAcT8t7mm9GUKT-xh_/timg?image&quality=100&size=b4000_4000&sec=1585289334&di=52f854bbe2a5747927de469d87284cf2&src=http://a3.att.hudong.com/68/61/300000839764127060614318218_950.jpg\",\"description\":\"fasfdks\",\"telephone\":\"16587452314\",\"userName\":\"hhhl\",\"type\":\"1\",\"userId\":\"0014\",\"userToken\":\"\",\"password\":\"33333333333\",\"createTime\":\"20200327\",\"nickname\":\"hhhl\",\"email\":\"546@qq.com\",\"status\":\"1\"}]"},"OutArgs":{"msg":"success","errorcode":"0"}}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	
	
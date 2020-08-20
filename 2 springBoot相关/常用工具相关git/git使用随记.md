
## Git提交代码的流程——新手适用
	pull：是下拉代码，相等于将远程的代码下载到你本地，与你本地的代码合并
	push：是推代码，将你的代码上传到远程的动作
	完整的流程是：

### 第一种方法：（简单易懂）

	1、git add .（后面有一个点，意思是将你本地所有修改了的文件添加到暂存区）
	2、git commit -m""(引号里面是你的介绍，就是你的这次的提交是什么内容，便于你以后查看，这个是将索引的当前内容与描述更改的用户和日志消息一起存储在新的提交中)
	3、git pull origin master 这是下拉代码，将远程最新的代码先跟你本地的代码合并一下，如果确定远程没有更新，可以不用这个，最好是每次都执行以下，完成之后打开代码查看有没有冲突，并解决，如果有冲突解决完成以后再次执行1跟2的操作
	4、git push origin master 将代码推至远程就可以了

 

### 第二种方法：

	1、git stash （这是将本地代码回滚值至上一次提交的时候，就是没有你新改的代码）
	2、git pull origin master（将远程的拉下来）
	3、git stash pop（将第一步回滚的代码释放出来，相等于将你修改的代码与下拉的代码合并）
	然后解决冲突，你本地的代码将会是最新的代码
	4、git add .
	5、git commit -m""
	6、git push origin master
	这几步将代码推至了远程
	最后再git pull origin master 一下，确保远程的全部拉下来，有的你刚提交完有人又提交了，你再拉一下会避免比的不是最新的


原因
两人同时fetch了一个分支。 第一个人修改后提交，第二个人提交就失败。

解决方法
1.强制推送
$ git push -f
可以提交，会将remote上第一个人的改动冲掉，比较暴力，不太好。

2.正常解决
先 git fetch origin 然后git merge origin/master, 和本地分支合并, 之后再push。



## 下面记录一下我在开发中遇到的问题

	1 Pull is not possible because you have unmerged files
	https://blog.csdn.net/zxsted/article/details/17022665
	
	
	cn.com.agree.ab.a4.client.ads.update.prt.oki_4.0.0.qualifier [33]
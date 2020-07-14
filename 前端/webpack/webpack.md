### 是什么

	打包工具
	
### webpack的用法
	
	webpack4.x中的新命令
	npx D:\developer\node\node_global\webpack.cmd main.js -o bundle.js --mode development  

### webpack-dev-server

	自动打包更新浏览器,热加载。
	
#### webpack.config.js

```
var htmlwp=require('html-webpack-plugin') // 引用html-webpack-plugin，根据html模板再内存生成html文件

module.exports={
    entry: './src/main.js',
    output: {
        path: __dirname + '/dist',
        filename: 'build.js'
    },
    plugins: [
        new htmlwp({
            title: '首页',
            filename: 'index.html', // 
            template: 'vue_02.html' // 根据 模板的模板路径
        })
    ]
}
```
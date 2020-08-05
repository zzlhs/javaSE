## html 基础标签

### 1 <img/>
	img标签在vue中的使用
	<img v-if="formData.icon" :src="formData.icon" class="avatar" />
	
## element标签

### 1 <el-dialog />
	```
	<el-dialog
                title="权限配置"
                :visible.sync="JurisdictionOffs"  <!-- 是否显示对话框 -->
                width="70%">
                <Jurisdiction />
            </el-dialog>
	```
	
 [{
	"id":1,
	"path":"",
	"label":"首页",
	"redirect":"/index",
	"meta":{
		"title":"首页",
		"table":true,
		"display":false,
		"icon":"el-icon-s-home"
	}
  },{
	"id":2,
	"path":"/index",
	"name":"index",
	"label":"首页",
	"meta":{"title":"首页","table":true,"display":true,"icon":"el-icon-s-home"}},{"id":3,"path":"/shop","name":"shop","label":"商品列表","meta":{"title":"商品列表","table":true,"display":true,"icon":"el-icon-s-operation"}},{"id":20,"path":"/admin","label":"管理员列表","meta":{"title":"管理员列表","table":true,"display":true,"icon":"el-icon-s-custom"},"children":[{"id":21,"path":"/admin/index","label":"管理员列表","meta":{"title":"管理员列表","table":true,"display":true,"icon":"el-icon-tickets"}},{"id":22,"path":"/admin/adminlist","label":"添加管理员","meta":{"title":"添加管理员","table":true,"display":true,"icon":"el-icon-document-remove"}}]},{"id":4,"path":"/about","name":"about","label":"关于","meta":{"title":"关于","table":true,"display":true,"icon":"el-icon-s-operation"}}]
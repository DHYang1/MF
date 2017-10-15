<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
		<table>
			<thead>
			<tr>
				<td>接口名称</td>
				<td>访问地址</td>
				<td>参数</td>
				<td>提交方法</td>
				<td>说明</td>
			</tr>
			</thead>
			<tr>
				<td>获取广告</td>
				<td>/ad</td>
				<td>state</td>
				<td>GET</td>
				<td>广告状态（0.未使用1.已启用）</td>
			</tr>
			<tr>
				<td>创建意见反馈</td>
				<td>/feedback</td>
				<td>user_id|title|content|MultipartFile[] uploadFile</td>
				<td>POST</td>
				<td></td>
			</tr>
			<tr>
				<td>获取店铺详情</td>
				<td>/shop/select</td>
				<td>shop_id</td>
				<td>GET</td>
				<td>通过店铺ID获取店铺详情</td>
			</tr>
			<tr>
				<td>获取店铺商品分类</td>
				<td>/shop/category</td>
				<td>shop_id</td>
				<td>GET</td>
				<td>通过店铺ID获取店铺商品分类</td>
			</tr>
			<tr>
				<td>获取店铺商品</td>
				<td>/shop/commodity</td>
				<td>category_id</td>
				<td>GET</td>
				<td>通过商品分类ID获取商品</td>
			</tr>
			<tr>
				<td>获取使用说明文档</td>
				<td>/instruction/td>
				<td>state</td>
				<td>GET</td>
				<td>根据状态查询使用说明(0.未使用1.已使用)</td>
			</tr>
			<tr>
				<td>获取钱包说明文档</td>
				<td>/walletInstruction</td>
				<td>state</td>
				<td>GET</td>
				<td>根据状态查询钱包说明(0.未使用1.已使用)</td>
			</tr>
			<tr>
				<td>获取用户须知文档</td>
				<td>/userknow</td>
				<td>state</td>
				<td>GET</td>
				<td>根据状态查询用户须知(0.未使用1.已使用)</td>
			</tr>
			<tr>
				<td>获取注册协议文档</td>
				<td>/registration</td>
				<td>state</td>
				<td>GET</td>
				<td>根据状态查询注册协议(0.未使用1.已使用)</td>
			</tr>
			
	
			
			<tr>
				<td>登录接口</td>
				<td>/login</td>
				<td>phoneNum|Icode</td>
				<td>POST</td>
				<td>Icode为验证码，返回值为  1普通用户   2设计师 3注册页面  4验证码错误 5手机号不能为空</td>
			</tr>
			
			<tr>
				<td>验证码</td>
				<td>/getIcode</td>
				<td>phoneNum</td>
				<td>POST</td>
				<td>返回值 1为成功   2为失败</td></td>
			</tr>
			
			
			<tr>
				<td>注册接口</td>
				<td>/update</td>
				<td>String phoneNum,Integer gender,Integer userAge,Integer face,String email</td>
				<td>POST</td>
				<td>性别,1男，2女,face 1长脸 2圆脸 3方脸 返回值1为成功 2为注册失败</td>
			</tr>
			
			<tr>
				<td>首页查询设计师</td>
				<td>/index/desiger</td>
				<td></td>
				<td>GET</td>
				<td>最多15个</td>
			</tr>
			<tr>
				<td>首页查询设计师作品</td>
				<td>/index/desigerWork</td>
				<td></td>
				<td>GET</td>
				<td> 中间那作品 最多10个</td>
			</tr>
			<tr>
				<td>首页封面推荐作品</td>
				<td>/index/adverWork</td>
				<td>Integer page</td>
				<td>GET</td>
				<td>下面那个作品展示</td>
			</tr>
			
			<tr>
				<td>设计师展示接口1-展示热门设计师</td>
				<td>/getDesigerConditio</td>
				<td>int condition</td>
				<td>GET</td>
				<td>烫染 为1    理发2   美妆3 设计4</td>
			</tr>
			<tr>
				<td>设计师展示接口1-展示设计师列表</td>
				<td>/getDesigerConditioAdd</td>
				<td>Integer page,int condition</td>
				<td>GET</td>
				<td>page页码，默认一页10条数据,烫染 为1    理发2   美妆3 设计4</td>
			</tr>
			<tr>
				<td>搜索接口</td>
				<td>/search</td>
				<td>String condition,Integer type</td>
				<td>GET</td>
				<td> 模拟的时候  条件输"设" 1 设计师2 作品3店铺</td>
			</tr>
			<tr>
				<td>搜索接口</td>
				<td>/likeSearch</td>
				<td>String condition,Integer type</td>
				<td>GET</td>
				<td> 模拟的时候  条件输"设" 1 设计师2 作品3店铺</td>
			</tr>
			<tr>
				<td>热门搜索</td>
				<td>hotsearch</td>
				<td>Integer type</td>
				<td>GET</td>
				<td>1 设计师2 作品3店铺</td>
			</tr>
			<tr>
				<td>进入设计师主页</td>
				<td>/goToDesigerWork<td>
				<td>long designerId</td>
				<td>GET</td>
				<td>返回值"myWorkList"为作品集  "workList":为作品</td>
			</tr>
			<tr>
				<td>设计师详情介绍查看接口</td>
				<td>/getIntroduce</td>
				<td>designerId</td>
				<td>GET</td>
				<td></td>
			</tr>
			
	
			<tr>
				<td>查看指定作品集的接口</td>
				<td>/getWorkList</td>
				<td>worksId</td>
				<td>GET</td>
				<td>返回值有数据则成功</td>
			</tr>
		  <tr>
				<td>我的发布</td>
				<td>/goToWork</td>
				<td>long designerId</td>
				<td>get</td>
				<td>name作品集的名字，1为成功，2为失败</td>
			</tr>
	
			<tr>
				<td>我的作品集</td>
				<td>/goToWorkList</td>
				<td>long designerId</td>
				<td>get</td>
				<td>1为成功，2为失败</td>
			</tr>
			<tr>
				<td>创建作品集</td>
				<td>/publishWorkList</td>
				<td>MultipartFile[] uploadFile,long desigerId,String name</td>
				<td>POST</td>
				<td>name作品集的名字，1为成功，2为失败</td>
			</tr>
			<tr>
				<td>删除多个作品集</td>
				<td>/delete/desigerworks</td>
				<td>String workIdlists</td>
				<td>get</td>
				<td>workIdlists为多个作品集ID，作品集ID通过逗号隔开,1为成功，2为失败</td>
			</tr>
			<tr>
				<td>删除多个作品</td>
				<td>/delete/desigerwork</td>
				<td>String workIds</td>
				<td>get</td>
				<td>workIds为多个作品ID，作品集ID通过逗号隔开,1为成功，2为失败</td>
			</tr>
			
			<tr>
				<td>查看指定设计师作品</td>
				<td>/get/desigerwork</td>
				<td>workId</td>
				<td>GET</td>
				<td></td>
			</tr>
			 
			 <tr>
				<td>个人信息的查看</td>
				<td>/getUserInformat</td>
				<td>long userId</td>
				<td>GET</td>
				<td><userId用户的ID/td>
			</tr>
			 
		  <tr>
				<td>个人信息头像修改</td>
				<td>/updateUserTouXiang</td>
				<td>long userId,MultipartFile uploadFile</td>
				<td>GET</td>
				<td>userId用户的ID,uploadFile为头像，返回值成功data 为1，失败data为2</td>
			</tr>
			
			
			 <tr>
				<td>名字的修改</td>
				<td>updateName</td>
				<td>long userId,String userName</td>
				<td>POST</td>
				<td>成功为200</td>
			</tr>
			 
			 <tr>
				<td>设计师认证接口查看</td>
				<td>/getdesigerAuth</td>
				<td></td>
				<td>GET</td>
				<td>返回值   "4": "彩妆" 4为ID</td>
			</tr>
			<tr>
				<td>设计师认证基本信息保存</td>
				<td>/desigerAuth</td>
				<td>long userId,long[] goodIds,MultipartFile[] uploadFile,Integer startworkDate</td>
				<td>POST</td>
				<td>userId用户Id,goodIds为擅长方面ID数组，startworkDate出道时间，uploadFile为文件返回值：1为成功 ，2为失败</td>
			</tr>
			 
			 <tr>
				<td>设计师认证身份证信息保存</td>
				<td>idCardAuth</td>
				<td>MultipartFile uploadFile1,MultipartFile uploadFile2,long userId</td>
				<td>POST</td>
				<td>desigerId设计师ID，uploadFile1为正身份证，2为反</td>
			</tr>
			 
			 <tr>
				<td>点击发布作品返回标签IDS和 名字</td>
				<td>get/publish/workLable</td>
				<td>无参数</td>
				<td>GET</td>
				<td>返回值 成功有值，失败为空</td>
			</tr>
			 <tr>
				<td>点击发布作品</td>
				<td>/publish/desigerwork</td>
				<td>long desigerId,int ageType,String title, String introduction, Integer gender, Integer face,String labelId,
			MultipartFile uploadFile1, MultipartFile uploadFile2</td>
				<td>POST</td>
				<td>ageType 1为青年2中3老     title标题    introduction介绍  gender性别1nan  2    face0圆脸，1方脸，2菱形脸 labelId标签 uploadFile1为coverImg图片
				  uploadFile2为content_picture图片 返回值1为成功 2为失败</td>
			</tr>
			<tr>
			<td>新增作品集的接口</td>
				<td>/publishWorkList</td>
				<td>MultipartFile[] uploadFile|long desigerId|String name</td>
				<td>POST</td>
				<td>name作品集的名字，uploadFile上传的图片 返回值1为成功，2则失败</td>
			</tr>
			
			 <tr>
				<td>设计师服务价格查看</td>
				<td>/serviceprice</td>
				<td>long desigerId</td>
				<td>GET</td>
				<td>desigerId为设计师ID返回值1为剪发，2为烫染，3为美妆</td>
			</tr>
			
			
			<tr>
				<td>设计师服务价格修改</td>
				<td>/updateprice</td>
				<td>long desigerId,int id,double price</td>
				<td>GET</td>
				<td>id为类型的id，price为修改后的价格</td>
			</tr>
			<tr>
				<td>点击设计师 预约页面</td>
				<td>/desiger/cart</td>
				<td>long desigerId</td>
				<td>GET</td>
				<td>dateTime为已经预约时间，返回值123，分别代表三个时间段是否被预约，dateTime格式2017-09-30（预约了第一个时间）多个时间用逗号隔开，返回值  1剪发   2烫染  3美妆，</td>
			</tr>
			 <tr>
				<td>添加设计师到购物车</td>
				<td>//add/cart</td>
				<td>long userId,String dateTime ,Integer num, Integer[] servicesId,long desigerId,</td>
				<td>GET</td>
				<td> 参数  String dateTime 时间段Intger num, 项目 Integer[] servicesId,页面 1为剪发，2为烫染 3为美妆
 设计师long desigerId返回值1为成功，3为购物车以及有设计师，2为添加失败</td>	
			</tr>
		    <tr>
				<td>添加店铺到购物车</td>
				<td>/add/shop/cart</td>
				<td>long userId,long shopId,long[] commodityIds,</td>
				<td>GET</td>
				<td> shopId 为店铺ID，commodityIds为服务的Id,返回值1为成功， 返回3为不能再添加店铺，2为添加失败</td>	
			</tr>
		   <tr>
				<td>查看购物车</td>
				<td>/get/cart</td>
				<td>long userId</td>
				<td>GET</td>
				<td></td>	
			</tr>
			 <tr>
				<td>删除购物车里面的设计师</td>
				<td>/delete/cart/designer</td>
				<td>long userId,long designerId,String dateTime,Integer num,</td>
				<td>GET</td>
				<td>dateTime为预约的当天时间，num为当天的三个时间段 成功返回1，失败返回2</td>	
			</tr>
			<tr>
				<td>删除购物车里面的店铺</td>
				<td>/delete/cart/shop</td>
				<td>long userId,String shopId,</td>
				<td>GET</td>
				<td>1为成功，2为失败</td>	
			</tr>
		   <tr>
				<td>设计师 信息查看</td>
				<td>/getDesigerInfor</td>
				<td>long desigerId</td>
				<td>GET</td>
				<td>有数据成功</td>	
			</tr>
			 <tr>
				<td>设计师 头像修改</td>
				<td>/designer/touxiang</td>
				<td>long designerId,MultipartFile uploadFile</td>
				<td>GET</td>
				<td></td>	
			</tr>
			
			
		 <tr>
				<td>设计师名字修改</td>
				<td>/designer/name</td>
				<td>long designerId,String name</td>
				<td>GET</td>
				<td></td>	
			</tr>
		
		 <tr>
				<td>设计师职称修改</td>
				<td>/designer/position</td>
				<td>long designerId,String position</td>
				<td>GET</td>
				<td></td>	
			</tr>
		
		 <tr>
				<td>设计师公司修改</td>
				<td>/designer/companyName</td>
				<td>long designerId,String companyName</td>
				<td>GET</td>
				<td></td>	
			</tr>
			 <tr>
				<td>设计师自我介绍修改</td>
				<td>/designer/introdu</td>
				<td>long designerId,String introdu</td>
				<td>GET</td>
				<td></td>	
			</tr>
			 <tr>
				<td>设计师个性签名修改</td>
				<td>/designer/autogra</td>
				<td>long designerId,String autogra</td>
				<td>GET</td>
				<td>一样</td>	
			</tr>
			 <tr>
				<td>设计师擅长方面修改</td>
				<td>/designer/specialty</td>
				<td>long designerId,String specialty</td>
				<td>GET</td>
				<td>1成2失败</td>	
			</tr>
			<tr>
				<td>设计师比赛修改</td>
				<td>/designer/match</td>
				<td>long designerId,String match</td>
				<td>GET</td>
				<td>1成功2失败</td>	
			</tr>
			<tr>
				<td>殿堂</td>
				<td>getPalace</td>
				<td>Integer page</td>
				<td>GET</td>
				<td>1为成功 2为失败</td>	
			</tr>
			
			
			<tr>
				<td>名店秀默认展示</td>
				<td>getStarDesigner</td>
				<td></td>
				<td>GET</td>
				<td>有数据成功 </td>	
			</tr>
			 <tr>
				<td>出道时间展示</td>
				<td>getStarDesignerByTime</td>
				<td></td>
				<td>GET</td>
				<td>有数据成功 </td>	
			</tr>
			<tr>
				<td>支付宝支付</td>
				<td>/alipay</td>
				<td>long userId,String out_trade_no</td>
				<td>GET</td>
				<td>out_trade_no订单号 </td>	
			</tr>
			
			
			
		</table>
	</body>
</html>
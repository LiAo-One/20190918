$(function() {
	loadGird();
	//获得传过来的login与在数据库中对应的表单
	//search获得地址中的参数，内容为'?itemId=??'
	var paras = location.search;
	//match是字符串中符合的字段一个一个取出来，result中的值为['login=xx','table=admin']
	var result = paras.match(/[^\?&]*=[^&]*/g);
	//让paras变成没有内容的json对象
	paras = {};
	for (i in result) {
		//split()将一个字符串分解成一个数组,两次遍历result中的值分别为['itemId','xx']
		var temp = result[i].split('=');
		paras[temp[0]] = temp[1];
	}
	//根据参数名"goodsName"，获取参数值
	var item = paras.goodsName;
	// 解码
	var goodsName = decodeURIComponent(item);
	// 判断有无数据传入
	if (goodsName) {
		// 放入搜索框
		$("#goodsName").val(goodsName)
	} else {
		$("#goodsName").val("");
	}
	// 查询按钮单击事件
	$(".Search-button").click(function() {
		// 获取查询的值
		var goodsName = $("#goodsName").val()
		// 存入cookie
		util.cookie.set("selectName",goodsName);
		loadGird();
		});

	//    loadGird();

});
function loadGird() {
	var name = util.cookie.get("selectName");
new LIST({
        "renderTo": "table",
        "requData": "servlet/GoodsSelectServle.action",
        "postData": { // 请求参数
            "name": name
        }
        
    });
}
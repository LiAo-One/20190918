$(function () {
    // 搜索单击事件
    $(".search-btn").click(function () {
        // 获取搜框文本
        var goodsName = $(".search-text").val();
        // 存入cookie
        util.cookie.set("selectName",goodsName);
        // 编码
        window.location.href = 'AccountList.aspx?dev=' + encodeURIComponent(goodsName);
        // 页面跳转，将数据已键值对的方式存入地址栏
        location.href = "jsp/search.jsp?goodsName=" + goodsName;

    });

    // 轮播图加载事件
    var currentIndex = 0;
    $('.testSlider').slider({
        originType: 'tuoyuan'
    });
    // 商品列表加载事件
    new LIST({
        "renderTo": "table",
        // 分页查询
        "requData": "servlet/GoodsSelectServle.action"
    });
});

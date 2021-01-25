$(function () {

    top.editBtn = $(".edit");
    top.removeBtn = $(".delet");


    loadGird();

//	查询按钮

    $(".select").click(function () {
        loadGird();

    })
    // 	给添加按钮绑定点击事件
    $(".add").click(function () {
        if ($(".add").hasClass("btn-disable")) {
            alert("请选择一行数据");
            return;
        }
        // 出现对话框 top:定层父页面
        top.isEdit = false;
        top.dialog.show({
            "text": "添加商品类别",
            "add": "Add/category.jsp",
            "width": 30,
            "height": 15
        });

    });

    // 	给编辑按钮绑定点击事件
    $(".edit").click(function () {
        if ($(".edit").hasClass("btn-disable")) {
            alert("请选择一行数据");
            return;
        }
        top.isEdit = true;
        // 出现对话框 top:定层父页面
        top.dialog.show({
            "text": "修改商品类别",
            "add": "Add/category.jsp",
            "width": 30,
            "height": 15
        });

    });

    // 	给删除按钮绑定点击事件
    $(".delet").click(function () {
        if ($(".delet").hasClass("btn-disable")) {
            alert("请选择一行数据");
            return;
        }
        // 出现对话框 top:定层父页面
        top.dialog.show({
            "text": "删除",
            "confrim": true,
            "width": 20,
            "height": 9.2,
            "onClickYes": function () {
                // 设置信息样式为 success
                tipsStyle = "tips-success";

                $.post("servlet/CategoryDeletServlet.action", {
                    "id": top.editObject.id
                }, function (res) {
                    if (res.isSuccess == "true") {
                        //				alert(res.message);
                        // 刷新表格
                        top.goodsGird.reload(1, 10);
                        // 设置信息样式为 success
                        tipsStyle = "tips-success";
                        // 隐藏对话框
                        top.dialog.hide();
                    } else {
                        //				alert(res.message);
                        // 设置信息样式为 success
                        tipsStyle = "tips-success";
                    }
                    // 显示提示信息组件
                    top.dialogTips.show({
                        "message": res.message,
                        "tipsStyle": tipsStyle
                    });
                    // 一段时间之后，提示信息隐藏
                    setTimeout(function () {
                        top.dialogTips.hide();
                    }, 2000);
                }, "json");
            }
        });
    });
    loadGird();
});

function loadGird() {
//	获取参数
    var name = $("#name").val();
    top.goodsGird = new TAL({
        "renderTo": "table",
        "requData": "servlet/CategorySelectServlet.action",
        "dataSource": [{
            "name": "id",
            "text": "类别ID"
        }, {
            "name": "name",
            "text": "名称"
        }, {
            "name": "time",
            "text": "时间"
        }],
        "dblclick": function (obj) {
            alert(obj.id);
        }, "postData": {
            "name": name
        },
        "onClick": function (row) {
            // 点击一行之后，弹出当前点击行的id
            top.editObject = {};

            // 获取选中行数据 	获取选中行中每一个td
            $(".td-select > td", $("#table")).each(function (i, item) {

                // 获取td的属性名
                var alias = $(item).attr("data-alias");

                // 获取td的属性值
                var value = $(item).attr("data-value");

                top.editObject[alias] = value;

                $(".btn-disable").removeClass("btn-disable");

            });

            console.log(top.editObject);
        }

    });
}
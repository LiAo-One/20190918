$(function () {

    top.editBtn = $(".edit");
    top.removeBtn = $(".delet");

    loadGird();

    //	查询按钮
    $(".select").click(function () {
        loadGird();
    });

    // 	给添加按钮绑定点击事件
    $(".add").click(function () {
        if ($(".add").hasClass("btn-disable")) {
            alert("请选择一行数据");
            return;
        }
        top.isEdit = false;
        // 出现对话框 top:定层父页面
        top.dialog.show({
            "text": "添加用户",
            "add": "Add/userAdd.jsp",
            "width": 55,
            "height": 24.25
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
            "text": "修改用户",
            "add": "Add/userAdd.jsp",
            "width": 55,
            "height": 24.25
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

                $.post("servlet/UserDeleteServlet.action", {
                    "id": top.editObject.id,
                    "lev": top.editObject.lev
                }, function (res) {
                    if (res.isSuccess == "true") {
                        //				alert(res.message);
                        //				设置信息样式为 success
                        tipsStyle = "tips-success";
                        //				 刷新表格
                        top.goodsGird.reload(1, 10);

                        //				隐藏对话框
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
                }, "json")
            }
        });
    });

    loadGird();

});

function loadGird() {

    //	获取查询参数
    var name = $("#name").val();//ID
    var userName = $("#userName").val();//ID
    var lev = $("#lev").val();//ID
    var age = $("#age").val();//ID

    top.goodsGird = new TAL({
        "renderTo": "user",
        "requData": "servlet/UserSelectServlet.action",
        "dataSource": [{
            "name": "id",
            "text": "ID"
        }, {
            "name": "nikeName",
            "text": "姓名"
        }, {
            "name": "loginName",
            "text": "帐号"
        }, {
            "name": "loginPwd",
            "text": "密码"
        }, {
            "name": "balance",
            "text": "余额",
            "fomatter": function (value) { // 格式化数据
                var str = "$"+value;

                return str;
            }
        }, {
            "name": "lev",
            "text": "等级",
            "fomatter": function (value) { // 格式化数据

                var str = "";
                var lev = parseInt(value);
                if (value == "10") {
                    str = "<i class='fa fa-asterisk fa-woman'></i>";

                } else {
                    // 性别为男
                    str = "<i class='fa fa-user-circle fa-woman'></i>";
                }

                return str;
            }
        }, {
            "name": "sex",
            "text": "性别",
            "fomatter": function (value) { // 格式化数据

                var str = "";
                if (value == "男") {
                    // 性别为女
                    str = "<i class='fa fa-venus fa-woman'></i>";

                } else {
                    // 性别为男
                    str = "<i class='fa fa-mars fa-man'></i>";
                }

                return str;
            }
        }, {
            "name": "age",
            "text": "年龄"
        }, {
            "name": "img",
            "text": "头像",
            "fomatter": function (value) { // 格式化数据

                var str = "";
                str = "<img src=" + 'imgas/' + value + '' + " data-index = " + value + ">";

                return str;
            },
            "dateValueFomatter": function (value) { // data-value 数据格式化
                var str = value;

                return str;

            }
        }, {
            "name": "createTime",
            "text": "时间"
        }],
        "postData": { // 请求参数
            "name": name,
            "userName": userName,
            "lev": lev,
            "age": age
        },
        "onClick": function (row) {
            top.editObject = {};

            // 获取选中行数据 	获取选中行中每一个td
            $(".td-select > td", $("#user")).each(function (i, item) {

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

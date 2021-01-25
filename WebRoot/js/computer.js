window.onload = function () {
    // 定义数组，存储输入的文本
    var way_res = [];
    // 获取按钮对象
    var but_txt = document.getElementsByClassName("btn_click");
    // 获取屏幕元素
    var txt = document.getElementsByClassName("txt")[0];
    // 获取清空按钮和删除按钮
    var but_awy = document.getElementsByClassName("btn");
    // 判断按钮
    for (var i = 0; i < but_awy.length; i++) {
        but_awy[i].onclick = function () {
            //判断按钮
            if (this.value == "AC") {
                way_res = [];
                txt.value = "";
            } else {
                // substr() 截断字符串 1.从那个位置开始   2.截取多少长度
                txt.value = txt.value.substr(0, txt.value.length - 1);
            }
        }
    }

    // 给其他按钮添加事件
    for (var i = 0; i < but_txt.length; i++) {
        // 如果屏幕为空或者用户直接输入 . 则给屏幕赋值 0.;
        but_txt[i].onclick = function () {
            for (var j = 0; j < but_txt.length; j++) {
                but_txt[j].className = "btn_click";
            }
            if (txt.value == "" && this.value == ".") {
                txt.value = "0.";
                this.className = "btn_clicks";
            } else {
                // !isNaN :判断用户输入的是否是数字
                if (!isNaN(this.value) || this.value == ".") {
                    // 返回小数点首次出现的位置
                    if (txt.value.indexOf(".") != -1) {
                        if (this.value != ".") {
                            // 不是小数点，进行拼接
                            txt.value += this.value;
                            this.className = "btn_clicks";
                        }
                    }
                    // 没有小数点，直接拼接
                    else {
                        txt.value += this.value;
                        this.className = "btn_clicks";
                    }
                } else {
                    // 如果输入的是符号不为等号
                    if (this.value != "=") {
                        // 拼接数字
                        way_res[way_res.length] = txt.value;
                        // 存符号
                        way_res[way_res.length] = this.value;
                        this.className = "btn_clicks";
                        // 清空屏幕
                        txt.value = "";
                    } else {
                        //是等号的情况
                        way_res[way_res.length] = txt.value;
                        //eval()方法   专门用来计算表达式的值
                        txt.value = eval(way_res.join(""));
                        this.className = "btn_clicks";
                        //计算完成之后将数组清空
                        way_res = [];
                    }
                }
            }
        }
    }
}



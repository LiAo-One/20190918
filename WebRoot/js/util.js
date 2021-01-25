var util = {
    cookie: {
        set: function (key, value) {
            var date = new Date();
            date.setDate(date.getDate() + 7);
            document.cookie = encodeURI(key + "=" + value + ";expires=" + date.toGMTString());
        }, get: function (key) {
            var cookies = document.cookie.split("; ");
            for (var i = 0; i < cookies.length; i++) {
                var cookie = cookies[i].split("=");
                if (cookie[0] == key) {
                    return decodeURI(cookie[1]);
                }
            }
        }
    },

    validata: function (str, type) {
//		存储规则字符串
        var strReg = "";
//		规则
        var rules = {
            "f": "A-Z",
            "c": "\u4e00-\u9fa5",
            "e": "A-Za-z",
            "n": "0-9",
            "p": ".",
            "_": "_",
            "a": "@",
            "b": ",./?: '\"  ；’‘’[]【】"
        };
        for (var rule in rules) {
//		在type中寻找规则
            if (type.indexOf(rule) > -1) {
                strReg += rules[rule];
            }
        }
//		创建正则对象
        var regExp = new RegExp(eval("/^[" + strReg + "]*$/"));

//		返回验证之后的结果
        return regExp.test(str);
    }
};




















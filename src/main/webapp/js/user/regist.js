$(function(){
    layui.use('form', function () {
        var form = layui.form;
        form.on('submit(formDemo)', function (data) {
            console.log(data.elem) //被执行事件的元素DOM对象，一般为button对象
            console.log(data.form) //被执行提交的form对象，一般在存在form标签时才会返回
            console.log(data.field) //当前容器的全部表单字段，名值对形式：{name: value}

            $.ajax({
                    url:registUrl,
                    data:data.field,
                    async:"true",
                    type:"POST",
                    success:function(d){
                        layer.msg(d.message,{
                            icon: 1,
                            time:2000
                        });
                    }
                })
            return false;
        })
    });
})
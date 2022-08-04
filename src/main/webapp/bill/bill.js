$(function () {
    intDate();
    var thisYear =   new Date().getFullYear();
    $('#yearBill_date').val(thisYear);
    var year = $('#yearBill_date').val();
    loadEcharts(year);


    //年选择器
    function  intDate() {
        layui.use(['laydate', 'form'], function(){
            var laydate = layui.laydate;
            laydate.render({
                elem: '#yearBill_date',
                type: 'year',
                value:'2021',
                done:function(value,date,endDate){
                    $('#yearBill_date').val(value);
                    loadEcharts(value);
                },
                theme: 'molv'
            });
        });
    }
    //echarts
    function  loadEcharts(date) {
        var param = {year:date};
        var monthArr = [];
        var moneyArr = [];
        for(var i= 1;i<=12;i++){
            monthArr.push(i + '月');
        }
        $.ajax({
            url:'/bill//getYearBill',
            type:"POST",
            contentType:"application/json;charset=utf-8",
            data:JSON.stringify(param),
            dataType:'json',
            async:false,
            success:function (data) {
                moneyArr = data.listMoney;
            }
        })
        var option = {
            tooltip:{
                trigger:'axis'
            },
            xAxis:{
                type:'category',
                data:monthArr,
            },
            yAxis: {
                type: 'value',
            },
            series: [{
                data: moneyArr,
                type: 'line',
                itemStyle : { normal: {label : {show: true}}},
            }]
        }
        echarts.init(document.getElementById('yearBill_chart')).setOption(option);
    }
})

$(function(){

    /**
     * report页面下拉框监听事件
     */
    $("#selectCityId").change(function(){

        var cityId=$("#selectCityId").val();
        var url='/report/cityId/'+cityId;
        window.location.href=url;
    })
});
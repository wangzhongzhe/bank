var bankCard = [
    [
        {field:'cardId',title:'卡号',width:80,sortable:true},
        {field:'bank',title:'银行',width:80,sortable:true},
        {field:'accountHolder',title:'开户人',width:80,sortable:true},
        {field:'cardType',title:'类型',width:80,sortable:true},
        {field:'fixedDeposit',title:'定期存款',width:80,sortable:true},
        {field:'currentDeposit',title:'活期存款',width:80,sortable:true}
    ]
]


$(document).ready(function(){

    getTableData();
    $("body").on("click",".search",function(){
        console.log(123);
        getTableData();
    });

    $("body").on("click",".buttonDiv .add",function(){
        var msgDom = $('<div class="upTop"></div>');
        msgDom.append('<div class="line"><em>卡号：</em><div class="sInput"><input type="text" class="cardId"/></div></div>');
        msgDom.append('<div class="line"><em>银行：</em><div class="sInput"><input type="text" class="bank"/></div></div>');
        msgDom.append('<div class="line"><em>开户人：</em><div class="sInput"><input type="text" class="accountHolder"/></div></div>');
        msgDom.append('<div class="line"><em>类型：</em><div class="sInput"><input type="text" class="cardType"/></div></div>');
        msgDom.append('<div class="line"><em>定期存款：</em><div class="sInput"><input type="text" class="fixedDeposit"/></div></div>');
        msgDom.append('<div class="line"><em>活期存款：</em><div class="sInput"><input type="text" class="currentDeposit"/></div></div>');
        BootstrapDialog.show({
            title: '新建',
            message: msgDom,
            buttons: [{
                label: '提交',
                action: function(dialog) {
                    console.log("提交");
                }
            }, {
                label: '取消',    
                action: function(dialog) {
                    dialog.close();
                }
            }]
        });
    });


});


var getTableData = function(){
    var search = $(".searchContent").val();
    console.log(search);
    $('#bankCardTable').datagrid({
        url:'/bank/select',
        columns: bankCard,
        singleSelect: true,
        pagination: true,
        method: 'post',
        //fitColumns: true,
        queryParams: {"search": search},
        onLoadSuccess: function (data) {
            console.log("ok");
//            restyleCheckBox();
//            $(".datagrid-body").css("overflow-x", "auto");
//            $(".ztable .datagrid").css("width", "100%");
            /*$("#jobsTable" + maxIndex).datagrid('doCellTip', {cls: {'max-width': '300px'}, delay: 1000});*/
        }
    });
}
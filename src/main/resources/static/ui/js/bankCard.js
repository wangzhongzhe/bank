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
        var msgDom = $('<>');

        BootstrapDialog.show({
            title: '新建',
            message: 'Click buttons below.',
            buttons: [{
                label: 'Message 1',
                action: function(dialog) {
                    dialog.setMessage('Message 1');
                }
            }, {
                label: 'Message 2',
                action: function(dialog) {
                    dialog.setMessage('Message 2');
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
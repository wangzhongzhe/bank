var bankCard = [
	[{
		field: 'ck',
		checkbox: true
	}, {
		field: 'cardId',
		title: '卡号',
		width: 120,
		sortable: true,
		resizable: true
	}, {
		field: 'bank',
		title: '银行',
		width: 120,
		sortable: true,
		resizable: true
	}, {
		field: 'accountHolder',
		title: '开户人',
		width: 120,
		sortable: true,
		resizable: true
	}, {
		field: 'cardType',
		title: '类型',
		width: 80,
		sortable: true,
		resizable: true
	}, {
		field: 'fixedDeposit',
		title: '定期存款',
		width: 200,
		sortable: true,
		resizable: true
	}, {
		field: 'currentDeposit',
		title: '活期存款',
		width: 200,
		sortable: true,
		resizable: true
	}]
]

$(document).ready(function() {

	getTableData();
	$("body").on("click", ".search", function() {
		//console.log(123);
		getTableData();
	});

	$("body").on("click", ".buttonDiv .add", function() {
		var domData = [{
            "id": "cardId",
            "name": "卡号",
            "type": "1"
        }, {
            "id": "bank",
            "name": "银行",
            "type": "1"
        }, {
            "id": "accountHolder",
            "name": "开户人",
            "type": "1"
        }, {
            "id": "cardType",
            "name": "类型",
            "type": "1"
        }, {
            "id": "fixedDeposit",
            "name": "定期存款",
            "type": "1"
        }, {
            "id": "currentDeposit",
            "name": "活期存款",
            "type": "1"
        }];

        var msgDom = commonUtils.makePanelDom(domData);
		BootstrapDialog.show({
			title: '新建',
			message: msgDom,
			buttons: [{
				label: '提交',
				action: function(dialog) {
//					var data = {
//						cardId: 　$(".addUpTop .cardId").val(),
//						bank: 　$(".addUpTop .bank").val(),
//						accountHolder: 　$(".addUpTop .accountHolder").val(),
//						cardType: 　$(".addUpTop .cardType").val(),
//						fixedDeposit: 　$(".addUpTop .fixedDeposit").val(),
//						currentDeposit: 　$(".addUpTop .currentDeposit").val(),
//					};
                    var data = commonUtils.getDomValue('.zTop');
					$.ajax({
						url: "/bank/insertBankCardInfo",
						type: 'POST',
						data: data,
						dataType: "json",
						async: false,
						success: function(data) {
							//先清理缓存dom
							if(data.status) {
								getTableData();
							} else {
								alert(data.message);
							}
						},
						error: function(data) {
							if(data.status == '500') {
								showAlertDialog("服务器内部错误!");
							}
						}
					});
				}
			}, {
				label: '取消',
				action: function(dialog) {
					dialog.close();
				}
			}]
		});
	});

	$("body").on("click", ".buttonDiv .edit", function() {
		var domData = [{
			"id": "cardId",
			"name": "卡号",
			"type": "1"
		}, {
			"id": "bank",
			"name": "银行",
			"type": "1"
		}, {
			"id": "accountHolder",
			"name": "开户人",
			"type": "1"
		}, {
			"id": "cardType",
			"name": "类型",
			"type": "1"
		}, {
			"id": "fixedDeposit",
			"name": "定期存款",
			"type": "1"
		}, {
			"id": "currentDeposit",
			"name": "活期存款",
			"type": "1"
		}];

		var msgDom = commonUtils.makePanelDom(domData);
		debugger
		BootstrapDialog.show({
			title: '修改',
			message: msgDom,
			buttons: [{
				label: '提交',
				action: function(dialog) {
					var data = {
						cardId: 　$(".addUpTop .cardId").val(),
						bank: 　$(".addUpTop .bank").val(),
						accountHolder: 　$(".addUpTop .accountHolder").val(),
						cardType: 　$(".addUpTop .cardType").val(),
						fixedDeposit: 　$(".addUpTop .fixedDeposit").val(),
						currentDeposit: 　$(".addUpTop .currentDeposit").val(),
					};
					$.ajax({
						url: "/bank/insertBankCardInfo",
						type: 'POST',
						data: data,
						dataType: "json",
						async: false,
						success: function(data) {
							//先清理缓存dom
							if(data.status) {
								getTableData();
							} else {
								alert(data.message);
							}
						},
						error: function(data) {
							if(data.status == '500') {
								showAlertDialog("服务器内部错误!");
							}
						}
					});
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

var getTableData = function() {
	var search = $(".searchContent").val();
	console.log(search);
	$('#bankCardTable').datagrid({
		url: '/bank/select',
		columns: bankCard,
		//singleSelect: true,
		pagination: true,
		method: 'post',
		//checkOnSelect:false,
		//selectOnCheck:true,
		//fitColumns: true,
		queryParams: {
			"search": search
		},
		onLoadSuccess: function(data) {
			console.log("ok");
			//            restyleCheckBox();
			//            $(".datagrid-body").css("overflow-x", "auto");
			//            $(".ztable .datagrid").css("width", "100%");
			/*$("#jobsTable" + maxIndex).datagrid('doCellTip', {cls: {'max-width': '300px'}, delay: 1000});*/
		}
	});
}
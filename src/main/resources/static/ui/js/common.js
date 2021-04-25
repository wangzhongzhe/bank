var commonUtils = {
	makePanelDom: function(domData, valueData) {
		var $dom = $('<div class="zTop"></div>');
		for(var i = 0; i < domData.length; i++) {
			var item = domData[i];
			var id = item.id;
			var name = item.name;
			var type = item.type;
			var disable = item.disable;
			var hidden = item.hidden;
			var $itemDom = $('<div class="line"><em></em><div class="sInput"></div></div>');
			$itemDom.attr('id-data', id);
			$itemDom.find('em').html(name + ":");
			if(item.type == '1') {
				$itemDom.find('.sInput').html('<input class="inn" type="text" />');
			} else if(item.type == '2') {

			}
			if(valueData && valueData[id]) {
				$itemDom.find('.inn').val(valueData[id]);
			}
			if(disable) {
				$itemDom.find('.inn').attr('disabled', 'disabled');
			}
			if(hidden) {
				$itemDom.addClass('hidden');
			}
			$dom.append($itemDom);
		}
		return $dom;
	},
	getDomValue: function(dom) {
		var $dom = $(dom);
		var value = {};
		$dom.find('.line').each(function(e) {
			value[$(this).attr('id-data')] = $(this).find('.inn').val();
		});
		return value;
	}
}
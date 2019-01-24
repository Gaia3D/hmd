HMD.GIS.Util = (function() {
	return {
		/**
		 * 명시적인 레이어 ID를 통해 Layer 객체를 얻는다.
		 * @param {String} layerID
		 * @returns {Object} Layer
		 */
		getLayerById: function(layerId) {
			var layer = null;

			if(layerId){
				var layers = map.getLayers().getArray();

				for(var i in layers){	 // 브라우저 호환성 - ie6~, chrome
					if(layers[i].get('id') === layerId){
						layer = layers[i];
						break;
					}
				}
			}

			return layer;
		},

		/**
		 * layer의 파라미터를 갱신하여 on/off를 상태를 변경한다.
		 * @param {String} wmsLayerId: 			갱신할 레이어의 ID		(예) tile_layer, base_layer, ...
		 * @param {String} sourceLayerIdList: 	소스 레이어 이름	리스트	(예) ['layer_1', 'layer_2', ...]
		 */
		// 이름바꾸기
		layerOnOff: function(wmsLayerId, sourceLayerIdList) {
			if(!wmsLayerId || !sourceLayerIdList){
				return false;
			}

			var targetLayer = this.getLayerById(wmsLayerId);
			targetLayer.getSource().updateParams({'layers': sourceLayerIdList});
			targetLayer.setVisible(sourceLayerIdList.length !== 0);
		}
	}
})();
// 빼고
var gis = HMD.GIS.Util;

//gis = $.extend({}, HMD.GIS, HMD.GIS.Util);

function loadBlock(){
	$.ajax({
		url: 'http://localhost:8090/block',
		type: 'post',
		dataType: 'json',
		data: {mfgInd: '1', areagrp: 'A100'},
		success: function(a,b){

		},
		error: function(a,b,msg){

		}
	})
}
function addPolygon(coord){
	var transCoord = coord;

}
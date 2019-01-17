HMD.GIS.Util = (function(){
	return {
		/**
		 * 명시적인 레이어 ID를 통해 Layer 객체를 얻는다.
		 * @param {String} layerID
		 * @returns {Object} Layer
		 */
		getLayerById: function(layerId){
			var layers = map.getLayers().getArray();
			var layer = null;

			for(var i in layers){
				if(layers[i].get('id') === layerId){
					layer = layers[i];
					break;
				}
			}
			return layer;
		},

		/**
		 * layer의 파라미터를 갱신하여 on/off를 상태를 변경한다.
		 * @param {String} targetLayerId: 갱신할 레이어의 ID		(예) tile_layer, base_layer, ...
		 * @param {String} showLayerNameList: 보여줄 레이어 이름	(예) ['layer_1', 'layer_2', ...]
		 */
		layerOnOff: function(targetLayerId, showLayerNameList){
			var targetLayer = this.getLayerById(targetLayerId);
			targetLayer.getSource().updateParams({'layers': showLayerNameList});
			targetLayer.setVisible(showLayerNameList.length !== 0);
		}
	}
})();

var gis = HMD.GIS.Util;

//gis = $.extend({}, HMD.GIS, HMD.GIS.Util);
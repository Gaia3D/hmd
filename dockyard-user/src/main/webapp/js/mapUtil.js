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

function loadBlock(dataCount) {
	$.ajax({
		url: 'http://localhost:8090/block',
		type: 'post',
		dataType: 'json',
		data: {mfgInd: '1', areagrp: 'A100', tranMfgInd: '5', plnwrkdte: '20181224'},
		success: function(res) {
			var len = dataCount;
			for(var i=0; i<len; i++) {
				var rawData = res[i].ctipointa;
				var splitData = rawData.split(";");
				var boxArr = [];

				for(var j=0, l=4; j<l; j++) {
					var coord = splitData[j].split(",");
					var lon = coord[0] / 1000000;
					var lat = coord[1] / 1000000;
					var transCoord = ol.proj.transform([lon, lat], "EPSG:4326", map.getView().getProjection());
					boxArr.push(transCoord);
				}

				boxArr.push(boxArr[0]);

				var feature = new ol.Feature({
					geometry: new ol.geom.Polygon([boxArr])
				});

				var style = new ol.style.Style({
				    fill: new ol.style.Fill({color: [0, 0, 255, 0.5]}), 			// blue
				    stroke: new ol.style.Stroke({color: [255, 0, 0, 1], width: 2})	// red
				});

				feature.setStyle(style);

				var layer = gis.getLayerById('block_layer');
				layer.getSource().addFeature(feature);
			}
		},
		error: function(a,b,msg){
			debugger;
		}
	})
}
function addPolygon(coord){
	var transCoord = coord;

}
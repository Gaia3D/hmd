/**
 * 명시적인 레이어 ID를 통해 Layer 객체를 얻는다.
 * @param {String} layerID
 * @returns {Object} Layer
 */
function getLayerById(layerId){
	var layers = map.getLayers().getArray();
	var layer = null;

	for(var i in layers){
		if(layers[i].get('id') === layerId){
			layer = layers[i];
			break;
		}
	}
	return layer;
}

// create Point
addImagePoint('block_layer');

function addImagePoint(layerid) {
	var coord = [129.400218331128, 35.5072031799572];
	var transCoord = ol.proj.transform(coord, "EPSG:4326", map.getView().getProjection());

	var feature = new ol.Feature({
		//geometry: new ol.geom.Point([129.396686409664, 35.501695934426])
		//geometry: new ol.geom.Point([ 417767, 325502 ])
		geometry: new ol.geom.Point(transCoord)
	});

	var style = new ol.style.Style({
		image: new ol.style.Circle({
			fill: new ol.style.Fill({color: 'yellow'}),
            stroke: new ol.style.Stroke({color: 'black', width:2}),
			radius: 10
		})
	});

	feature.setStyle(style);

	var layer = gis.getLayerById(layerid);
	layer.getSource().addFeature(feature);
}
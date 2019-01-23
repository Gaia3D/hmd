HMD.GIS.DEV = (function() {
	return {
		layerType : function(obj, layerId, layerName) {
			if($(obj).hasClass('on')) {
				switch (layerName) {
					case "point":
						addFeaturePoint(layerId);
						break;
					case "line":
						addFeatureLine(layerId);
						break;
					case "polygon":
						addFeaurePolygon(layerId);
						break;
				}
			} else {
				removeFeature(layerId);
			}
		}
	}
})();

var dev = HMD.GIS.DEV;


var featurePoint;
var featureLine;
var featurePolygon;

// create Point Feature
function addFeaturePoint(layerid) {
	var coord = [129.400218331128, 35.5072031799572];
	var transCoord = ol.proj.transform(coord, "EPSG:4326", map.getView().getProjection());

	featurePoint = new ol.Feature({
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

	featurePoint.setStyle(style);

	var layer = gis.getLayerById(layerid);
	layer.getSource().addFeature(featurePoint);
}

// create Line Feature
function addFeatureLine(layerid) {
	
}

// crate Polygon Feature
function addFreaturePolygon() {
	
}

// remove Feature
function removeFeature(layerid) {
	var layer = gis.getLayerById(layerid);
	if(layer.getSource().getFeatures().length != 0) layer.getSource().removeFeature(featurePoint);
}

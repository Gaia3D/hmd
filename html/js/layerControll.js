/*var defaultImgLayer = [{
    id: "1",
    name : "OpenStreetMaps",
    provider : Cesium.createOpenStreetMapImageryProvider(),
    alpha : 0.7,
    show : false
},
{
    id: "2",
    name : "ArcGIS World Street Maps",
    provider : new Cesium.ArcGisMapServerImageryProvider({
        url : 'https://services.arcgisonline.com/ArcGIS/rest/services/World_Street_Map/MapServer'
    }),
    alpha : 0.5,
    show : false
}];*/

var defaultMapLayer = [
    new ol.layer.Tile({
        id: 'base_layer',
        visible: true,
        source: new ol.source.TileWMS({
            url: 'http://seoul.gaia3d.com:8989/geoserver/hmd/wms',
            params: {
            	format : 'image/png',
                version : '1.1.1',
                tiled: true,
                srs: 'EPSG:5186',
            	layers: ['hmd:2018_AerialPhoto']
            }
        })
    }),
    new ol.layer.Image({
        id: 'shp_layer',
        visible: true,
        source: new ol.source.ImageWMS({
            url: 'http://seoul.gaia3d.com:8989/geoserver/hmd/wms',
            params: {
                version : '1.1.1',
                tiled: true,
                srs: 'EPSG:5186',
            	layers: ['hmd:LDREG', 'hmd:F01000', 'hmd:A01000', 'hmd:B01000']
            }
        })
    }),
    new ol.layer.Vector({
	   id : 'block_layer',
	   visible : true,
	   source : new ol.source.Vector({
	      features: new ol.Collection()
	   })
	})
];

var proj = new ol.proj.Projection({
    code : 'EPSG:5186',
    units : 'm',
    global : false,
    extent : [-219825.99, -435028.96, 819486.07, 877525.22]
});

var view = new ol.View({
	center : [ 417767, 325502 ],
    zoom : 10,
    extent : [415386.0, 319618.05, 422907.7214749511, 333271.14020420035],
    projection : proj
});

//create Map
var map = new ol.Map({
    //interactions: ol.interaction.defaults().extend([]),
    layers : defaultMapLayer,
    target : 'map',
    view : view
});

// create Point
addImagePoint('block_layer');

function addImagePoint(layerid) {
	var coord = [129.396686409664, 35.501695934426];
	
	var feature = new ol.Feature({
		//geometry: new ol.geom.Point([129.396686409664, 35.501695934426])
		geometry: new ol.geom.Point([ 417767, 325502 ])
	});
	
	var style = new ol.style.Style({
		image: new ol.style.Circle({
			fill: new ol.style.Fill({color: 'yellow'}),
            stroke: new ol.style.Stroke({color: 'black', width:2}),
			radius: 10
		})
	});
	
	feature.setStyle(style);
	
	var layer = getLayerById(layerid);
	layer.getSource().addFeature(feature);
}





function toggleLayer(obj){
	var updateLayers = [];
	var layerType = $(obj).data('type');
	var showLayers = $('.mapLayer li.on.' + layerType);

	for(var i=0, len=showLayers.length; i<len; i++){
		var layer = $(showLayers[i]);
		var layerid = layer.data('layerid');
		updateLayers.push(layerid);
	}

	var mapLayer = getLayerById(layerType+'_layer');
	mapLayer.getSource().updateParams({'layers':updateLayers});
	mapLayer.setVisible(updateLayers.length !== 0);
}

/*
function LayerControll(viewer) {
    var imageryLayers = viewer.imageryLayers;

    //createLayers(defaultImgLayer);
    createLayers(defaultMapLayer);

    var layerApp = new Vue({
        el : "#layerContent",
        data: {
            index : 0,
            selectedLayer : null,
            defaultLayer : null,
            //imgLayers : JSON.parse(JSON.stringify(defaultImgLayer)),
            mapLayers : JSON.parse(JSON.stringify(defaultMapLayer)),
            //defaultImgLayers : JSON.parse(JSON.stringify(defaultImgLayer)),
            defaultMapLayers : JSON.parse(JSON.stringify(defaultMapLayer))
        },
        beforeMount : function () {
            //this.selectedLayer = this.imgLayers[0];
            //this.defaultLayer = this.defaultImgLayers[0];
        },
        mounted : function () {
            // 레이어 옵션
            var range = $('#range-slider');
            var value = $('#range-value');
            var color = $('input[type="color"]');

            // 설정화면 투명도 값 변경 시 동작
            value.change(function(){
                var value = $(this).val();
                if(value < 0 ) value = 0;
                if(value > 100) value = 100;
                if(value.lastIndexOf("%") == 2) {
                    range.val(parseInt(value));
                } else {
                    $(this).val(parseInt(value) + "%");
                    range.val(parseInt(value));
                }
            });
            // 설정화면 투명도 슬라이더 변경 시 동작
            range.change(function(){
                value.val($(this).val() + "%");
            });
            color.change(function() {
                selectedColor = $(this).val();
                $(this).css('fill',selectedColor);
            });
            $('#settingLayer').find('.layerHeader .layerClose').click(function() {
                $('#settingLayer').removeClass('on').hide();
            });

            $('#closeBtn').click(function() {
                $('#settingLayer').removeClass('on').hide();
            });
        },
        methods : {
            initLayer : function() {
                //this.selectedLayer.show = this.defaultLayer.show;
                this.selectedLayer.alpha = this.defaultLayer.alpha;

                var layer = imageryLayers.get(this.index + 1);
                layer.alpha = this.selectedLayer.alpha;
                layer.show = this.selectedLayer.show;

                if(this.defaultLayer.color !== undefined && this.selectedLayer.color !== undefined)
                {
                    this.selectedLayer.color = this.defaultLayer.color;
                    layer._imageryProvider._resource._queryParameters.env = "color:" + this.selectedLayer.color;
                    layer._imageryProvider._tileProvider._resource._queryParameters.env = "color:" + this.selectedLayer.color;
                }

                imageryLayers.remove(layer, false);
                imageryLayers.add(layer, this.index + 1);
            },
            settingLayer : function (index, layer, defaultLayer) {
                this.index = index;
                this.selectedLayer = layer;
                this.defaultLayer = defaultLayer;

                var obj = $('#settingLayer');
                obj.toggleClass('on');
                obj.toggle(obj.hasClass('on'));
                obj.center(); // 옵션창을 화면 중앙에 배치

                console.log("SettingLayer = " + layer);
            },
            updateLayer : function () {
                var obj = $('#settingLayer');
                var opacity = $('#range-slider').val();
                var color = $('input[type="color"]').val();

                this.selectedLayer.alpha = parseInt(opacity)/100;

                var layer = imageryLayers.get(this.index + 1);
                layer.alpha = this.selectedLayer.alpha;
                layer.show = this.selectedLayer.show;

                if(color!== undefined && this.selectedLayer.color !== undefined)
                {
                    this.selectedLayer.color = color.substr(1,6);
                    layer._imageryProvider._resource._queryParameters.env = "color:" + this.selectedLayer.color;
                    layer._imageryProvider._tileProvider._resource._queryParameters.env = "color:" + this.selectedLayer.color;
                }

                imageryLayers.remove(layer, false);
                imageryLayers.add(layer, this.index + 1);
            },
            changeLayer : function (e, offset, group) {
                switch (group) {
                    case '0' :
                        var defaultLayer = this.defaultImgLayers;
                        break;
                    case '1' :
                        var defaultLayer = this.defaultMapLayers;
                        break;
                }

                var target = e.moved;
                if(target)
                {
                    defaultLayer.splice(target.newIndex, 0, defaultLayer.splice(target.oldIndex, 1)[0]);

                    var oldIndex = offset + target.oldIndex + 1;
                    var newIndex = offset + target.newIndex + 1;

                    var layer = imageryLayers.get(oldIndex);
                    imageryLayers.remove(layer, false);
                    imageryLayers.add(layer, newIndex);

                    console.log(target.element.id + "(" + target.element.name +")");
                    console.log(target.oldIndex + "-->" + target.newIndex);
                }
            },
            toggleLayer : function (index, layer) {
                layer.show = !layer.show;
                var imageryLayer = imageryLayers.get(index + 1);
                imageryLayer.show = layer.show;
            }
        }
    });

    function createLayers(layers)
    {
        for(var i = 0, len = layers.length; i < len; i++)
        {
            var layer = imageryLayers.addImageryProvider(layers[i].provider);
            layer.alpha = Cesium.defaultValue(layers[i].alpha, 1.0);
            layer.show = Cesium.defaultValue(layers[i].show, true);
            layer.name = layers[i].name;

            if(layers[i].color !== undefined)
            {
                layer._imageryProvider._resource._queryParameters.env = "color:" + layers[i].color;
                layer._imageryProvider._tileProvider._resource._queryParameters.env = "color:" + layers[i].color;
            }
        }
    }
}
*/
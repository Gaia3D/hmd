var HMD = HMD||{};
HMD.GIS = (function(){ // 즉시실행함수
	/**
	 * private
	 * private 변수는 prefix("_")를 사용함
	 * http://asfirstalways.tistory.com/234
	 */
	var _layers = [
	    new ol.layer.Tile({
	        id: 'tile_layer',
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
	        id: 'base_layer',
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

	// projection 목록
	var _projCode = {
		'EPSG:5186': '+proj=tmerc +lat_0=38 +lon_0=127 +k=1 +x_0=200000 +y_0=600000 +ellps=GRS80 +towgs84=0,0,0,0,0,0,0 +units=m +no_defs',
	};

	var _proj = new ol.proj.Projection({
	    code : 'EPSG:5186',
	    units : 'm',
	    global : false,
	    extent : [-219825.99, -435028.96, 819486.07, 877525.22]
	});

	var _view = new ol.View({
		center : [417767, 325502],
	    zoom : 10,
	    extent : [415386.0, 319618.05, 422907.7214749511, 333271.14020420035],
	    projection : _proj
	});

	// 지도객체
	var _map;

	/**
	 * public
	 */
	return {
		projDefs: function(){
			Object.keys(_projCode).forEach(function(key){	// 브라우저 확인(9,10,11,크롬 확인)
				proj4.defs(key, _projCode[key]);
			});
        },

		create: function(element){
			// 좌표계 정의
            this.projDefs();

			// 맵 생성
			_map = new ol.Map({
			    //interactions: ol.interaction.defaults().extend([]),
			    layers: _layers,
			    view: _view,
			    target: element
			});

			return _map;
		}
	}
})();

var map = HMD.GIS.create('map');

// var gis = HMD.GIS;
// gis.create('map');


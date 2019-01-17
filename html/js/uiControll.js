// 화면 중앙 배치
(function($){
	$.fn.extend({
		center: function () {
			return this.each(function() {
				var top = ($(window).height() - $(this).outerHeight()) / 2;
				var left = ($(window).width() - $(this).outerWidth()) / 2;
			$(this).offset({top: (top > 0 ? top : 0), left: (left > 0 ? left : 0)});
			});
		}
	});
})(jQuery);

//컨텐츠 리사이즈
function contentsResize() {
	var obj = $('#contentsWrap');
	var hgt = $(window).height() - (obj.outerHeight(true) - obj.height());

	obj.height(hgt);
	$('.contentsList').height(hgt - ($('.contentsList').outerHeight(true) - $('.contentsList').height()));
	$('.contents').height(hgt - ($('.contents').outerHeight(true) - $('.contents').height()));
}

/*
function coordContentsResize()
{
	var height = $('.contents').height() - ($('.contentsIn').outerHeight(true) - $('.contentsIn').height());
	var offsetTop = $('.coordinateWrap').offset().top - $('.coordinateBtns').offset().top;
	$('.coordinateWrap').height(height - offsetTop);
}

function noteContentsResize()
{
	var height = $('.contents').height() - ($('.contentsIn').outerHeight(true) - $('.contentsIn').height());
	var offsetTop = $('.listNote').offset().top - $('#inputMapnote').offset().top;
	$('.listNote').height(height - offsetTop);
}
*/

window.onload = contentsResize;
window.onresize = contentsResize;

var settingsLayerParent;

// 레이어 창
var distanceLayer = $('#distanceLayer');
var areaLayer = $('#areaLayer');
var settingLayer = $('#settingLayer');
var mapnoteLayer = $('#mapnoteLayer');
var mapnoteDetailLayer = $('#mapnoteDetailLayer');

// 레이어 창 - 닫기 [X]
function layerClose(btnId) {
	// 어떤 레이어 창이 선택되었는지 확인
	var layerId = $(btnId);

	$(layerId).find('.layerHeader .layerClose').click(function() {
		$(btnId).hide();
	});
}
// 닫기 버튼
function closeBtn(layer) {
	var layerId = $(layer);
	$(document).on('click', '#closeBtn', function() {
		$(layer).hide();
	});
}

function toggleLayer(obj){
	var targetlayerId = $(obj).data('target-layer');
	var showLayerList = $('.mapLayer li.on[data-target-layer='+ targetlayerId +']');
	var showLayerNameList = [];

	for(var i=0, len=showLayerList.length; i<len; i++){
		var layer = $(showLayerList[i]);
		var layerName = layer.data('layer-name');
		showLayerNameList.push(layerName);
	}

	gis.layerOnOff(targetlayerId, showLayerNameList);
}

$(function() {

/***** NAV WRAP: 메뉴 *****/
	// 메뉴 on시 UI 확장됨
	// class="on"과 함께 #gnbWrap의 left 값 변경(40px<->110px)
	$('#menu').click(function() {
		var obj = $('#navWrap');
		obj.toggleClass('on');
		$('#gnbWrap').css("left", obj.width());
	});

	// 상세 메뉴 클릭 시 기본 동작
	$("ul.nav li[data-nav]:not(:empty)").click(function() {
		var active = $(this).attr('data-nav');
		var display = $(this).toggleClass('on').hasClass('on');

		$("ul.nav li[data-nav]:not(:empty)").not($(this)).each(function() {
			$(this).removeClass('on');
			$('#' + $(this).attr('data-nav')).hide();
		});

		$('#'+ active).toggle(display);
		$('#contentsWrap').toggle(display);
	});

	// 상세 메뉴 닫기
	$('#closeLeftBtn').click(function() {
		if($('#contentsWrap').css('display') == "none") {
			var display = $('ul.nav li[data-nav]').eq(0).toggleClass('on').hasClass('on');
			$('#searchContent').show();
			$('#contentsWrap').toggle(display);
			$('#closeLeftBtn').css('transform', 'rotate(90deg)');
			$('#closeLeftBtn').css('border-radius', '5px 5px 0 0');
			$('.contentsBtn').css('right', '-407px');
		} else {
			$('ul.nav li[data-nav]').removeClass('on');
			$('.contentsBtn').css('right', '-37px');
			$('#closeLeftBtn').css('transform', 'rotate(270deg)');
			$('#closeLeftBtn').css('border-radius', '0 0 5px 5px');
			$('#contentsWrap').toggle(display);
		}
	});

/***** NAV WRAP: 맵 컨트롤 *****/
	// 행정구역 검색
	$('div.district').hover(function() {
		$('div.districtWrap').css('display', 'block');
	}, function(){
		$('div.districtWrap').css('display', 'none');
	});

	$('div.districtWrap').hover(function() {
		$('div.districtWrap').css('display', 'block');
	}, function(){
		$('div.districtWrap').css('display', 'none');
	});

/***** NAV WRAP: 레이어 *****/
	// 레이어 메뉴 클릭 시 추가 동작
	$('#layerMenu').on('click', function() {
		console.log("레이어 메뉴 클릭");
	});

	// 레이어 그룹 클릭 시
	$('ul.listLayer li > p').click(function() {
		var parentObj = $(this).parent()
		var index = parentObj.index();
		$('ul.listLayer > li:eq('+ index +')').toggleClass('on');
	});
});

var stamen = L.tileLayer('http://stamen-tiles-{s}.a.ssl.fastly.net/toner-lite/{z}/{x}/{y}.png',{
	attribution : 'Map tiles by <a href="http://stamen.com">Stamen Design</a>, <a href="http://creativecommons.org/licenses/by/3.0">CC BY 3.0</a> &mdash; Map data &copy; <a href="http://www.openstreetmap.org/copyright">OpenStreetMap</a>'
});

var map = L.map("map", {
	zoom : 4,
	center : [ 50.94135, 6.95819 ],
	layers : [ stamen ],
	zoomControl : true,
	attributionControl : true
});

var stimmbezirkeLayer = L.geoJson(null, {
	onEachFeature: function(feature, layer) {
		var text = ""
			+ "Stimmbezirk: " + feature.id + "</br>"
			+ "Kommunalwahlbezirk: " + feature.properties.kommunalwahlkreis + "</br>"
			+ "Landtagswahlkreis: " + feature.properties.landtagswahlkreis + "</br>"
			+ "Bundestagswahlkreis: " + feature.properties.bundestagwahlkreis + "</br>"
			+ "Stadtbezirk: " + feature.properties.stadtbezirk + " [" + feature.properties.nrstadtbezirk + "]</br>"
			+ "Stadtteil: " + feature.properties.stadtteil + " [" + feature.properties.nrstadtteil + "]</br>";
		layer.bindPopup(text);
	}
});

$.getJSON("/wahlgebiet/service/stimmbezirke?geojson", function(data) {
	stimmbezirkeLayer.addData(data);
	map.addLayer(stimmbezirkeLayer);
	map.fitBounds(stimmbezirkeLayer.getBounds());
	
});

var wahllokalLayer = L.geoJson(null, {
	onEachFeature: function(feature, layer) {
		var text = ""
			+ "<b>" + feature.properties.WLK_NAME + "</b></br>"
			+ feature.properties.WLK_ADRESSE + "</br>"
			+ feature.properties.POSTZUSTELLBEZIRK + " K&ouml;ln</br>";
		layer.bindPopup(text);
	}
});
		
$.getJSON("/wahlgebiet/service/wahllokale?geojson", function(data) {
	wahllokalLayer.addData(data);
	map.addLayer(wahllokalLayer);
//	map.fitBounds(wahllokalLayer.getBounds());
});



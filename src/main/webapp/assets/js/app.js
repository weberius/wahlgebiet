var stamen = L.tileLayer('http://stamen-tiles-{s}.a.ssl.fastly.net/toner-lite/{z}/{x}/{y}.png',{
	attribution : 'Map tiles by <a href="http://stamen.com">Stamen Design</a>, <a href="http://creativecommons.org/licenses/by/3.0">CC BY 3.0</a> &mdash; Map data &copy; <a href="http://www.openstreetmap.org/copyright">OpenStreetMap</a>'
});

var map = L.map("map", {
	zoom : 13,
	center : [ 50.94135, 6.95819 ],
	layers : [ stamen ],
	zoomControl : true,
	attributionControl : true
});

function onEachFeature(feature, layer) {
	var text = ""
		+ "Stimmbezirk: " + feature.properties.NUMMER + "</br>"
		+ "Kommunalwahlbezirk: " + feature.properties.K_WAHL + "</br>"
		+ "Landtagswahlkreis: " + feature.properties.L_Wahl + "</br>"
		+ "Bundestagswahlkreis: " + feature.properties.B_Wahl + "</br>"
		+ "Stadtbezirk: " + feature.properties.STB + " [" + feature.properties.NR_STB + "]</br>"
		+ "Stadtteil: " + feature.properties.STT + " [" + feature.properties.NR_STT + "]</br>";
	layer.bindPopup(text);
}

var stimmbezirkeLayer = L.geoJson(null, {
	onEachFeature: onEachFeature
});

$.getJSON("/wahlgebiet/service/stimmbezirke?geojson", function(data) {
	stimmbezirkeLayer.addData(data);
	map.addLayer(stimmbezirkeLayer);
	map.fitBounds(stimmbezirkeLayer.getBounds());
	
});




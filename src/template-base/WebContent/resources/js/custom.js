PrimeFaces.locales['pt'] = {  
                closeText: 'Fechar',  
                prevText: 'Anterior',  
                nextText: 'Pr\u00f3ximo',  
                currentText: 'Come\u00e7o',  
                monthNames: ['Janeiro','Fevereiro','Mar\u00e7o','Abril','Maio','Junho','Julho','Agosto','Setembro','Outubro','Novembro','Dezembro'],  
                monthNamesShort: ['Jan','Fev','Mar','Abr','Mai','Jun', 'Jul','Ago','Set','Out','Nov','Dez'],  
                dayNames: ['Domingo','Segunda','Ter\u00e7a','Quarta','Quinta','Sexta','S\u00e1bado'],  
                dayNamesShort: ['Dom','Seg','Ter','Qua','Qui','Sex','S\u00e1b'],  
                dayNamesMin: ['D','S','T','Q','Q','S','S'],  
                weekHeader: 'Semana',  
                firstDay: 1,  
                isRTL: false,  
                showMonthAfterYear: false,  
                yearSuffix: '',  
                timeOnlyTitle: 'S\u00f3 Horas',  
                timeText: 'Tempo',  
                hourText: 'Hora',  
                minuteText: 'Minuto',  
                secondText: 'Segundo',  
                currentText: 'Data Atual',  
                ampm: false,  
                month: 'M\u00eas',  
                week: 'Semana',  
                day: 'Dia',  
                allDayText : 'Todo Dia'
};


function initMap() {
	var directionsService = new google.maps.DirectionsService;
	var directionsDisplay = new google.maps.DirectionsRenderer;
	var map = new google.maps.Map(document
			.getElementById('map'), {
		zoom : 4,
		center : {
			lat : -3.7924611,
			lng : -38.576754
		}
	});
	directionsDisplay.setMap(map);
	calculateAndDisplayRoute(directionsService,
			directionsDisplay);
}
function calculateAndDisplayRoute(
		directionsService, directionsDisplay) {
	directionsService
			.route(
					{
						origin : document
								.getElementById('start').value,
						destination : document
								.getElementById('end').value,
						travelMode : 'DRIVING'
					},
					function(response, status) {
						if (status === 'OK') {
							directionsDisplay
									.setDirections(response);
						} else {
							window
									.alert('Directions request failed due to '
											+ status);
						}
					});
}
var stompClient = null;

function setConnected(connected) {
    $("#connect").prop("disabled", connected);
    $("#disconnect").prop("disabled", !connected);
    if (connected) {
        $("#conversation").show();
    }
    else {
        $("#conversation").hide();
    }
    $("#greetings").html("");
}

function connect() {
	
	axios.post('/configure', {
		address: "169.254.1.1",
		antennaConfigurationGroup: {
			antennaConfigs: [
				{
					portNumber: 1,
					maxRxSensitivity: true,
					rxSensitivityInDbm: 40,
					maxTxPower: true,
					txPowerInDbm: 90,
				}
			]
		},
		reportConfig: {
			mode: 'Individual',
		},
		readerMode: 'AutoSetDenseReader',		
	})
	  .then(function (response) {
	    // handle success
	    console.log(response);
	  })
	  .catch(function (error) {
	    // handle error
	    console.log(error);
	  })
	  .then(function () {
	    // always executed
	  });
	
    var socket = new SockJS('/impinj');
    stompClient = Stomp.over(socket);
    stompClient.connect({
    	'username': 'username',
    	'password': 'password'
    }, function (frame) {
        setConnected(true);
        console.log('Connected: ' + frame);
        stompClient.subscribe('/impinj/169.254.1.1', function (greeting) {
            console.log('message received', JSON.parse(greeting.body));
        });        
    });
}

function disconnect() {
    if (stompClient !== null) {
        stompClient.disconnect();
    }
    setConnected(false);
    console.log("Disconnected");
}

function sendName() {
    stompClient.send("/readTags", {}, JSON.stringify({'name': $("#name").val()}));
}

function showGreeting(message) {
    $("#greetings").append("<tr><td>" + message + "</td></tr>");
}

$(function () {
    $("form").on('submit', function (e) {
        e.preventDefault();
    });
    $( "#connect" ).click(function() { connect(); });
    $( "#disconnect" ).click(function() { disconnect(); });
    $( "#send" ).click(function() { sendName(); });
});
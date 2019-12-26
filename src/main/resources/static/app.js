var stompClient = null;
var url = 'https://live.topicanative.edu.vn/socket';
var topicLmsVIP = '/topic/lmsVip/fullClass';

$(document).ready(function () {
  console.log("len len");
  connect();
});

function connect() {
	var headers = {
        'app': 'appSocial',
        'clientOs': 'abc',
        'clientType': 'WEB',
        'clientVersion': '1.0.0',
        'token': 'b8aeea7b-c278-436b-a594-b5978d68529a',
        'type': 'APP'
      };
	  var socket = new SockJS(url);
      stompClientPublic = Stomp.over(socket);
      stompClientPublic.connect(headers, function (frame) {
        console.log('myPublicSocket: stomp connected: ' + frame);
		stompClientPublic.subscribe("/topic/application/appSocial", function (message) {
			showMessageVIP(message.body);
		});
        connectedPublish = true;
      });
}


function showMessageVIP(message) {
  var td1 = document.getElementById('lms-vip');
  var text = document.createTextNode(message);
  td1.appendChild(text);
}

	
window.onload = function(){
	let myDrawer = document.getElementById("myDrawer");
	let url = "ws://10.0.101.218:8080/BradWeb2/mycenter"
	let webSocket = new WebSocket(url);
	let isConnect = false;
	
	webSocket.onopen = function(){
		isConnect = true;
	}
	webSocket.onmessage = function(event){
		if (isConnect){
			let mesgObj = JSON.parse(event.data);
			if (mesgObj.isClear){
				clear();
			}else{
				if (mesgObj.isNewLine){
					newLine(mesgObj.x, mesgObj.y);
				}else{
					drawLine(mesgObj.x, mesgObj.y);
				}
			}
		}
	}
	webSocket.onclose = function(){
		isConnect = false;
	}
	
	//-------------------------
	let ctx = myDrawer.getContext("2d");
	
	function clear(){ctx.clearRect(0,0,myDrawer.width, myDrawer.height);}
	function newLine(x, y){
		ctx.lineWidth = 4;
		ctx.beginPath();
		ctx.moveTo(x, y);		
	}
	function drawLine(x, y){
		ctx.lineTo(x,y);
		ctx.stroke();		
	}
	
}
window.onload = function(){
	let clear = document.getElementById("clear");
	let myDrawer = document.getElementById("myDrawer");
	let url = "ws://10.0.101.218:8080/BradWeb2/mycenter"
	let webSocket = new WebSocket(url);
	let isConnect = false;
	
	webSocket.onopen = function(){
		isConnect = true;
		webSocket.send(JSON.stringify({isTeacher: true}));
	}
	webSocket.onclose = function(){
		isConnect = false;
	}
	
	//-------------------------
	let isDrag = false;
	let ctx = myDrawer.getContext("2d");
	myDrawer.onmousedown = function(e){
		isDrag = true;
		let x = e.offsetX, y = e.offsetY;
		ctx.lineWidth = 4;
		ctx.beginPath();
		ctx.moveTo(x, y);
		//--------------
		let data = {
			isClear: false,
			isNewLine: true,
			x: x,
			y: y
		};
		webSocket.send(JSON.stringify(data));
		
	}
	myDrawer.onmouseup = function(e){
		isDrag = false;
	}
	myDrawer.onmousemove = function(e){
		if (isDrag){
			let x = e.offsetX, y = e.offsetY;
			ctx.lineTo(x,y);
			ctx.stroke();
			//--------------
			let data = {
				isClear: false,
				isNewLine: false,
				x: x,
				y: y
			};
			webSocket.send(JSON.stringify(data));
			
		}
	}
	
	clear.addEventListener("click",function(){
		ctx.clearRect(0,0,myDrawer.width, myDrawer.height);
		//--------------
		let data = {
			isClear: true
		};
		webSocket.send(JSON.stringify(data));
		
	});
	
}
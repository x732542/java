function uploadFile(){
	let fileInput = document.getElementById("fileInput");
	let file = fileInput.files[0];
	
	let reader = new FileReader();
	
	reader.onload = function(){
		let base64Full = reader.result;
		let base64 = base64Full.split(",")[1];
		
		let data = {
			fileName: file.name,
			contentType: file.type,
			base64: base64
		};
		
		console.log(JSON.stringify(data));
		let url = "/api/members/upload/base64";
		fetch(url,{
			method: 'POST',
			headers: {
				"Content-Type": "application/json"
			},
			body: JSON.stringify(data)
		})
		.then()
		.catch();
		
		
	};
		
	reader.onerror = function(){
		alert("File Read Failure");
	};
	
	reader.readAsDataURL(file); //***重要*** 沒用沒轉換
	
	
}
function clickTest() {
var test = document.getElementById('test');
console.log(test);
}

document.getElementById("submitdate").style.visibility = 'hidden';

function inputdate($this) {
	var reg = document.getElementById('submitdate');
	console.log(reg)
	if($this.value != ""){
		console.log("満");		
		reg.style.visibility = 'visible';
	}else{
		console.log("空");		
		reg.style.visibility = 'hidden';
	}	
}

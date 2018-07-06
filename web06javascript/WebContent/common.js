function test() {
	// location.href='#a1';
	console.log("test()...");
	var a1 = document.getElementById("a1");
	var a2 = document.getElementById("a2");
	var a3 = document.getElementById("a3");
	console.log(a1);
	console.log(a2);
	console.log(a3);
	a1.innerHTML = "<h1>aaa</h1>";
	a2.innerText = "<h1>bbb</h1>";
	a3.innerText = new Date();
}

function display() {
	console.log("display()....");
	var btn1 = document.getElementById("btn1");
	btn1.innerText = "onclick";
}
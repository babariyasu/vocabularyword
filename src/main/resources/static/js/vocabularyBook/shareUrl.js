function copyUrl() {
	const url = document.getElementById("shareUrl").value;
	
	navigator.clipboard.writeText(url);
	
	document.getElementById("copyMessage").textContent = "URLをコピーしました。";
}
document.addEventListener("DOMContentLoaded", function() {

	const editModal = document.getElementById("editWordModal");

	editModal.addEventListener("show.bs.modal", function(event) {

		const button = event.relatedTarget;

		const id = button.getAttribute("data-id");
		const name = button.getAttribute("data-name");
		const meaning = button.getAttribute("data-meaning");

		document.getElementById("editName").value = name;
		document.getElementById("editMeaning").value = meaning;

		const form = document.getElementById("editWordForm");
		form.action = "/words/" + id + "/update";
	});
});
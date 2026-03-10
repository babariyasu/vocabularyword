document.addEventListener("DOMContentLoaded", function() {

	const deleteModal = document.getElementById("deleteWordModal");

	deleteModal.addEventListener("show.bs.modal", function(event) {

		const button = event.relatedTarget;
		const wordId = button.getAttribute("data-word-id");

		const form = document.getElementById("deleteWordForm");

		form.action = "/words/" + wordId + "/delete";
	});
});
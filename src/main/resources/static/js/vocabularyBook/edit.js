const editModal = document.getElementById('editBookModal');

editModal.addEventListener('show.bs.modal', function(event) {

	const button = event.relatedTarget;

	const bookId = button.getAttribute('data-id');
	const bookTitle = button.getAttribute('data-title');

	document.getElementById('editBookId').value = bookId;
	document.getElementById('editBookTitle').value = bookTitle;

	document.getElementById('editBookForm').action =
		'/vocabulary-books/' + bookId + '/update';
});
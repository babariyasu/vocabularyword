const deleteModal = document.getElementById('deleteBookModal');

deleteModal.addEventListener('show.bs.modal', function(event) {

	const button = event.relatedTarget;

	const bookId = button.getAttribute('data-id');
	const bookTitle = button.getAttribute('data-title');

	// タイトル表示
	document.getElementById('modalBookTitle').textContent = bookTitle;

	// actionを動的設定
	document.getElementById('deleteBookForm').action =
		'/vocabulary-books/' + bookId + '/delete';
});
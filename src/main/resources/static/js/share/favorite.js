document.getElementById("favoriteCheckbox")
  .addEventListener("change", function () {

    const bookId = this.dataset.bookId;
    const checked = this.checked;

    fetch("/api/favorites", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify({
            bookId: bookId,
            favorite: checked
        })
    });
});
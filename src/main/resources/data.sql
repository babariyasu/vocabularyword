/* usersテーブル */
INSERT IGNORE INTO users (id, name, furigana, email, password, enabled) VALUES (1, '馬塲 孝佳', 'ババ タカヨシ', 'test@example.com', '$2a$10$2JNjTwZBwo7fprL2X4sv.OEKqxnVtsVQvuXDkI8xVGix.U3W5B7CO', true);

/* vocabulary_booksテーブル */
INSERT IGNORE INTO vocabulary_books (id, title, user_id) VALUES 
(1, 'テスト1', 1),
(2, 'テスト2', 1),
(3, 'テスト3', 1),
(4, 'テスト4', 2),
(5, 'テスト5', 2);

/* wordsテーブル */
INSERT IGNORE INTO words (id, word, meaning, vocabulary_book_id) VALUES
(1, '単語1', 'この単語の意味は単語という意味です。', 1),
(2, '単語2', 'この単語の意味は単語という意味です。', 1),
(3, '単語3', 'この単語の意味は単語という意味です。', 1),
(4, '単語4', 'この単語の意味は単語という意味です。', 2),
(5, '単語5', 'この単語の意味は単語という意味です。', 2);

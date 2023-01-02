package com.example.libdelivery.database.book

import androidx.room.Dao
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface BookDao {
    @Query("SELECT * FROM books ORDER BY title")
    fun getAllBooks(): Flow<List<Book>>

    @Query("SELECT b.id, b.title, b.image_url, b.authors, b.subject, b.year_published, b.copies_available, b.description, l.library_name, l.latitude, l.longitude FROM books b LEFT JOIN libraries l ON b.library_id = l.id")
    fun getAllBooksWithLibDetails(): Flow<List<BookWithLibDetails>>

    @Query("SELECT * FROM books WHERE title = :bookTitle ORDER BY title")
    fun getByBookTitle(bookTitle: String): Flow<List<Book>>
}
package com.shelf.book.application.createBook.exceptions

import java.lang.Exception

class CreateBookServiceException (message: String, cause: Throwable?): Exception(message, cause)
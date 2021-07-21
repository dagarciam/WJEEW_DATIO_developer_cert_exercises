package com.bbva.datioamproduct.fdevdatio.lessons

case class Book(
                 bookID: Int,
                 title: String,
                 authors: String,
                 averageRating: Double,
                 isbn: String,
                 isbn13: Long,
                 languageCode: String,
                 numPages: Int,
                 ratingsCount: Int,
                 textReviewsCount: Int,
                 publicationDate: String,
                 publisher: String
               ) extends Serializable

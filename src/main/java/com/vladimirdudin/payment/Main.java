package com.vladimirdudin.payment;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.vladimirdudin.payment.models.Book;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String filepath = "books.txt";
        List<Book> bookList;
        try {
            final Type listBooksType = new TypeToken<ArrayList<Book>>() {
            }.getType();
            bookList = new Gson().fromJson(new BufferedReader(new FileReader(filepath)), listBooksType);
        } catch (FileNotFoundException e) {
            throw new IllegalStateException(e);
        }

        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .disableHtmlEscaping()
                .create();

        System.out.println(gson.toJson(bookList));
    }
}

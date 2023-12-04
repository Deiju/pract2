package com.example.pract2

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteDatabase.CursorFactory
import android.database.sqlite.SQLiteOpenHelper
class Data(context: Context, cursorFactory: CursorFactory?):
SQLiteOpenHelper(context, "ListUsersData", cursorFactory, 1)
{

    override fun onCreate(p0: SQLiteDatabase) {
        val query = "CREATE TABLE users (id INT PRIMARY KEY, login TEXT, email TEXT, pass TEXT)"
        p0!!.execSQL(query)
    }

    override fun onUpgrade(p0: SQLiteDatabase, p1: Int, p2: Int) {
         p0.execSQL("DROP TABLE IF EXISTS users")
        onCreate(p0)
    }

    fun addUser(user: User) {
        val contentValues = ContentValues()
        contentValues.put("id", user.Id)
        contentValues.put("login", user.login)
        contentValues.put("email", user.email)
        contentValues.put("pass", user.password)
        val p0 = writableDatabase
        p0.insert("users", null, contentValues)
        p0.close()
    }
}
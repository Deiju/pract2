package com.example.pract2

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    lateinit var textView: TextView
    lateinit var button: Button
    lateinit var EditLogin : EditText
    lateinit var EditEmail : EditText
    lateinit var EditPassword : EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button=findViewById(R.id.Button)
        textView=findViewById(R.id.text)
        EditLogin=findViewById(R.id.Login)
        EditEmail=findViewById(R.id.Email)
        EditPassword=findViewById(R.id.Password)
        button.setOnClickListener {
            if(EditLogin.text.toString() !=""&& EditEmail.text.toString()!=""&& EditPassword.text.toString()!=""){
                if (!ProfEmail(EditEmail.text))
                {
                    Toast.makeText(this, "Был найден некорректный ввод эл. почты! Повторите попытку", Toast.LENGTH_SHORT).show()
                }
                else
                {
                    Toast.makeText(this, "Пользователь был добавлен!", Toast.LENGTH_SHORT).show()
                    val user = User(1,EditLogin.text.toString(), EditEmail.text.toString(), EditPassword.text.toString())
                    val p0 = Data(this,null)
                    p0.addUser(user)
                }
            }
            else{
                Toast.makeText(this,"Пустые поля",Toast.LENGTH_LONG).show()
            }
        }
    }
    private fun ProfEmail(email: CharSequence): Boolean {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }
}
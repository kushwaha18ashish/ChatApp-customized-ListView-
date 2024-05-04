package com.mjolnir.customizedlistview

import android.content.Intent
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import de.hdodenhof.circleimageview.CircleImageView

class UserActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_user)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val name=intent.getStringExtra("name")
        val mobile=intent.getStringExtra("mob")
        val message=intent.getStringExtra("lMsg")
        val profile=intent.getIntExtra("img",R.drawable.profile)

        val pName=findViewById<TextView>(R.id.tvUname)
        val pMobile=findViewById<TextView>(R.id.tvMob)
        val pProfile=findViewById<CircleImageView>(R.id.profile_image)
        val pMessage=findViewById<TextView>(R.id.tvLmsg)
        val back=findViewById<ImageView>(R.id.iv_back)
        val send=findViewById<ImageView>(R.id.ivSend)
        val newMsg=findViewById<EditText>(R.id.etNewMessage)

        pName.text=name
        pProfile.setImageResource(profile)
        pMobile.text=mobile
        pMessage.text=message

        back.setOnClickListener {
            intent= Intent(this,MainActivity::class.java)
            startActivity(intent)
            finish()
        }

        send.setOnClickListener {
            newMsg.text.clear()
            Toast.makeText(this,"I will work on it.",Toast.LENGTH_SHORT).show()
        }

    }
}
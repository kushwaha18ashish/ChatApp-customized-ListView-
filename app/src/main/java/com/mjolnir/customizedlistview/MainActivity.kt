package com.mjolnir.customizedlistview

import android.content.Intent
import android.os.Bundle
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    lateinit var userArrayList:ArrayList<User>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        var name= arrayOf("Aryan","Vibhas","Chitransh","Utkarsh","Vishesh","Ambrish","Akshat",
            "Shivam","Amit","Priyanshu","Dhruv","Shivang","Ujjwal","Mohit","Lekhansh")
        var lastMsg= arrayOf("Thala for a reason","Hi","I am good","cool","Wo tare aaye the",
            "ok","thank u","done","hi","thik h","Hi","I am good","cool","Hello","cool")
        var lastMsgTime= arrayOf("6:30 AM","10:25 AM","10:42 AM","4:54 PM","7:12 PM",
            "6:30 AM","10:25 AM","10:42 AM","4:54 PM","7:12 PM",
            "6:30 AM","10:25 AM","10:42 AM","4:54 PM","7:12 PM")
        var phoneNumber= arrayOf("9824357645","6205734123","9276452398","9645860924","6205674930",
            "9824357645","6205734123","9276452398","9645860924","6205674930",
            "9824357645","6205734123","9276452398","9645860924","6205674930")
        var imgId= intArrayOf(R.drawable.p1,R.drawable.p2,R.drawable.p3,R.drawable.p4,R.drawable.p5,
            R.drawable.p3,R.drawable.p2,R.drawable.p5,R.drawable.p1,R.drawable.p2,
            R.drawable.p4,R.drawable.p2,R.drawable.p5,R.drawable.p4,R.drawable.p1)


        userArrayList=ArrayList()

        for(i in name.indices){
            val user=User(name[i],lastMsg[i],lastMsgTime[i],phoneNumber[i],imgId[i])
            userArrayList.add(user)
        }
         var listView=findViewById<ListView>(R.id.lvListview)
        listView.isClickable=true
        listView.adapter=MyAdapter(this,userArrayList)
        listView.setBackgroundResource(R.drawable.bg_eachlistview)

        listView.setOnItemClickListener { adapterView, view, i, l ->
            val userName=name[i]
            val userPhone=phoneNumber[i]
            val userImgId=imgId[i]
            val userLastMsg=lastMsg[i]
            val userLastMessageTime=lastMsgTime[i]

            intent= Intent(this,UserActivity::class.java)
            intent.putExtra("name",userName)
            intent.putExtra("mob",userPhone)
            intent.putExtra("img",userImgId)
            intent.putExtra("lMsg",userLastMsg)
            startActivity(intent)
        }
    }
}
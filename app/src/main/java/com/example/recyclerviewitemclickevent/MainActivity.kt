package com.example.recyclerviewitemclickevent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val list = ArrayList<UserData>()
        list.add(UserData(R.drawable.basic, "android", "안드로이드"))
        list.add(UserData(R.drawable.basic, "studio", "스튜디오"))
        list.add(UserData(R.drawable.list, "recyclerView", "리사이클러뷰"))
        list.add(UserData(R.drawable.click, "clickEvent", "클릭이벤트"))
        list.add(UserData(R.drawable.basic, "example", "예제"))
        list.add(UserData(R.drawable.touch, "ifYouPress", "누르면"))
        list.add(UserData(R.drawable.basic, "IdAndName", "ID와 이름이"))
        list.add(UserData(R.drawable.detail, "atDetailActivity", "detail 화면에"))
        list.add(UserData(R.drawable.print, "print", "출력되는"))
        list.add(UserData(R.drawable.basic, "ex", "예제입니다."))

        val adapter = RecyclerUserAdapter(list)
        lstUser.adapter = adapter
    }
}
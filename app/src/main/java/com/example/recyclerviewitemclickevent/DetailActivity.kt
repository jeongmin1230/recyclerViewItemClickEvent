package com.example.recyclerviewitemclickevent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        basicLoad()
    }

    private fun basicLoad() {
        val id = intent.getStringExtra("id") // id 받아오기
        val name = intent.getStringExtra("name") // name 받아오기
        val img = intent.getIntExtra("img", 0) // img 받아오기

        detailId.text = id
        detailName.text = name
        detailIv.setImageResource(img)
    }
}
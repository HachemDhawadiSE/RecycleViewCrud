package dsi32.app.crudrecycle

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class NewsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news2)

        val headingNews :TextView = findViewById(R.id.heading)
        val mainNews : TextView = findViewById(R.id.news)
        val imageNews : ImageView = findViewById(R.id.image_heading)

        val bundle : Bundle?=intent.extras
        val heading=bundle!!.getString("heading")
        val imageId=bundle.getInt("imageId")
        val news=bundle.getString("news")

        headingNews.text=heading
        mainNews.text=news
        imageNews.setImageResource(imageId)
    }
}
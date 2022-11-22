package dsi32.app.crudrecycle

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.helper.ItemTouchHelper
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var newRecyclerview : RecyclerView
    private lateinit var newArraylist : ArrayList<News>
    lateinit var imageId:Array<Int>
    lateinit var heading:Array<String>
    lateinit var news : Array<String>
    lateinit var btn : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imageId= arrayOf(
            R.drawable.tunisie,
            R.drawable.england,
            R.drawable.france,
            R.drawable.germany,
            R.drawable.italy,
            R.drawable.russia,
            R.drawable.turky,
            R.drawable.ukraine,
            R.drawable.brazil,
        )
        heading= arrayOf(
            "Tunis","England","France","Germany","Italy","Ruissa","Turky","Ukraine","Brazil"
        )

        news= arrayOf(
            getString(R.string.Tunis),
            getString(R.string.England),
            getString(R.string.France),
            getString(R.string.Germany),
            getString(R.string.Italy),
            getString(R.string.Ruissa),
            getString(R.string.Turky),
            getString(R.string.Ukraine),
            getString(R.string.Brazil),
        )

        newRecyclerview=findViewById(R.id.recyclerView)
        newRecyclerview.layoutManager=LinearLayoutManager(this)
        newRecyclerview.setHasFixedSize(true)
        newArraylist= arrayListOf<News>()
        getUserdata()

    }

    private fun getUserdata(){
        for(i in imageId.indices){
            val news = News(imageId[i],heading[i])
            newArraylist.add(news)
        }
        var adapter = MyAdapter(newArraylist)

        newRecyclerview.adapter=adapter
        adapter.setOnItemClickListner(object : MyAdapter.onItemCickeListner{
            override fun onItemClick(position: Int) {
                //Toast.makeText(this@MainActivity, "you clicked  $position", Toast.LENGTH_SHORT).show()
                val intent=Intent(this@MainActivity,NewsActivity::class.java)
                intent.putExtra("heading",newArraylist[position].heading)
                intent.putExtra("imageId",newArraylist[position].titleImage)
                intent.putExtra("news",news[position])
                startActivity(intent)
            }

        })
    }
}
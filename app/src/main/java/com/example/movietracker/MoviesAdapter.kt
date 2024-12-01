package com.example.movietracker

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import org.w3c.dom.Text

class MoviesAdapter (private val movieList: List<Movies>, private val clickListener:(Movies)-> Unit, ): RecyclerView.Adapter<MoviesAdapter.MoviesHolder>(){
    class MoviesHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val movieTitle: TextView = itemView.findViewById(R.id.title)
        val movieDesc: TextView = itemView.findViewById(R.id.desc)
        val isMovie: ImageView = itemView.findViewById(R.id.isMovie)
        val isWached : CheckBox = itemView.findViewById(R.id.check)
        val movieComment: TextView = itemView.findViewById(R.id.comment)
        val movieScore: TextView= itemView.findViewById(R.id.score)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.movies, parent, false)
        return MoviesHolder(itemView)
    }


    override fun onBindViewHolder(holder: MoviesHolder, position: Int) {
        val thisMovie = movieList[position]
        holder.movieTitle.text = thisMovie.title
        holder.movieScore.text = ("${thisMovie.score}/10")
        holder.movieDesc.text = thisMovie.desc
        holder.movieComment.text = thisMovie.comment


        if(!thisMovie.isMovie){
            holder.isMovie.setImageResource(R.drawable.book)
            holder.isWached.text="przeczytane"
        }else{

            holder.isMovie.setImageResource(R.drawable.movie)
            holder.isWached.text="obejrzane"
        }

        if(thisMovie.isWatched){
            holder.isWached.isChecked=true
        }else{
            holder.isWached.isChecked=false
        }

        holder.itemView.setOnClickListener {
            clickListener(thisMovie)
        }

    }

    override fun getItemCount(): Int = movieList.size;
}

package com.example.movietracker

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import org.w3c.dom.Text

class MoviesAdapter (private val movieList: List<Movies>): RecyclerView.Adapter<MoviesAdapter.MoviesHolder>(){
    class MoviesHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val movieTitle: TextView = itemView.findViewById(R.id.title)
        val movieDesc: TextView = itemView.findViewById(R.id.desc)
        val isMovie: ImageView = itemView.findViewById(R.id.isMovie)
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
        holder.movieScore.text = thisMovie.score.toString()
        holder.movieDesc.text = thisMovie.desc
        holder.movieComment.text = thisMovie.comment

    }

    override fun getItemCount(): Int = movieList.size;
}

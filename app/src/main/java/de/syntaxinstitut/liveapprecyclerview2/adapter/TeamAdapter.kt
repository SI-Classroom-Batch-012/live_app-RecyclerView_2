package de.syntaxinstitut.liveapprecyclerview2.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import de.syntaxinstitut.liveapprecyclerview2.data.Team
import de.syntaxinstitut.liveapprecyclerview2.databinding.ListItemBinding



class TeamAdapter(
    val dataset: List<Team>,
) : RecyclerView.Adapter<TeamAdapter.TeamViewHolder>() {

    inner class TeamViewHolder(val binding: ListItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeamViewHolder {
        val binding = ListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TeamViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return dataset.size
    }

    override fun onBindViewHolder(holder: TeamViewHolder, position: Int) {
        val team = dataset[position]


        holder.binding.nameTV.text = team.name
        holder.binding.scoreTV.text = team.score.toString()
//        holder.binding.scoreTV.text = "${team.score}"


    }

}
package de.syntaxinstitut.liveapprecyclerview2.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import de.syntaxinstitut.liveapprecyclerview2.data.Team
import de.syntaxinstitut.liveapprecyclerview2.databinding.ListItemBinding



class TeamAdapter(
    val dataset: MutableList<Team>,
) : RecyclerView.Adapter<TeamAdapter.TeamViewHolder>() {

    inner class TeamViewHolder(val binding: ListItemBinding) : RecyclerView.ViewHolder(binding.root)


    fun addTeam(newTeam: Team) {
        dataset.add(0, newTeam)
        notifyItemInserted(0)
        //notifyDataSetChanged()
    }


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

        holder.binding.teamCV.setOnClickListener {

            team.score += 1
            Log.d("ScoreDebug", "$team")
            //holder.binding.scoreTV.text = team.score.toString()

            notifyItemChanged(holder.adapterPosition)

            sortTeams()
        }

        holder.binding.imageButton.setOnClickListener {

            //Team aus der Liste löschen
            dataset.removeAt(holder.adapterPosition)

            //Adapter informieren was sich verändert hat
            notifyItemRemoved(holder.adapterPosition)
            //notifyItemRangeChanged(position, dataset.size-1)
            //notifyDataSetChanged()

        }


    }

    fun sortTeams() {

        //Sortiere dataset
        dataset.sortByDescending {team ->
            team.score
        }

        //Aktualisiere Views
        notifyDataSetChanged()

    }

}
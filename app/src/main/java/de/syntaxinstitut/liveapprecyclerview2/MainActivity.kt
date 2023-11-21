package de.syntaxinstitut.liveapprecyclerview2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import de.syntaxinstitut.liveapprecyclerview2.adapter.TeamAdapter
import de.syntaxinstitut.liveapprecyclerview2.data.Datasource
import de.syntaxinstitut.liveapprecyclerview2.data.Team
import de.syntaxinstitut.liveapprecyclerview2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Dataset laden und testweise ausgeben
        val dataset : List<Team> = Datasource().loadTeams()
        Log.d("DatasetLog", "$dataset")

        //Adapter erstellen und zuweisen
        val adapter = TeamAdapter(dataset)
        binding.teamRV.adapter = adapter


    }
}
package de.syntaxinstitut.liveapprecyclerview2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import de.syntaxinstitut.liveapprecyclerview2.ui.adapter.TeamAdapter
import de.syntaxinstitut.liveapprecyclerview2.data.Datasource
import de.syntaxinstitut.liveapprecyclerview2.data.Team
import de.syntaxinstitut.liveapprecyclerview2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding

    var dataset: List<Team> = emptyList()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        dataset = Datasource().loadTeams()


    }

    //region Daten-Management

    fun addTeam(newTeam: Team){
        dataset = listOf(newTeam) + dataset
    }

    //endregion
}
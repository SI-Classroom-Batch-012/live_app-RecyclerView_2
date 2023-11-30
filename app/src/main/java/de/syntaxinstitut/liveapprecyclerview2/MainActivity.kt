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

//        //Dataset laden und testweise ausgeben
//        val dataset : MutableList<Team> = Datasource().loadTeams()
//        Log.d("DatasetLog", "$dataset")
//
//        //Adapter erstellen und zuweisen
//        adapter = TeamAdapter(dataset)
//        binding.teamRV.adapter = adapter
//
//
//        binding.addFAB.setOnClickListener {
//
//            addTeamDialog()
//
//        }

    }

    //Diese Funktion soll den Dialog erstellen der die Eingabe eines Namens ermöglicht
    //Und dann ein neues Team mit diesem Namen erstellt
//    fun addTeamDialog() {
//
//        val dialogBuilder = AlertDialog.Builder(this)
//
//        //Layout bestimmen
//        dialogBuilder.setTitle("Team hinzufügen")
//        val nameET = EditText(this)
//        dialogBuilder.setView(nameET)
//
//        //Aktionen bestimmen
//        dialogBuilder.setPositiveButton("Hinzufügen") { dialogInterface, number ->
//
//            //Ein neues Team hinzufügen
//            val name = nameET.text.toString()
//            val myTeam : Team = Team(name, 0)
//            adapter.addTeam(myTeam)
//
//
//            //Scroll an den Anfang
//            binding.teamRV.scrollToPosition(0)
////        val lastPosition = adapter.itemCount - 1
//
//            adapter.sortTeams()
//        }
//
//        dialogBuilder.setNegativeButton("Abbrechen") { dialogInterface, _ ->
//            dialogInterface.cancel()
//        }
//
//        dialogBuilder.show()
//    }

}
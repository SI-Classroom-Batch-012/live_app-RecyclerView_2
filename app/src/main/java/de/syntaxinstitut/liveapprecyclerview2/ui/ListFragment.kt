package de.syntaxinstitut.liveapprecyclerview2.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.navigation.fragment.findNavController
import de.syntaxinstitut.liveapprecyclerview2.MainActivity
import de.syntaxinstitut.liveapprecyclerview2.R
import de.syntaxinstitut.liveapprecyclerview2.data.Datasource
import de.syntaxinstitut.liveapprecyclerview2.data.Team
import de.syntaxinstitut.liveapprecyclerview2.databinding.FragmentDetailBinding
import de.syntaxinstitut.liveapprecyclerview2.databinding.FragmentListBinding
import de.syntaxinstitut.liveapprecyclerview2.ui.adapter.TeamAdapter

class ListFragment : Fragment() {

    private lateinit var binding: FragmentListBinding

    private lateinit var adapter: TeamAdapter
    private lateinit var mainActivity: MainActivity


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mainActivity = activity as MainActivity

        //Adapter erstellen und zuweisen
        val dataset = mainActivity.dataset

        adapter = TeamAdapter(dataset)
        binding.teamRV.adapter = adapter


        binding.addFAB.setOnClickListener {

            addTeamDialog()

        }

    }

    //Diese Funktion soll den Dialog erstellen der die Eingabe eines Namens ermöglicht
    //Und dann ein neues Team mit diesem Namen erstellt
    fun addTeamDialog() {

        val dialogBuilder = AlertDialog.Builder(requireContext())

        //Layout bestimmen
        dialogBuilder.setTitle("Team hinzufügen")
        val nameET = EditText(requireContext())
        dialogBuilder.setView(nameET)

        //Aktionen bestimmen
        dialogBuilder.setPositiveButton("Hinzufügen") { dialogInterface, number ->

            //Ein neues Team hinzufügen
            val name = nameET.text.toString()
            val myTeam: Team = Team(name, 0)

            //In den Daten aktualisiert
            mainActivity.addTeam(myTeam)

            //Daten neu laden und Adapter informieren
            adapter.newData(mainActivity.dataset)

            //Scroll an den Anfang
            binding.teamRV.scrollToPosition(0)
//        val lastPosition = adapter.itemCount - 1

            //adapter.sortTeams()
        }

        dialogBuilder.setNegativeButton("Abbrechen") { dialogInterface, _ ->
            dialogInterface.cancel()
        }

        dialogBuilder.show()
    }
}
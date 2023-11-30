package de.syntaxinstitut.liveapprecyclerview2.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import de.syntaxinstitut.liveapprecyclerview2.MainActivity
import de.syntaxinstitut.liveapprecyclerview2.R
import de.syntaxinstitut.liveapprecyclerview2.data.Datasource
import de.syntaxinstitut.liveapprecyclerview2.databinding.FragmentDetailBinding
import de.syntaxinstitut.liveapprecyclerview2.databinding.FragmentListBinding
import de.syntaxinstitut.liveapprecyclerview2.ui.adapter.TeamAdapter

class ListFragment : Fragment() {

    private lateinit var binding: FragmentListBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val mainActivity = activity as MainActivity

        val dataset = mainActivity.dataset
        val adapter = TeamAdapter(dataset)
        binding.teamRV.adapter = adapter



    }
}
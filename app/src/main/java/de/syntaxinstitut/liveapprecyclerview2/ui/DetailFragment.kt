package de.syntaxinstitut.liveapprecyclerview2.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import de.syntaxinstitut.liveapprecyclerview2.MainActivity
import de.syntaxinstitut.liveapprecyclerview2.R
import de.syntaxinstitut.liveapprecyclerview2.databinding.FragmentDetailBinding

class DetailFragment : Fragment() {

    private lateinit var binding: FragmentDetailBinding

    val args: DetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //(Daten)Team geladen werden
        val position = args.teamIndex
        val mainActivity = activity as MainActivity
        val team = mainActivity.dataset[position]


        //(Views)Detailinformation in Views schreiben
        binding.titleTV.text = team.name


    }
}
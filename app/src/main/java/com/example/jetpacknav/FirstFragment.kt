package com.example.jetpacknav

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.jetpacknav.databinding.FragmentFirstBinding

class FirstFragment : Fragment(), AnimalAdapter.Listener {

    private var _binding : FragmentFirstBinding? = null
    private val binding get() = _binding!!

    var animals = ArrayList<Animal>()
    lateinit var adapter: AnimalAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var lion = Animal("Alex", "Lion", getString(R.string.urlLion), getString(R.string.fullDescLion))
        var zebra = Animal("Marty", "Zebra", getString(R.string.urlZebra), getString(R.string.fullDescZebra))
        var mouse = Animal ("Mort", "Squirrel", getString(R.string.urlMouse), getString(R.string.fullDescMouse))

        animals.add(lion)
        animals.add(zebra)
        animals.add(mouse)
        adapter = AnimalAdapter(this ,animals, this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFirstBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val layoutManager = LinearLayoutManager(context)
        binding.rV.layoutManager = layoutManager
        binding.rV.adapter = adapter
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun onClick(itemView: Int) {
        val bundle = bundleOf(SecondFragment.numberInArray to itemView,
            SecondFragment.name to animals.get(itemView).name,
            SecondFragment.desc to animals.get(itemView).shortDescription,
            SecondFragment.url to animals.get(itemView).urlPhoto,
            SecondFragment.fullDesc to animals.get(itemView).fullDesc)
        findNavController().navigate(R.id.action_firstFragment_to_secondFragment, bundle)
    }


}


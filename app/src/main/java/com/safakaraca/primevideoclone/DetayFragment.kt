package com.safakaraca.primevideoclone

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.google.android.material.snackbar.Snackbar
import com.safakaraca.primevideoclone.databinding.FragmentDetayBinding


class DetayFragment : Fragment() {

    private lateinit var  tasarim : FragmentDetayBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        tasarim = FragmentDetayBinding.inflate(inflater, container, false)

        val bundle:DetayFragmentArgs by navArgs()
        val gelenFilm = bundle.film

        tasarim.toolbarDetay.title = gelenFilm.filmAdi
        tasarim.iwFilmResim.setImageResource(resources.getIdentifier(gelenFilm.filmResimAdi,"drawable",requireContext().packageName))
        tasarim.tvFilmYL.text = gelenFilm.filmBoyut.toString()
        tasarim.tvFilmFiyat.text = "${gelenFilm.filmBolumSayisi} episodes"

        tasarim.btnSepeteEkle.setOnClickListener {
            Snackbar.make(it,"${gelenFilm.filmAdi} sepete eklendi",Snackbar.LENGTH_SHORT).show()
        }


        return tasarim.root
    }

}
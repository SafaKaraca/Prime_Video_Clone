package com.safakaraca.primevideoclone

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.safakaraca.primevideoclone.databinding.FragmentAnasayfaBinding


class AnasayfaFragment : Fragment() {
    private lateinit var tasarim : FragmentAnasayfaBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        tasarim = FragmentAnasayfaBinding.inflate(inflater, container, false)

        tasarim.rv.layoutManager = LinearLayoutManager(requireContext())


        val filmlerListesi = ArrayList<Filmler>()
        val f1 = Filmler(1,"The Boys","theboys",6,368)
        val f2 = Filmler(2,"The Marvelous Mrs. Maisel","mrsmaisel",1,133)
        val f3 = Filmler(3,"Tom Clancy's Jack Ryan","jackryan",8,112)
        val f4 = Filmler(4,"The Wilds","thewilds",10,123)
        val f5 = Filmler(5,"The Expanse","expanse",10,246)
        val f6 = Filmler(6,"Invincible","invincible",8,189)
        val f7 = Filmler(7,"The Tomorrow War","tomorrow",1,753)

        filmlerListesi.add(f1)
        filmlerListesi.add(f2)
        filmlerListesi.add(f3)
        filmlerListesi.add(f4)
        filmlerListesi.add(f5)
        filmlerListesi.add(f6)
        filmlerListesi.add(f7)


        tasarim.textViewInfo.text = "${filmlerListesi.size.toString()} videos  -  9h 13min  -  1.1 GB "



        val adapter = FilmlerAdapter(requireContext(),filmlerListesi)
        tasarim.rv.adapter = adapter


        return tasarim.root
    }

}
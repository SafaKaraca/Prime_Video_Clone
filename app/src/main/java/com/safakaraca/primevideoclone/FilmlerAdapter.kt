package com.safakaraca.primevideoclone

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.safakaraca.primevideoclone.databinding.CardTasarimBinding


class FilmlerAdapter(var mContext: Context, var filmlerListesi:List<Filmler>) : RecyclerView.Adapter<FilmlerAdapter.CardTasarimTutucu>() {
    inner class CardTasarimTutucu(tasarim: CardTasarimBinding) : RecyclerView.ViewHolder(tasarim.root){
        var tasarim: CardTasarimBinding
        init {
            this.tasarim=tasarim
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardTasarimTutucu {
        val layoutInflater = LayoutInflater.from(mContext)
        val tasarim = CardTasarimBinding.inflate(layoutInflater,parent,false)
        return CardTasarimTutucu(tasarim)

    }

    override fun onBindViewHolder(holder: CardTasarimTutucu, position: Int) {
        val film = filmlerListesi.get(position)
        val t = holder.tasarim

        t.imageViewFilmResim.setImageResource(mContext.resources.getIdentifier(film.filmResimAdi,"drawable",mContext.packageName))

        t.textViewFilmAd.text = film.filmAdi
        t.textViewFilmBolum.text = "${film.filmBolumSayisi} episodes"
        t.imageViewArrow.setOnClickListener {
            //Snackbar.make(it,"${film.filmAdi} izleniyor",Snackbar.LENGTH_SHORT).show()
            val popup = androidx.appcompat.widget.PopupMenu(mContext,it)
            popup.menuInflater.inflate(R.menu.popup_menu,popup.menu)
            popup.show()
            popup.setOnMenuItemClickListener {
                when(it.itemId){
                    R.id.action_haber_ver -> {
                        Snackbar.make(t.imageViewArrow,"${film.filmAdi} haberdar edilmek üzere eklendi",Snackbar.LENGTH_SHORT).show()
                        true
                    }
                    R.id.action_favorilere_ekle -> {
                        Snackbar.make(t.imageViewArrow, "${film.filmAdi} favorilere eklendi",Snackbar.LENGTH_SHORT).show()
                        true
                    }
                    else -> false
                }
            }


        }
        t.textViewFilmBoyut.text = "${film.filmBoyut.toString()} MB"
       /* t.imageViewDahaFazla.setOnClickListener {
            val popup = androidx.appcompat.widget.PopupMenu(mContext,it)
            popup.menuInflater.inflate(R.menu.popup_menu,popup.menu)
            popup.show()
            popup.setOnMenuItemClickListener {
                when(it.itemId){
                    R.id.action_haber_ver -> {
                        Snackbar.make(t.imageViewDahaFazla,"${film.filmAdi} haberdar edilmek üzere eklendi",Snackbar.LENGTH_SHORT).show()
                        true
                    }
                    R.id.action_favorilere_ekle -> {
                        Snackbar.make(t.imageViewDahaFazla, "${film.filmAdi} favorilere eklendi",Snackbar.LENGTH_SHORT).show()
                        true
                    }
                    else -> false
                }
            }
        }*/

        /*t.cardViewFilm.setOnClickListener {
            val gecis = AnasayfaFragmentDirections.detayGecis(film = film)
            Navigation.findNavController(it).navigate(gecis)

        }*/

    }

    override fun getItemCount(): Int {
        return filmlerListesi.size
    }
}
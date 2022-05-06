package com.safakaraca.primevideoclone

import java.io.Serializable

data class Filmler(var filmId:Int,
                   var filmAdi:String,
                   var filmResimAdi:String,
                   var filmBolumSayisi:Int,
                   var filmBoyut:Int) : Serializable {

}
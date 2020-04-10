package com.example.capitalfinanceiro.classes

class Calc(var taxa : Double, var capital : Double, var meses : Int) {

    fun calc(): Double {
        return this.capital * (1 + this.taxa) * this.meses
    }
}

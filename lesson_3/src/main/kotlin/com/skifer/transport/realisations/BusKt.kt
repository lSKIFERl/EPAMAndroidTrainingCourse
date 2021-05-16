package com.skifer.transport.realisations

import com.skifer.enums.Color
import com.skifer.transport.TransportKt

class BusKt(
        override var color: Color,
        override var name: String,
        override var wheels: Int,
        override var capacity: Int,
        var doubleFloored: Boolean): TransportKt(color, name, wheels, capacity) {

    override fun printInfo() {
        println(this)
        if (doubleFloored)
            println("Божечки, да это ж великлопено!")
    }

    override fun toString(): String {
        return "BusKt(color='$color', name='$name', wheels=$wheels, capacity=$capacity, doubleFloored=$doubleFloored)"
    }

}
package com.skifer.transport.realisations

import com.skifer.transport.TransportKt

class MotorcycleKt(
        override var color: String,
        override var name: String,
        override var wheels: Int,
        override var capacity: Int,
        var type: String): TransportKt(color, name, wheels, capacity) {

    constructor(name: String): this("Black", name, 2, 1, "Скутер")

    override fun getInfo(){
        println("Быстро, шумно, круто \n$this")
    }

    override fun toString(): String {
        return "MotorcycleKt(color='$color', name='$name', wheels=$wheels, capacity=$capacity, type='$type')"
    }

}
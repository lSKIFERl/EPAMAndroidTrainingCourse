package com.skifer.transport

import com.skifer.enums.Color

/**
 * Абстрактный класс Транспорта
 */
abstract class TransportKt(
        /**
         * Цвет
         */
        protected open var color: Color,

        /**
         * Название
         */
        protected open var name: String,

        /**
         * Количество колёс
         */
        protected open var wheels: Int,

        /**
         * Возможная вместимость
         */
        protected open var capacity: Int) {

    /**
     * Информация об объекте
     */
    abstract fun printInfo()

    override fun toString(): String {
        return "(color='$color', name='$name', wheels=$wheels, capacity=$capacity)"
    }

}
package com.skifer.transport

/**
 * Абстрактный класс Транспорта
 */
abstract class TransportKt(
        /**
         * Цвет
         */
        protected open var color: String,

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
    abstract fun getInfo()

    override fun toString(): String {
        return "(color='$color', name='$name', wheels=$wheels, capacity=$capacity)"
    }

}
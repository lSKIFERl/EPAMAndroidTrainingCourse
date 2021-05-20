package com.skifer

import com.skifer.transport.Transport

/**
 * Simple garage class, contains only 1 transport
 */
class Garage<T : Transport> (private val transport: T) {

}
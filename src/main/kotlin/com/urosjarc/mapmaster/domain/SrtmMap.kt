package com.urosjarc.mapmaster.domain

import com.urosjarc.mapmaster.exceptions.SrtmException
import java.nio.ShortBuffer

class SrtmMap(
    val lat: Int,
    val lon: Int,
    val resolution: Int,
    private val data: ShortBuffer
) {
    private val MAGIC_DATA_VOID: Int = -32768

    private fun elevation(row: Int, col: Int): Float? {
        //Check if coordinates are out of bound
        if ((row < 0 || (this.resolution - 1) < row) || col < 0 || (this.resolution - 1) < col)
            throw SrtmException("Elevation coordinates out of bound: ($row, $col)")

        //Get buffer cell index
        val cell = (this.resolution * (this.resolution - row - 1)) + col

        //Is buffer cell index calculated right?
        if (data.limit() <= cell) throw SrtmException("Buffer size is smaller than calculated buffer cell.")

        //Get raw elevation data
        val elevation: Short = data[cell]

        //Check if elevation is not on void cell
        return if (elevation.toInt() == MAGIC_DATA_VOID) null else elevation.toFloat()
    }

    fun elevation(position: MapPosition): Float? {
        if ((position.lat < this.lat || position.lat >= this.lat + 1) || position.lon < this.lon || position.lon >= this.lon + 1)
            throw SrtmException("Elevation coordinates out of bound: $position")

        val latDelta = position.lat - this.lat
        val lonDelta = position.lon - this.lon

        val row = (this.resolution * latDelta).toInt()
        val col = (this.resolution * lonDelta).toInt()

        return elevation(row, col)
    }
}

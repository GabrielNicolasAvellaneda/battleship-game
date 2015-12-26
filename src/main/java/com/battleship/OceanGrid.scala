package com.battleship

import com.battleship.OceanGrid.OceanGridCellType
import com.battleship.OceanGrid.OceanGridCellType.OceanGridCellType

/**
 * Keep Track of Player's ships placements
 * @constructor
 * @param rows
 * @param cols
 */
class OceanGrid (rows: Int, cols: Int) extends BaseGrid[OceanGridCellType](rows, cols, OceanGridCellType.Empty) {
    def this() = this(OceanGrid.DefaultGridRows, OceanGrid.DefaultGridCols)

}

object OceanGrid {
    val DefaultGridRows = 10
    val DefaultGridCols = 10

    /**
     * Enumeration for Player's Ocean Grid position types.
     */
    object OceanGridCellType extends Enumeration {
        type OceanGridCellType = Value
        val Empty = Value
    }
}


package com.battleship

import com.battleship.OceanGrid.OceanGridCellType
import com.battleship.OceanGrid.OceanGridCellType.OceanGridCellType
import com.battleship.ShipType.ShipType

/**
 * Keep Track of Player's ships placements
 * @constructor
 * @param rows
 * @param cols
 */
class OceanGrid (rows: Int, cols: Int) extends BaseGrid[OceanGridCellType](rows, cols, OceanGridCellType.Empty) {

    def place(ship: Ship, row: String, col: Int, value: ShipPlacementDirection.Value) = {
       for (n <- 0 to ship.size) {
           val theMark = OceanGridCellType.fromShipType(ship.shipType)
           mark(theMark, row, col+n)
       }
    }

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
        val Empty, DestroyerShip = Value

        def fromShipType(shipType:ShipType) = shipType match {
            case ShipType.Destroyer => OceanGridCellType.DestroyerShip
            case _ => throw new NoSuchElementException
        }
    }

}



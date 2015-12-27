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

    def place(ship: Ship, row: String, col: Int, direction: ShipPlacementDirection.Value) = {
       val shipMark = OceanGridCellType.fromShipType(ship.shipType)
       for (n <- 0 to ship.size) {
           if (direction == ShipPlacementDirection.Down) {
               mark(shipMark, offsetRow(row, n), col)
           } else if (direction == ShipPlacementDirection.Right) {
               mark(shipMark, row, col+n)
           }
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



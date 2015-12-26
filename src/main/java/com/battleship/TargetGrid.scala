package com.battleship

import com.battleship.TargetGrid.TargetGridCellType
import com.battleship.TargetGrid.TargetGridCellType.TargetGridCellType

/**
 * Keep track of Opponent's Grid
 * @constructor Create a TargetGrid with the specified dimensions
 * @param rows Number of rows for the Grid
 * @param cols Number of columns for the Grid
 */
class TargetGrid(rows:Int, cols:Int) extends BaseGrid[TargetGridCellType](rows, cols, TargetGridCellType.Empty) {

  def this() = this(TargetGrid.GridDefaultRows, TargetGrid.GridDefaultCols)
}

object TargetGrid {
  val GridDefaultCols = 10
  val GridDefaultRows = 10

 /**
 * Enumeration for TargetGrid position types.
 */
  object TargetGridCellType extends Enumeration {
    type TargetGridCellType = Value
    val Empty, Hit, Miss = Value
  }
}

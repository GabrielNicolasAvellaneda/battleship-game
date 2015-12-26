package com.battleship

import TargetGridCellType._

class TargetGrid {

  import TargetGrid._

  val grid: Array[Array[TargetGridCellType]] = Array.fill(GridHeight, GridWidth)(TargetGridCellType.Empty)

  def check(col: String, row: Int) = {
    grid(0)(0)
  }

  def mark(value: TargetGridCellType, col: String, row: Int) = {
    grid(0)(0) = value
  }
}

object TargetGrid {
  val GridWidth = 10
  val GridHeight = 10
}

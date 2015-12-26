package com.battleship

import TargetGridCellType._

class TargetGrid {

  import TargetGrid._

  val grid = Array.fill(GridHeight, GridWidth)(TargetGridCellType.Empty)

  private def translateColumn(col:String) = {
    val c = col.toCharArray()(0)
    c - 'A'
  }

  private def position(col:String, row:Int) = {
    grid(translateColumn(col))(row-1)
  }

  def position(value: TargetGridCellType, col: String, row: Int) = {
    grid(translateColumn(col))(row-1) = value
  }

  def check(col: String, row: Int) = {
    position(col, row)
  }

  def mark(value: TargetGridCellType, col: String, row: Int) = {
    position(value, col, row)
  }
}

object TargetGrid {
  val GridWidth = 10
  val GridHeight = 10
}

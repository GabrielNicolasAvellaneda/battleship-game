package com.battleship

import TargetGridCellType._

class TargetGrid {

  val grid: Array[Array[TargetGridCellType]] = new Array(TargetGrid.GridHeight)
  for (y <- 0 until TargetGrid.GridHeight) {
    val arr = new Array[TargetGridCellType](TargetGrid.GridWidth)
    for (x <- 0 until TargetGrid.GridWidth) {
      arr(x) = TargetGridCellType.Empty
    }
    grid(y) = arr
  }

  def check(co: String, i: Int) = {
    grid(0)(0)
  }
}

object TargetGrid {
  val GridWidth = 10
  val GridHeight = 10
}

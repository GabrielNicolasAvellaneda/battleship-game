package com.battleship

import scala.reflect.ClassTag

/**
 * Created by developer on 26/12/2015.
 */
class BaseGrid[T:ClassTag] (rows:Int, cols: Int, emptyValue: T) {
  val grid = Array.fill[T](rows, cols)(emptyValue)

  private def translateColumn(col:String) = {
    val c = col.toCharArray()(0)
    c - 'A'
  }

  private def position(col:String, row:Int) = {
    grid(translateColumn(col))(row-1)
  }

  def position(value: T, col: String, row: Int) = {
    grid(translateColumn(col))(row-1) = value
  }

  def isPositionEmpty(col:String, row: Int) = {
    position(col, row) == emptyValue
  }

  def check(col: String, row: Int) = {
    position(col, row)
  }

  def mark(value: T, col: String, row: Int) = {
    if (!isPositionEmpty(col, row))
      throw new IllegalStateException("Can not mark an already marked position.")

    position(value, col, row)
  }
}

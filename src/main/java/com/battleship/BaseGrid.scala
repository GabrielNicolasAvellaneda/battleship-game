package com.battleship

import scala.reflect.ClassTag

/**
 * A Grid that can be indexed by an Alphabet letter for row and numbers starting at 1 for columns
 * Created by developer on 26/12/2015.
 */
class BaseGrid[T:ClassTag] (rows:Int, cols: Int, emptyValue: T) {
  val grid = Array.fill[T](rows, cols)(emptyValue)

  private def translateColumn(col:String) = {
    val c = col.toCharArray()(0)
    c - 'A'
  }

  private def position(row:String, col:Int) = {
    grid(translateColumn(row))(col-1)
  }

  def position(value: T, row: String, col: Int) = {
    grid(translateColumn(row))(col-1) = value
  }

  def isPositionEmpty(row:String, col: Int) = {
    position(row, col) == emptyValue
  }

  def check(row: String, col: Int) = {
    position(row, col)
  }

  def nextRow(row: String) = {
    (translateColumn(row)+1).toString
  }

  def mark(value: T, row: String, col: Int) = {
    if (!isPositionEmpty(row, col))
      throw new IllegalStateException("Can not mark an already marked position.")

    position(value, row, col)
  }
}

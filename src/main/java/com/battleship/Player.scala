package com.battleship

import com.battleship.OceanGrid.OceanGridCellType

/**
 * Created by developer on 27/12/2015.
 */
class Player (val oceanGrid: OceanGrid, val targetGrid: TargetGrid) {

  def this() = this(new OceanGrid, new TargetGrid)

  //var lives = Ship.Carrier.size + Ship.Cruiser.size + Ship.BattleShip.size + Ship.Submarine.size + Ship.Destroyer.size
  var lives = Ship.Destroyer.size

  def check(row: String, col: Int) = {
    val result = oceanGrid.check(row, col)
    if (result != OceanGridCellType.Empty) {
      lives -= 1
    }
    result
  }

  def isAlive = {
    lives > 0
  }
}

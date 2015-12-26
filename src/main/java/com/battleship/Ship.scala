package com.battleship

import com.battleship.ShipType.ShipType

/**
 * Created by developer on 26/12/2015.
 */
case class Ship (shipType: ShipType, size: Int) {

}

object Ship {
  val Carrier = new Ship(ShipType.Carrier, 5)
  val BattleShip = new Ship(ShipType.Battleship, 4)
  val Cruiser = new Ship(ShipType.Cruiser, 3)
  val Submarine = new Ship(ShipType.Submarine, 3)
  val Destroyer = new Ship(ShipType.Destroyer, 2)
}

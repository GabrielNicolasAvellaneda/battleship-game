package com.battleship

import com.battleship.BattleshipGame.GameStates

/**
 * Created by developer on 27/12/2015.
 */
class BattleshipGame {

  val player1 = new Player
  val player2 = new Player

  val state = GameStates.GameNotStarted

}

object BattleshipGame {

  object GameStates extends Enumeration {
    type GameStates = Value
    val GameNotStarted = Value
  }

}

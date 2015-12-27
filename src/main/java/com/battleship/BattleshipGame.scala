package com.battleship

import com.battleship.BattleshipGame.GameStates
import com.battleship.BattleshipGame.Players.PlayersEnum
import com.battleship.OceanGrid.OceanGridCellType
import com.battleship.OceanGrid.OceanGridCellType.OceanGridCellType

/**
 * The Game of Battleship.
 * This class works as a coordinator and as a facade for the different game objects.
 */
class BattleshipGame (player1: Player, player2: Player) {

  def this() = this(new Player, new Player)

  var currentPlayer: Option[PlayersEnum] = None
  var wonPlayer: Option[PlayersEnum] = None
  var state = GameStates.GameNotStarted

  def canStart = {
    state == GameStates.GameNotStarted || state == GameStates.GameOver
  }

  def start(player: PlayersEnum) = {
    if (!canStart)
      throw new IllegalStateException("Can not start the game right now")

    state = GameStates.GameStarted
    currentPlayer = Some(player)
    state
  }

  private def canCheck = {
    state == GameStates.GameStarted
  }

  def opponent = {
    if (currentPlayer.get == BattleshipGame.Players.Player1) {
      player2
    } else {
      player1
    }
  }

  def player = {
    if (currentPlayer.get == BattleshipGame.Players.Player1) {
      player1
    } else {
      player2
    }
  }

  def switchPlayer() = {
    if (currentPlayer.get == BattleshipGame.Players.Player1)  {
      currentPlayer = Some(BattleshipGame.Players.Player2)
    } else {
      currentPlayer = Some(BattleshipGame.Players.Player1)
    }
  }

  private def checkResultToTargetMark(result: OceanGridCellType)  = {
    if (result == OceanGridCellType.Empty) {
      TargetGrid.TargetGridCellType.Miss
    } else {
      TargetGrid.TargetGridCellType.Hit
    }
  }

  def gameOver(player: PlayersEnum) = {
    state = GameStates.GameOver
    wonPlayer = Some(player)
  }

  def check(row: String, col: Int) = {
    if (!canCheck) {
      throw new IllegalStateException("Can not check at this time")
    }

    val result = opponent.check(row, col)
    val mark = checkResultToTargetMark(result)
    player.targetGrid.mark(mark, row, col)

    if (!opponent.isAlive) {
      gameOver(currentPlayer.get)
    } else {
      switchPlayer()
    }
  }

}

object BattleshipGame {
  object Players extends Enumeration {
    type PlayersEnum = Value
    val Player1, Player2 = Value
  }

  object GameStates extends Enumeration {
    type GameStatesEnum = Value
    val GameNotStarted, GameOver, GameStarted = Value
  }


}

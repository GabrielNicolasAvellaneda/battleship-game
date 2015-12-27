import com.battleship._
import org.scalatest.{Matchers, FlatSpec}

/**
 */
class BattleshipGameTest extends FlatSpec with Matchers {

  "A BattleshipGame" should "be at GameNotStarted state by default" in {
    val game = new BattleshipGame
    game.state should be (BattleshipGame.GameStates.GameNotStarted)
  }

  "A BattleshipGame" should "start at GameNotStarted state" in {
    val game = new BattleshipGame
    game.start(BattleshipGame.Players.Player1) should equal (BattleshipGame.GameStates.GameStarted)
    game.currentPlayer.get should be (BattleshipGame.Players.Player1)
  }

  "A BattleShipGame" should "allow the current player to check opponent's board" in {
    val player1OceanGrid = new OceanGrid
    player1OceanGrid.place(Ship.Destroyer, "A", 1, ShipPlacementDirection.Right)
    val player1 = new Player(player1OceanGrid, new TargetGrid)

    val game = new BattleshipGame(player1, new Player)
    game.start(BattleshipGame.Players.Player2)
    game.check("A", 1)
    game.check("B", 2)
    game.check("A", 2)
    game.state should be (BattleshipGame.GameStates.GameOver)
    game.wonPlayer.get should be (BattleshipGame.Players.Player2)
  }

}

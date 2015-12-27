import com.battleship.BattleshipGame
import org.scalatest.{Matchers, FlatSpec}

/**
 * Created by developer on 27/12/2015.
 */
class BattleshipGameTest extends FlatSpec with Matchers {

  "A BattleshipGame" should "start at GameNotStarted state" in {
    val game = new BattleshipGame
    game.state should be (BattleshipGame.GameStates.GameNotStarted)
  }

}

import com.battleship.Player
import org.scalatest.{Matchers, FlatSpec}

/**
 * Created by developer on 27/12/2015.
 */
class PlayerTest extends FlatSpec with Matchers {

  "A Player" should "have an instance of OceanGrid and TargetGrid" in {
    val player = new Player
    player.oceanGrid should not be null
    player.targetGrid should not be null
  }

}

import com.battleship.{TargetGridCellType, TargetGrid}
import org.scalatest.{Matchers, FlatSpec}

/**
 * Created by developer on 26/12/2015.
 */
class TargetGridTest extends FlatSpec with Matchers {

  "A TargetGrid" should "check a cell position by X, Y coordinates" in {
    val targetGrid = new TargetGrid
    targetGrid.check("A", 1) should be (TargetGridCellType.Empty)
  }


}

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

  "A TargetGrid" should "should allow to mark a sell position as Hit" in {
    val targetGrid = new TargetGrid
    targetGrid.mark(TargetGridCellType.Hit, "A", 1)
    targetGrid.check("A", 1) should be (TargetGridCellType.Hit)

    targetGrid.mark(TargetGridCellType.Hit, "B", 2)
    targetGrid.check("B", 2) should be (TargetGridCellType.Hit)
  }

}

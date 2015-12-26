import com.battleship.{TargetGridCellType, TargetGrid}
import org.scalatest.{Matchers, FlatSpec}

/**
 * Created by developer on 26/12/2015.
 */
class TargetGridTest extends FlatSpec with Matchers {

  "A TargetGrid" should "check a grid position by X, Y coordinates" in {
    val targetGrid = new TargetGrid
    targetGrid.check("A", 1) should be (TargetGridCellType.Empty)
  }

  "A TargetGrid" should "allow to mark a grid position as Hit" in {
    val targetGrid = new TargetGrid
    targetGrid.mark(TargetGridCellType.Hit, "A", 1)
    targetGrid.check("A", 1) should be (TargetGridCellType.Hit)

    targetGrid.mark(TargetGridCellType.Hit, "B", 2)
    targetGrid.check("B", 2) should be (TargetGridCellType.Hit)
  }

  "A TargetGrid" should "allow to mark a grid position as a Miss" in {
    val targetGrid = new TargetGrid
    targetGrid.mark(TargetGridCellType.Miss, "C", 4)
    targetGrid.check("C", 4) should be (TargetGridCellType.Miss)

    targetGrid.mark(TargetGridCellType.Miss, "F", 5)
    targetGrid.check("F", 5) should be (TargetGridCellType.Miss)
  }

  "A TargetGrid" should "maintain state for grid position marks" in {
    val targetGrid = new TargetGrid
    targetGrid.mark(TargetGridCellType.Hit, "A", 3)
    targetGrid.mark(TargetGridCellType.Miss, "B", 4)

    targetGrid.check("A", 3) should be (TargetGridCellType.Hit)
    targetGrid.check("B", 4) should be (TargetGridCellType.Miss)
  }

  it should "throw ArrayIndexOutOfBoundsException if wrong coordinates are specified" in {
    val targetGrid = new TargetGrid
    a [ArrayIndexOutOfBoundsException] should be thrownBy {
      targetGrid.check("A", 0)
    }
    a [ArrayIndexOutOfBoundsException] should be thrownBy {
      targetGrid.check("K", 1)
    }
  }

  it should "throw IllegalStateException when trying to mark an already marked position" in {
    val targetGrid = new TargetGrid
    a [IllegalStateException] should be thrownBy {
      targetGrid.mark(TargetGridCellType.Hit, "A", 1)
      targetGrid.mark(TargetGridCellType.Miss, "A", 1)
    }
  }



}

import com.battleship.OceanGrid
import com.battleship.OceanGrid.OceanGridCellType
import org.scalatest.{FlatSpec, Matchers}

/**
 * Player's Grid with positioned ships
 */
class OceanGridTest extends FlatSpec with Matchers {

 "An OceanGrid" should "be empty after initialization" in {
   val oceanGrid = new OceanGrid
   oceanGrid.check("A", 1) should be (OceanGridCellType.Empty)
 }

}

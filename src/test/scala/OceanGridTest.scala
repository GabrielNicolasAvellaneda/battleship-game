import com.battleship.{ShipPlacementDirection, Ship, OceanGrid}
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

 "An OceanGrid" should "allow to place ships at X, Y positions" in {
   val oceanGrid = new OceanGrid
   oceanGrid.place(Ship.Destroyer, "A", 1, ShipPlacementDirection.Right)
   oceanGrid.check("A", 1) should be (OceanGridCellType.DestroyerShip)
   oceanGrid.check("A", 2) should be (OceanGridCellType.DestroyerShip)
 }

}

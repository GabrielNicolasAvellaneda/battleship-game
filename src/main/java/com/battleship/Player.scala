package com.battleship

/**
 * Created by developer on 27/12/2015.
 */
class Player (val oceanGrid: OceanGrid, val targetGrid: TargetGrid) {

  def this() = this(new OceanGrid, new TargetGrid)
}

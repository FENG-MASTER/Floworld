package com.fengmaster.game.floworld.base.world.gen;

import com.fengmaster.game.floworld.base.obj.entity.BaseGameEntity;
import com.fengmaster.game.floworld.base.world.CellWorld;
import com.fengmaster.game.floworld.base.world.node.WorldNode;

import java.util.List;
import java.util.Map;

/**
 *
 */
public interface BaseWorldGenerator {

    public void generateObj(CellWorld cellWorld);

    public Map<Long,Map<Long, Map<Long, WorldNode>>> generateWorldNode(CellWorld cellWorld);

}

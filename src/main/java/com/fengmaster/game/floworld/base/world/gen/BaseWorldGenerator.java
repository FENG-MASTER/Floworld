package com.fengmaster.game.floworld.base.world.gen;

import com.fengmaster.game.floworld.base.obj.BaseGameEntity;
import com.fengmaster.game.floworld.base.world.World;
import com.fengmaster.game.floworld.base.world.node.WorldNode;

import java.util.List;
import java.util.Map;

/**
 *
 */
public interface BaseWorldGenerator {

    public Map<Long,Map<Long, Map<Long, List<BaseGameEntity>>>> generateObj(World world);

    public Map<Long,Map<Long, Map<Long, WorldNode>>> generateWorldNode(World world);

}

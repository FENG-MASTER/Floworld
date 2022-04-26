package com.fengmaster.game.floworld.base.world.gen;

import cn.hutool.core.util.RandomUtil;
import com.almasb.fxgl.dsl.FXGL;
import com.fengmaster.game.floworld.base.obj.entity.BaseGameEntity;
import com.fengmaster.game.floworld.base.obj.entity.PhysicsEntity;
import com.fengmaster.game.floworld.base.obj.entity.gaseous.Fire;
import com.fengmaster.game.floworld.base.obj.entity.solid.Grass;
import com.fengmaster.game.floworld.base.obj.entity.solid.Soil;
import com.fengmaster.game.floworld.base.obj.entity.fluid.Oxygen;
import com.fengmaster.game.floworld.base.world.CellWorld;
import com.fengmaster.game.floworld.base.world.Point3D;
import com.fengmaster.game.floworld.base.world.node.WorldNode;
import lombok.extern.java.Log;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Log
public class PureWorldGenerator implements BaseWorldGenerator {

    private long length = 10;
    private long width = 10;
    private long height = 10;

    @Override
    public void generateObj(CellWorld cellWorld) {

        List<Point3D> emptyPoints = new ArrayList<>();

        for (int x = 0; x < length; x++) {
            for (int y = 0; y < width; y++) {
                for (int z = 0; z < height; z++) {
                    emptyPoints.add(new Point3D(x, y, z));
                }
            }

        }


        Map<Long, Map<Long, Map<Long, List<BaseGameEntity>>>> map = new HashMap<>();
        for (long z = 0; z < height; z++) {
            map.put(z, new HashMap<>());
            for (long x = 0; x < length; x++) {
                map.get(z).put(x, new HashMap<>());

                for (long y = 0; y < width; y++) {
                    map.get(z).get(x).put(y, new ArrayList<>());

                }

            }
        }

        for (long y = 0; y < width; y++) {
            for (long x = 0; x < length; x++) {
                PhysicsEntity grass;
                if (RandomUtil.getRandom().nextInt(10) > 7) {
                    grass = new Grass();
                } else {
                    grass = new Soil();
                }
                emptyPoints.remove(new Point3D(x, y, 0));
                grass.setCellCenter(new Point3D(x, y, 0));
                List<BaseGameEntity> list1 = map.get(0l).get(x).getOrDefault(y, new ArrayList<>());
                list1.add(grass);
                map.get(0l).get(x).put(y, list1);
                grass.setWorldName(cellWorld.getName());
                FXGL.getGameWorld().addEntity(grass);

                if (RandomUtil.getRandom().nextInt(100) > 96) {
                    PhysicsEntity cobble = new Fire(300);
                    cobble.setCellCenter(new Point3D(x, y, 0));
                    List<BaseGameEntity> list = map.get(0l).get(x).getOrDefault(y, new ArrayList<>());
                    list.add(cobble);
                    map.get(0l).get(x).put(y, list);
                    cobble.setWorldName(cellWorld.getName());
                    FXGL.getGameWorld().addEntity(cobble);

                }
            }
        }




        //补充氧气
        for (Point3D emptyPoint : emptyPoints) {
            Oxygen oxygen = new Oxygen();
            oxygen.setCellCenter(emptyPoint);
            oxygen.setWorldName(cellWorld.getName());
            List<BaseGameEntity> list = map.get(emptyPoint.getZ()).get(emptyPoint.getX()).getOrDefault(emptyPoint.getY(), new ArrayList<>());
            list.add(oxygen);
            map.get(emptyPoint.getZ()).get(emptyPoint.getX()).put(emptyPoint.getY(), list);

        }
        log.info("-----------地图数组-----------");

        String[][][] mapStr = new String[10][10][10];

        for (Map.Entry<Long, Map<Long, Map<Long, List<BaseGameEntity>>>> longMapEntry1 : map.entrySet()) {

            for (Map.Entry<Long, Map<Long, List<BaseGameEntity>>> longMapEntry2 : longMapEntry1.getValue().entrySet()) {
                for (Map.Entry<Long, List<BaseGameEntity>> longListEntry3 : longMapEntry2.getValue().entrySet()) {
                    mapStr[Math.toIntExact(longMapEntry1.getKey())][Math.toIntExact(longMapEntry2.getKey())][Math.toIntExact(longListEntry3.getKey())] = longListEntry3.getValue().stream().map(new Function<BaseGameEntity, String>() {
                        @Override
                        public String apply(BaseGameEntity baseGameEntity) {
                            return baseGameEntity.getName() + "|";
                        }
                    }).collect(Collectors.joining());
                }

            }

        }
        for (int i = 0; i < mapStr.length; i++) {
            log.info("----------------------");

            log.info("z=" + i);

            StringBuilder sb = new StringBuilder();

            for (int y = 0; y < mapStr[i].length; y++) {
                for (int x = 0; x < mapStr[i][y].length; x++) {
                    sb.append(mapStr[i][y][x]).append("   ");
                }
                sb.append("\n");

            }
            log.info(sb.toString());

            log.info("----------------------");

        }
        log.info("-----------地图数组-----------");


//        return map;
    }

    @Override
    public Map<Long, Map<Long, Map<Long, WorldNode>>> generateWorldNode(CellWorld cellWorld) {
        Map<Long, Map<Long, Map<Long, WorldNode>>> worldNodeMap = new HashMap<>();

        for (long z = 0; z < height; z++) {
            worldNodeMap.put(z, new HashMap<>());
            for (long x = 0; x < length; x++) {
                worldNodeMap.get(z).put(x, new HashMap<>());
                for (long y = 0; y < width; y++) {
                    worldNodeMap.get(z).get(x).put(y, new WorldNode(20, 50, 1000));
                }
            }
        }
        return worldNodeMap;
    }
}

package com.fengmaster.game.floworld.base.obj.display;

import cn.hutool.core.util.RandomUtil;

public class RandomDisplayComponent  extends DisplayComponent{
    @Override
    public String getTexture(Object o) {
        return textures.get(RandomUtil.randomInt(textures.size()));
    }
}

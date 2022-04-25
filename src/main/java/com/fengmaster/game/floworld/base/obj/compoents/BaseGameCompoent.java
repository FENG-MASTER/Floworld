package com.fengmaster.game.floworld.base.obj.compoents;

import com.almasb.fxgl.entity.component.Component;
import com.fengmaster.game.floworld.base.obj.entity.BaseGameEntity;
import lombok.Getter;
import lombok.Setter;

public class BaseGameCompoent extends Component {

    @Setter
    @Getter
    private BaseGameEntity parentGameEntity;
}

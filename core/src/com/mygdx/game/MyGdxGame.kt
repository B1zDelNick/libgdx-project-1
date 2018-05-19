package com.mygdx.game

import com.badlogic.gdx.Game
import com.mygdx.game.assets.Assets
import com.mygdx.game.views.SplashView

class MyGdxGame : Game() {

    override fun create() {
        Assets.loadPreloader()
        if (Assets.isReady()) {
            Assets.initPreloader()
            println("Init SPlash")
            setScreen(SplashView(this))
        }
    }

    override fun dispose() {
        super.dispose()
        Assets.dispose()
    }
}

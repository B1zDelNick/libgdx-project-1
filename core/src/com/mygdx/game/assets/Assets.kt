package com.mygdx.game.assets

import com.badlogic.gdx.assets.AssetManager
import com.badlogic.gdx.assets.loaders.TextureAtlasLoader
import com.badlogic.gdx.assets.loaders.TextureAtlasLoader.TextureAtlasParameter
import com.badlogic.gdx.assets.loaders.TextureLoader
import com.badlogic.gdx.assets.loaders.TextureLoader.TextureParameter
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.TextureAtlas
import com.badlogic.gdx.graphics.g2d.TextureRegion

object Assets {

    private val manager = AssetManager()

    private val textures = mutableMapOf<String, Texture>()
    private val textureAtlases = mutableMapOf<String, TextureAtlas>()

    fun loadPreloader() {
        val param = TextureAtlasParameter()
        manager.load("android/assets/atlases/splash.atlas", TextureAtlas::class.java, param)

        /*val param2 = TextureParameter()
        param2.minFilter = Texture.TextureFilter.Linear
        param2.genMipMaps = false
        manager.load("android/assets/textures/splash/bar.png", TextureAtlas::class.java, param)*/

        manager.finishLoading()
    }

    fun initPreloader() {
        textureAtlases["splash"] = manager.get("android/assets/atlases/splash.atlas", TextureAtlas::class.java)
        //textures["bar"] = manager.get("android/assets/textures/splash/bar.png", Texture::class.java)
    }

    fun loadAssets() {

    }

    fun initAsstes() {

    }

    fun getTextureByName(name: String): TextureRegion? {
        textureAtlases.values.forEach {
            if (it.findRegion(name) != null) {
                println("Passing ${it.findRegion(name)}")
                return it.findRegion(name) as TextureRegion
            }
        }
        return null
    }

    fun isReady() = manager.update()
    fun getProgress() = manager.progress

    fun dispose() {
        textureAtlases.onEach { it.value.dispose() }
    }
}
package me.rahulsengupta.utils

import android.content.Context
import android.graphics.drawable.Drawable
import androidx.appcompat.content.res.AppCompatResources
import androidx.core.graphics.drawable.DrawableCompat
import me.rahulsengupta.home.R

fun navigationItemBackground(context: Context): Drawable? {
    // Need to inflate the drawable and CSL via AppCompatResources to work on Lollipop
    var background =
        AppCompatResources.getDrawable(context, R.drawable.navigation_item_background)
    if (background != null) {
        val tint = AppCompatResources.getColorStateList(
            context, R.color.navigation_item_background_tint
        )
        background = DrawableCompat.wrap(background.mutate())
        background.setTintList(tint)
    }
    return background
}
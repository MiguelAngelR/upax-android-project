package com.upax.androidproject.common.navigation

import androidx.navigation.NavOptions

/**
 * Custom animation extension between screen using navigation.
 * @return nav
 */
fun NavOptions.Builder.withAnimation(): NavOptions.Builder =
    this.setEnterAnim(android.R.anim.fade_in).setPopEnterAnim(android.R.anim.fade_in)
        .setExitAnim(android.R.anim.fade_out).setPopExitAnim(android.R.anim.fade_out)
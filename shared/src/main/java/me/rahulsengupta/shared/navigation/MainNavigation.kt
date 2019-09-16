package me.rahulsengupta.shared.navigation

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.Toolbar
import me.rahulsengupta.shared.R
import me.rahulsengupta.shared.ui.BaseFragment

interface NavigationHost {
    fun registerToolbarWithNavigation(toolbar: Toolbar)
}

interface NavigationDestination {
    fun onUserInteraction() {}
}

open class NavigationFragment : BaseFragment(), NavigationDestination {

    protected var navigationHost: NavigationHost? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is NavigationHost) {
            navigationHost = context
        }
    }

    override fun onDetach() {
        super.onDetach()
        navigationHost = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val host = navigationHost ?: return
        val mainToolbar: Toolbar = view.findViewById(R.id.toolbar) ?: return
        mainToolbar.apply {
            host.registerToolbarWithNavigation(this)
        }
    }
}

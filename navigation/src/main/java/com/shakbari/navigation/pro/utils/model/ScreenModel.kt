package com.shakbari.navigation.pro.utils.model

import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisallowComposableCalls
import androidx.compose.runtime.remember
import com.shakbari.navigation.pro.utils.screen.Screen
import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.cancel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.plus

 val ScreenModel.coroutineScope: CoroutineScope
    get() = ScreenModelStore.getOrPutDependency(
        screenModel = this,
        name = "ScreenModelCoroutineScope",
        factory = { key -> MainScope() + CoroutineName(key) },
        onDispose = { scope -> scope.cancel() }
    )

@Composable
 inline fun <reified T : ScreenModel> Screen.rememberScreenModel(
    tag: String? = null,
    factory: @DisallowComposableCalls () -> T
): T =
    remember(ScreenModelStore.getKey<T>(this, tag)) {
        ScreenModelStore.getOrPut(this, tag, factory)
    }

 interface ScreenModel {

     fun onDispose() {}
}

 abstract class StateScreenModel<S>(initialState: S) : ScreenModel {

    protected val mutableState: MutableStateFlow<S> = MutableStateFlow(initialState)
     val state: StateFlow<S> = mutableState.asStateFlow()
}

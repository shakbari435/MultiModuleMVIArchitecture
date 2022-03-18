package com.shakbari.core.base.mvi
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

/**
 * Base class for [ViewModel] instances
 */
abstract class BaseViewModel<Intent : UiIntent, State : UiState, /*Effect : UiEffect*/> : ViewModel() {

    private val initialState : State by lazy { createInitialState() }
    abstract fun createInitialState() : State

    val currentState: State
        get() = uiState.value

    private val _uiState : MutableStateFlow<State> = MutableStateFlow(initialState)
    val uiState = _uiState.asStateFlow()

    private val _intent : MutableSharedFlow<Intent> = MutableSharedFlow()
    val intent = _intent.asSharedFlow()

/*    private val _effect : Channel<Effect> = Channel()
    val effect = _effect.receiveAsFlow()*/


    init {
        subscribeIntent()
    }

    /**
     * Start listening to Event
     */
    private fun subscribeIntent() {
        viewModelScope.launch {
            intent.collect {
                handleIntent(it)
            }
        }
    }

    /**
     * Handle each event
     */
    abstract fun handleIntent(intent : Intent)


    /**
     * Set new Event
     */
    fun setIntent(intent : Intent) {
        val newIntent = intent
        viewModelScope.launch { _intent.emit(newIntent) }
    }


    /**
     * Set new Ui State
     */
    protected fun setState(reduce: State.() -> State) {
        val newState = currentState.reduce()
        _uiState.value = newState
    }

    /**
     * Set new Effect
     */
/*    protected fun setEffect(builder: () -> Effect) {
        val effectValue = builder()
        viewModelScope.launch { _effect.send(effectValue) }
    }*/
}
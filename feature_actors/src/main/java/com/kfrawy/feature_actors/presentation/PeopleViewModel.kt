package com.kfrawy.feature_actors.presentation

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import com.kfrawy.core.component.model.ViewState
import com.kfrawy.core.utils.data
import com.kfrawy.feature_actors.domain.model.People
import com.kfrawy.feature_actors.domain.usecase.GetPeopleUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PeopleViewModel @Inject constructor(
    private val getPeopleUseCase: GetPeopleUseCase,
) : ViewModel() {

    var data:Flow<PagingData<People>> = emptyFlow()

    fun loadIntent(intent: PeopleIntent){
        when(intent){
            PeopleIntent.GetTrendingPeople -> {
                viewModelScope.launch {
                    loadPeople()
                }
            }
            is PeopleIntent.PersonClicked -> {

            }
        }

    }

    private fun loadPeople(){
        data = getPeopleUseCase.invoke()
    }




}
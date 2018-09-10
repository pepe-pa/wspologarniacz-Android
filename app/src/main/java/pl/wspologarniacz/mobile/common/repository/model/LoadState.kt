package pl.wspologarniacz.mobile.common.repository.model

import androidx.lifecycle.MutableLiveData

sealed class LoadState

class Idle : LoadState()
class Done : LoadState()
class InProgress(val mode: InProgressMode = InProgressMode.OVERALL) : LoadState()
class Error(val throwable: Throwable) : LoadState()

fun MutableLiveData<LoadState>.done() {
    postValue(Done())
}

fun MutableLiveData<LoadState>.inProgress(mode: InProgressMode = InProgressMode.OVERALL) {
    postValue(InProgress(mode))
}

fun MutableLiveData<LoadState>.error(t: Throwable?) {

    postValue(Error(t ?: Exception("unknown error")))
}

enum class InProgressMode { MORE, NEW, OVERALL }
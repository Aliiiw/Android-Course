package com.alirahimi.androidcourse.feature.post.presentation.viewmodel

import androidx.lifecycle.*
import com.alirahimi.androidcourse.feature.post.domain.data.model.PostResponse
import com.alirahimi.androidcourse.feature.post.domain.data.repository.PostRepository
import com.alirahimi.androidcourse.shared_component.api.API
import kotlinx.coroutines.launch

class PostViewModel(private val repository: PostRepository) : ViewModel() {

    //region Properties
    private val _posts = MutableLiveData<List<PostResponse.PostResponseItem>>()
    val posts: LiveData<List<PostResponse.PostResponseItem>> get() = _posts
    private val _loadingState = MutableLiveData<Boolean>()
    val loadingState: LiveData<Boolean> get() = _loadingState
    //endregion

    //region Methods
    fun getAllPost() {
        viewModelScope.launch {
            _loadingState.postValue(true)
            val response = repository.getAllPosts()
            if (response.isSuccess) {
                response.onSuccess {
                    _posts.postValue(it)
                    _loadingState.postValue(false)
                }.onFailure {
                    //
                }
            }
        }
    }
    //endregion

}

class PostModule {
    companion object {
        val watchRepository: PostRepository by lazy {
            PostRepository(API.baseUserService)
        }
    }
}

class PostViewModelFactory : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(PostViewModel::class.java)) {
            return PostViewModel(PostModule.watchRepository) as T
        }
        throw java.lang.IllegalArgumentException("wrong dependency")
    }
}
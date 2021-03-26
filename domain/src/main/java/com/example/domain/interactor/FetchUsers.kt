//package com.example.domain.interactor
//
//import com.example.domain.executor.CoroutineDispatcherProvider
//import com.example.domain.model.UserDomain
//import com.example.data.repository.UserRepository
//import kotlinx.coroutines.CoroutineDispatcher
//import reactivecircus.blueprint.interactor.EmptyParams
//import reactivecircus.blueprint.interactor.InteractorParams
//import reactivecircus.blueprint.interactor.coroutines.SuspendingInteractor
//
//class FetchUsers(
//    private val userRepository: UserRepository,
//    coroutineDispatcherProvider: CoroutineDispatcherProvider
//) : SuspendingInteractor<EmptyParams, Unit>() {
//    override val dispatcher: CoroutineDispatcher = coroutineDispatcherProvider.io
//
//    override suspend fun doWork(params: EmptyParams) {
//        userRepository
//    }
//}
//
////class FetchUsers constructor(
////    private val userRepository: UserRepository,
////    coroutineDispatcherProvider: CoroutineDispatcherProvider
////) : SuspendingInteractor<EmptyParams, Observable<List<UserDomain>>>() {
////
////    override val dispatcher: CoroutineDispatcher = coroutineDispatcherProvider.io
////
////    override suspend fun doWork(params: EmptyParams): Observable<List<UserDomain>> {
////        return userRepository.getAllUsers()
////    }
////}
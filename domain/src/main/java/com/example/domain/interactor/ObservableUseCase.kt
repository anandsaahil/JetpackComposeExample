package com.example.domain.interactor

//import com.example.domain.executor.PostExecutionThread
//import com.example.domain.executor.ThreadExecutor
//import io.reactivex.Observable
//import io.reactivex.Single
//import io.reactivex.disposables.CompositeDisposable
//import io.reactivex.disposables.Disposable
//import io.reactivex.observers.DisposableObserver
//import io.reactivex.schedulers.Schedulers
//
//abstract class ObservableUseCase<T, in Params> constructor(
//    private val threadExecutor: ThreadExecutor,
//    private val postExecutionThread: PostExecutionThread
//) {
//
//    private val disposables = CompositeDisposable()
//
//    /**
//     * Builds a [Single] which will be used when the current [SingleUseCase] is executed.
//     */
//    protected abstract fun buildUseCaseObservable(params: Params): Observable<T>
//
//    /**
//     * Executes the current use case.
//     */
//    open fun execute(observer: DisposableObserver<T>, params: Params) {
//        val observable = this.buildUseCaseObservable(params)
//            .subscribeOn(Schedulers.from(threadExecutor))
//            .observeOn(postExecutionThread.scheduler) as Observable<T>
//        addDisposable(observable.subscribeWith(observer))
//    }
//
//    open fun build(params: Params): Observable<T> {
//        val observable = this.buildUseCaseObservable(params)
//            .subscribeOn(Schedulers.from(threadExecutor))
//            .observeOn(postExecutionThread.scheduler) as Observable<T>
//        return observable
//    }
//
//    open fun getDisposables(): CompositeDisposable {
//        return disposables
//    }
//    /**
//     * Dispose from current [CompositeDisposable].
//     */
//    fun dispose() {
//        if (!disposables.isDisposed) disposables.dispose()
//    }
//
//    /**
//     * Dispose from current [CompositeDisposable].
//     */
//    private fun addDisposable(disposable: Disposable) {
//        disposables.add(disposable)
//    }
//
//}
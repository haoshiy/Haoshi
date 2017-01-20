package com.haoshi.rxjava.example4.common.baserx;


import com.haoshi.rxjava.example4.common.basebean.BaseResponse;
import com.haoshi.rxjava.example4.exception.NewsException;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by qihuang on 16-11-6.
 */

public class RxSchedulers {
    public static <T> Observable.Transformer<BaseResponse<T>, T> io_mainWithRespo() {
        return tObservable -> tObservable.flatMap(tBaseResponse -> {
            if (tBaseResponse.isStatus()) {
                return createData(tBaseResponse.result);
            } else {
                return Observable.error(new NewsException(tBaseResponse.reason));
            }
        }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }

    public static <T> Observable.Transformer<T, T> io_main() {
        return observable -> observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    private static <T> Observable<T> createData(final T data) {
        return Observable.create(subscribe -> {
            subscribe.onNext(data);
            subscribe.onCompleted();
        });
    }
}

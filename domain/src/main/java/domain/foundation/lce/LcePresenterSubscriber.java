/*
 * Copyright 2015 RefineriaWeb
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package domain.foundation.lce;

import rx.Subscriber;

/**
 * Provides a default subscriber for any
 * @see domain.foundation.Presenter which implements
 * @see LceView
 * @param <D> Describes the type parameter of the data which will be process by the Subscriber
 * @param <V> Describes the type parameter of the LceView
 */
public abstract class LcePresenterSubscriber<D, V extends LceView<D>> extends Subscriber<D> {
    private final V lceView;

    public LcePresenterSubscriber(V lceView) {
        this.lceView = lceView;
    }

    @Override public void onStart() {
        lceView.showProgress();
    }

    @Override public void onError(Throwable e) {
        lceView.hideProgress();
        lceView.showError(e.getMessage());
    }

    @Override public void onNext(D data) {
        lceView.hideProgress();
        lceView.showData(data);
    }

    @Override public void onCompleted() {}
}
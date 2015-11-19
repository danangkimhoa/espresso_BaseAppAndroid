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

package domain.foundation.schedulers;

import rx.Scheduler;

/**
 * Provides the Scheduler for any Observable to subscribeOn
 * This interfaces is injected by dagger and implemented in the presentation layer.
 * For example, in Android system you can use AndroidSchedulers.mainThread() using RxAndroid library
 */
public interface SubscribeOn {
    Scheduler getScheduler();
}
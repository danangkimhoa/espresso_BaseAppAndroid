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

package presentation.foundation;

import android.app.Application;
import android.support.annotation.Nullable;

import presentation.internal.di.ApplicationComponent;
import presentation.internal.di.ApplicationModule;
import presentation.internal.di.DaggerApplicationComponent;

/**
 * Custom Application
 */
public class BaseApp extends Application {
    private ApplicationComponent applicationComponent;

    @Override public void onCreate() {
        super.onCreate();
        initInject();
        AppCare.YesSir.takeCareOn(this);
    }

    private void initInject() {
        applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
    }

    public ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }

    @Nullable public BaseFragmentActivity getLiveActivity(){
        return (BaseFragmentActivity) AppCare.YesSir.getLiveActivityOrNull();
    }
}

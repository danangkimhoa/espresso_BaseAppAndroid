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

package domain.sections.user_demo.list;

import org.junit.Test;
import org.mockito.Mock;

import java.util.Arrays;
import java.util.List;

import domain.common.BaseTest;
import domain.sections.user_demo.UserDemoRepository;
import domain.sections.user_demo.entities.UserDemoEntity;
import rx.Observable;
import rx.observers.TestSubscriber;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.when;

public class GetUsersDemoUseCaseTest extends BaseTest {
    private GetUsersDemoUseCase getUsersDemoUseCaseUT;
    @Mock protected UserDemoRepository userDemoRepositoryMock;
    @Mock protected UserDemoEntity userDemoEntityMock;

    @Override public void setUp() {
        super.setUp();
        getUsersDemoUseCaseUT = new GetUsersDemoUseCase(UIMock, userDemoRepositoryMock);
    }

    @Test public void  When_Execute_Get_Users() {
        when(userDemoRepositoryMock.askForUsers()).thenReturn(Observable.just(Arrays.asList()));

        TestSubscriber<List<UserDemoEntity>> subscriberMock = new TestSubscriber<>();
        getUsersDemoUseCaseUT.react().subscribe(subscriberMock);
        subscriberMock.awaitTerminalEvent();

        assertThat(subscriberMock.getOnCompletedEvents().size(), is(1));
    }
}

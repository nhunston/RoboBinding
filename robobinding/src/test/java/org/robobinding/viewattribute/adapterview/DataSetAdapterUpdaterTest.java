/**
 * Copyright 2013 Cheng Wei, Robert Taylor
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions
 * and limitations under the License.
 */
package org.robobinding.viewattribute.adapterview;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import android.widget.Adapter;
import android.widget.AdapterView;

/**
 *
 * @since 1.0
 * @version $Revision: 1.0 $
 * @author Cheng Wei
 */
@RunWith(MockitoJUnitRunner.class)
public class DataSetAdapterUpdaterTest {
    @Mock
    private DataSetAdapterBuilder dataSetAdapterBuilder;
    @Mock
    private AdapterView<Adapter> adapterView;
    
    @SuppressWarnings("unchecked")
    @Test
    public void whenUpdate_thenSetNewDataSetAdapterOnAdapterView() {
	@SuppressWarnings("rawtypes")
	DataSetAdapter newDataSetAdapter = mock(DataSetAdapter.class);
	when(dataSetAdapterBuilder.build()).thenReturn(newDataSetAdapter);
	
	DataSetAdapterUpdater dataSetAdapterUpdater = new DataSetAdapterUpdater(dataSetAdapterBuilder, adapterView);
	
	dataSetAdapterUpdater.update();
	
	verify(adapterView).setAdapter(newDataSetAdapter);
	
    }
}

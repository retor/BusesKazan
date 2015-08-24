package com.retor.buslib.lib;

import android.test.InstrumentationTestCase;

import com.retor.buslib.lib.di.DaggerLoaderComponent;
import com.retor.buslib.lib.di.LoaderModule;
import com.retor.buslib.lib.model.BusModel;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import javax.inject.Inject;

import rx.observers.TestObserver;

/**
 * Created by retor on 13.08.2015.
 */
public class LoaderApiTest extends InstrumentationTestCase{
    LoaderApi api;
    TestObserver<List<BusModel>> observer;

    @Before
    public void setUp() throws Exception {
        api = DaggerLoaderComponent.builder().loaderModule(new LoaderModule()).build().LOADER_API();
        observer = new TestObserver<List<BusModel>>();
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testGetBussesList() throws Exception {
        api.getBussesList().subscribe(observer);
        assertNotNull(observer.getOnNextEvents());
    }
}
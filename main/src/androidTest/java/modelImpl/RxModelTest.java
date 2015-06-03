package modelImpl;

import model.IModel;
import modelImpl.beans.Bus;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import rx.Observable;

import java.util.List;

/**
 * Created by retor on 03.06.2015.
 */
public class RxModelTest {
    IModel<Observable<List<Bus>>> i = new RxModel();
    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testGetData() throws Exception {

    }
}
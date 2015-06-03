package modelImpl;

import modelImpl.beans.Bus;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.IModel;
import rx.Observable;
import rx.Subscriber;

import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

/**
 * Created by retor on 03.06.2015.
 */
public class RxModel implements IModel<Observable<List<Bus>>> {
    @Override
    public Observable<List<Bus>> getData(final String patch) {
        return Observable.create(new Observable.OnSubscribe<List<Bus>>() {
            @Override
            public void call(Subscriber<? super List<Bus>> subscriber) {
                try {
                    subscriber.onNext(getBusses(patch));
                } catch (IOException e) {
                    subscriber.onError(e);
                }
                subscriber.onCompleted();
            }
        });
    }

    private List<Bus> getBusses(String url) throws IOException {
        JsonFactory factory = new JsonFactory();
        JsonParser parser = factory.createParser(new URL(url));
        ObjectMapper mapper = new ObjectMapper();
        MappingIterator<Bus[]> iterator = mapper.readValues(parser, Bus[].class);
        List<Bus> l = Arrays.asList(iterator.nextValue());
        return l;
    }
}

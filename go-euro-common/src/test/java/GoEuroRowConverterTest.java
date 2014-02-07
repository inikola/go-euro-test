import org.goeuro.test.common.model.Converter;
import org.goeuro.test.common.model.GoEuroRowConvertor;
import org.goeuro.test.common.model.csv.GoEuroRow;
import org.goeuro.test.common.model.json.GeoPosition;
import org.goeuro.test.common.model.json.Result;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 *
 * Created by Nikola.Ivanov on 2/7/14.
 */
public class GoEuroRowConverterTest {


    private Converter<Result,GoEuroRow> converter;
    private Result result;
    private GoEuroRow goEuroRow;
    private static final Integer id = 1232414323;
    private static final String type = "Position";
    private static final String _type = "Position";
    private static final String name = "someName";
    private static final GeoPosition GEO_POSITION = new GeoPosition();


    @Before
    public void setUp(){
        converter = new GoEuroRowConvertor();

    }

    @Test
    public void testConverter(){
        initResult();
        goEuroRow =  converter.convertFrom(result);
        assertEquals(result.getGeoPosition().getLongitude(),goEuroRow.getLongitude());
        assertEquals(result.getGeoPosition().getLatitude(),goEuroRow.getLatitude());
        assertEquals(result.get_id(),goEuroRow.get_id());
        assertEquals(result.get_type(),goEuroRow.get_type());
        assertEquals(result.getName(),goEuroRow.getName());
        assertEquals(result.getType(),goEuroRow.getType());
    }



    private void initResult(){
        result = new Result();
        result.set_id(id);
        result.set_type(_type);
        result.setType(type);
        result.setName(name);
        GEO_POSITION.setLatitude(3.12);
        GEO_POSITION.setLongitude(43.44);
        result.setGeoPosition(GEO_POSITION);
    }
}
